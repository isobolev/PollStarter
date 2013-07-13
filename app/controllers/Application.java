package controllers;

import models.Poll;
import play.*;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result newPoll() {
        return ok(createPoll.render());
    }

    public static Result submitPoll() {
        Poll poll = Form.form(Poll.class).bindFromRequest().get();
        poll.save();

        return redirect(routes.Application.index());
    }

    public static Result getPoll() {
        List<Poll> polls = new Model.Finder(String.class, Poll.class).all();
        return ok(toJson(polls));
    }

}
