package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Poll extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    //TODO add description to model
    //public String description;

    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<Long, Poll> find = new Finder<Long, Poll>(Long.class, Poll.class);
}
