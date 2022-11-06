package SakilaAPI.ActorComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("actors")
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
    @GetMapping("")
    public @ResponseBody
    Iterable<Actor> getAllActors(){
        return actorRepo.findAll();
    }

    // Create
    @PostMapping("")
    public Actor createActor(@Validated @RequestBody Actor actor)
    {
        return actorRepo.save(actor);
    }

    // Get by ID (Read)
    @GetMapping("/{id}")
    public Actor getSignalActor(@PathVariable(value = "id") int actorID)
    {
        return actorRepo.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));
    }

    @GetMapping("name/first/{name}/all")
    public @ResponseBody List<Actor> getAllActorByFirstName(@PathVariable("name") String actorFirstName)
    {
        return actorRepo.findAllActorFirstName(actorFirstName);
    }

    @GetMapping("name/last/{name}/all")
    public @ResponseBody List<Actor> getAllActorByLastName(@PathVariable("name") String actorLastName)
    {
        return actorRepo.findAllActorLastName(actorLastName);
    }

    @GetMapping("name/first/{name}")
    public @ResponseBody Actor getActorByFirstName(@PathVariable("name") String actorFirstName)
    {
        return actorRepo.findActorFirstName(actorFirstName);
    }

    @GetMapping("name/last/{name}")
    public @ResponseBody Actor getActorByLastName(@PathVariable("name") String actorLastName)
    {
        return actorRepo.findActorLastName(actorLastName);
    }


    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") int actorID,
                 @Validated @RequestBody Actor actorDetails)
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
    @DeleteMapping("delete/{id}")
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
