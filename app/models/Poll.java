package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Poll extends Model {

    @Id
    public String id;

    public String name;

    //public List<Option> options;

}
