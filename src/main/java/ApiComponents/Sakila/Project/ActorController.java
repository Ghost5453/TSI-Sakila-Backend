package ApiComponents.Sakila.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // Get all
    @GetMapping("/actors")
    public @ResponseBody
    Iterable<Actor> getAllActors(){
        return actorRepo.findAll();
    }

    // Create
    @PostMapping("/actors")
    public Actor createActor(@Validated @RequestBody Actor actor)
    {
        return actorRepo.save(actor);
    }

    // Get by ID (Read)
    @GetMapping("/actors/{id}")
    public Actor getSignalActor(@PathVariable(value = "id") int actorID)
    {
        return actorRepo.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));
    }

    @GetMapping("/actors/name/first/{name}")
    public @ResponseBody List<Actor> getActorByFirstName(@PathVariable("name") String actorFirstName)
    {
        return actorRepo.findActorFirstName(actorFirstName);
    }

    @GetMapping("/actors/name/last/{name}")
    public @ResponseBody List<Actor> getActorByLastName(@PathVariable("name") String actorLastName)
    {
        return actorRepo.findActorLastName(actorLastName);
    }


    // Update
    @PutMapping("/actors/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") int actorID, @Validated @RequestBody Actor actorDetails)
            throws ResourceAccessException {
        Actor actor = actorRepo.findById(actorID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found by " + actorID));

        actor.setID(actorDetails.getID());
        actor.setActorLastName(actorDetails.getActorLastName());
        actor.setFirstName(actorDetails.getActorFirstName());
        final Actor updatedEmployee = actorRepo.save(actor);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete
    @DeleteMapping("/actors/delete/{id}")
    public Map<String, Boolean> deleteActor(@PathVariable(value = "id") int actorID)
            throws ResourceAccessException{
        Actor actor = actorRepo.findById(actorID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));

        actorRepo.deleteById(actorID);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }

}
