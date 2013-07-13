package controllers;

import models.Option;
import models.Poll;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {

        List<Poll> polls = new Model.Finder(String.class, Poll.class).all();

        return ok(index.render(polls));
    }

    public static Result newPoll() {
        return ok(createPoll.render(form(Poll.class)));
    }

    public static Result showPoll(Long id) {
        Poll poll = Poll.find.byId(id);
        return ok(showPoll.render(poll, Option.findByPoll(id)));
    }

    public static Result submitPoll() {
        Form<Poll> form = form(Poll.class).bindFromRequest();
        if (form.hasErrors()) {
            List<Poll> polls = new Model.Finder(String.class, Poll.class).all();
            return badRequest(index.render(polls));
        } else {
            Poll poll = form.get();
            poll.save();
            return redirect(routes.Application.index());
        }
    }


    public static Result submitOption(Long id) {
        Poll poll = Poll.find.byId(id);

        Option option = form(Option.class).bindFromRequest().get();
        Option.create(option, id);

        return redirect(routes.Application.showPoll(id));
    }

    public static Result addOption(Long id) {
        return ok(createOption.render(form(Option.class), id));
    }

    public static Result upOption(Long id) {
        Option option = Option.find.byId(id);
        option.upCount++;
        option.update();
        return redirect(routes.Application.showPoll(option.poll.id));
    }

}
