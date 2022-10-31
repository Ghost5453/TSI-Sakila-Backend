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
    public String getFirstName()
    {
        return actorFirstName;
    }

    public void setFirstName(String myFirstName)
    {
        actorFirstName = myFirstName;
    }

    public String getActorLastName()
    {
        return actorLastName;
    }

    public void setActorLastName(String myLastName)
    {
        actorLastName = myLastName;
    }

    public int getID()
    {
        return actorId;
    }

    public void setID(int myID)
    {
        actorId = myID;
    }
    //endregion

}
