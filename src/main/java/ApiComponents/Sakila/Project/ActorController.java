package ApiComponents.Sakila.Project;

import org.springframework.beans.factory.annotation.Autowired;

public class ActorController
{
    @Autowired
    private ActorRepo actorRepo;

    public ActorController(ActorRepo myActorRepo)
    {
        this.actorRepo = myActorRepo;
    }


}
