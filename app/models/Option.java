package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Option extends Model {

    @Id
    public Long id;

    public String name;

    @ManyToOne
    public Poll poll;

    public int upCount;

    //public String description;

    //public String link;

    //public String imgURL;

    public static List<Option> findByPoll(Long poll) {
        return Option.find.where()
                .eq("poll.id", poll)
                .findList();
    }

    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Model.Finder<Long, Option> find = new Model.Finder(Long.class, Option.class);

    public static Option create(Option option, Long pollID) {
        option.poll = Poll.find.byId(pollID);
        option.upCount = 0;
        checkID(option);

        option.save();
        return option;
    }

    public static void checkID(Option option) {
        if (Option.find.byId(option.id) != null) {
            //Hackathon hardcode :)
            option.id += 10;
            checkID(option);
        }
    }

}
