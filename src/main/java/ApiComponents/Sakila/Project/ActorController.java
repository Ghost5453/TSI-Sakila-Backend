package ApiComponents.Sakila.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class ActorController
{
    @Autowired
    private ActorRepo actorRepo;

    public ActorController(ActorRepo myActorRepo)
    {
        this.actorRepo = myActorRepo;
    }

    @GetMapping("/actors")
    public @ResponseBody
    Iterable<Actor> getAllActors(){
        return actorRepo.findAll();
    }

    @GetMapping("/actors/{id}")
    public Actor getSignalActor(@PathVariable(value = "id") int actorID)
    {
        return actorRepo.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));
    }

    @PutMapping("/actors/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") int actorID, @Validated @RequestBody Actor actorDetails)
            throws ResourceAccessException {
        Actor actor = actorRepo.findById(actorID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));

        actor.setID(actorDetails.getID());
        actor.setActorLastName(actorDetails.getActorLastName());
        actor.setFirstName(actorDetails.getActorFirstName());
        final Actor updatedEmployee = actorRepo.save(actor);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PostMapping("/actors")
    public Actor createActor(@Validated @RequestBody Actor actor)
    {
        return actorRepo.save(actor);
    }


}
