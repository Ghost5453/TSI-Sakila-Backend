package ApiComponents.Sakila.Project;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {
    //region Attributes
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;

    @Column(name="first_name")
    String actorFirstName;

    @Column(name="last_name")
    String actorLastName;
    //endregion


    //region Constructors
    public Actor(int myActorID, String myFirstName, String myLastName)
    {
        this.actorId = myActorID;
        this.actorFirstName = myFirstName;
        this.actorLastName = myLastName;
    }

    public Actor()
    {

    }
    //endregion

    //region Methods


    //region Getters
    public String getFirstName()
    {
        return actorFirstName;
    }

    public String getActorLastName()
    {
        return actorLastName;
    }

    public int getID()
    {
        return actorId;
    }
    //endregion

    //region Setters
    public void setID(int myID)
    {
        actorId = myID;
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
