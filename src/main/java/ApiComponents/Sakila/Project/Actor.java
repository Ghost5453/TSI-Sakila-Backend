package ApiComponents.Sakila.Project;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {
    // Atrabuts
    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorId;

    @Column(name="first_name")
    String actorFirstName;

    @Column(name="last_name")
    String actorLastName;


    // Constructors
    public Actor(String myFirstName, String myLastName)
    {
        this.actorFirstName = myFirstName;
        this.actorLastName = myLastName;
    }

    public Actor()
    {

    }

    // Methords
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

}
