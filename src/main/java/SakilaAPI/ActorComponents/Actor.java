package SakilaAPI.ActorComponents;

import SakilaAPI.FilmComponents.Film;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {

    //region Attributes

    @ManyToMany (mappedBy = "filmActor")
    Set<Film> actorFilm;

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorID;

    @Column(name="first_name")
    private String actorFirstName;

    @Column(name="last_name")
    private String actorLastName;
    //endregion


//    @JoinTable(name = "sakila.film_actor",
//        joinColumns = @JoinColumn(name = "actor_id"),
//        inverseJoinColumns = @JoinColumn(name = "film_id"))
//    List<Film> films;

    //region Constructors
    public Actor(int myActorID, String myFirstName, String myLastName)
    {
        this.actorID = myActorID;
        this.actorFirstName = myFirstName;
        this.actorLastName = myLastName;
    }

    public Actor(String myFirstName, String myLastName)
    {
        this.actorFirstName = myFirstName;
        this.actorLastName = myLastName;
    }

    public Actor()
    {

    }
    //endregion

    //region Methods

    //region Getters
    public String getActorFirstName()
    {
        return actorFirstName;
    }

    public String getActorLastName()
    {
        return actorLastName;
    }

    public int getID()
    {
        return actorID;
    }
    //endregion

    //region Setters
    public void setID(int myID)
    {
        actorID = myID;
    }

    public void setActorLastName(String myLastName)
    {
        actorLastName = myLastName;
    }

    public void setFirstName(String myFirstName)
    {
        actorFirstName = myFirstName;
    }
    //endregion
    //endregion

}
