package ApiComponents.Sakila.FilmComponents;

import ApiComponents.Sakila.ActorComponents.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("films")
@CrossOrigin
public class FilmController {

    @Autowired
    private FilmRepo filmRepo;

    public FilmController(FilmRepo myFilmRepo)
    {
        this.filmRepo = myFilmRepo;
    }

    @GetMapping("")
    public @ResponseBody
    Iterable<Film> getAllActors(){
        return filmRepo.findAll();
    }

    // Create
    @PostMapping("")
    public Film createActor(@Validated @RequestBody Film film)
    {
        return filmRepo.save(film);
    }

    // Get by ID (Read)
    @GetMapping("/{id}")
    public Film getSignalActor(@PathVariable(value = "id") int filmID)
    {
        return filmRepo.findById(filmID)
                .orElseThrow(() -> new ResourceAccessException("Actor not found at index " + filmID));
    }

//    @GetMapping("name/first/{name}/all")
//    public @ResponseBody List<Actor> getAllActorByFirstName(@PathVariable("name") String actorFirstName)
//    {
//        return filmRepo.findAllActorFirstName(actorFirstName);
//    }
//
//    @GetMapping("name/last/{name}/all")
//    public @ResponseBody List<Actor> getAllActorByLastName(@PathVariable("name") String actorLastName)
//    {
//        return filmRepo.findAllActorLastName(actorLastName);
//    }
//
//    @GetMapping("name/first/{name}")
//    public @ResponseBody Actor getActorByFirstName(@PathVariable("name") String actorFirstName)
//    {
//        return filmRepo.findActorFirstName(actorFirstName);
//    }
//
//    @GetMapping("name/last/{name}")
//    public @ResponseBody Actor getActorByLastName(@PathVariable("name") String actorLastName)
//    {
//        return filmRepo.findActorLastName(actorLastName);
//    }


    // Update
//    @PutMapping("/actors/{id}")
//    public ResponseEntity<Film> updateActor(@PathVariable(value = "id") int filmID,
//                                             @Validated @RequestBody Actor actorDetails)
//            throws ResourceAccessException {
//        Film film = filmRepo.findById(filmID)
//                .orElseThrow(() -> new ResourceAccessException("Actor not found by " + filmID));
//
//        film.setID(actorDetails.getID());
//        film.setActorLastName(actorDetails.getActorLastName());
//        film.setFirstName(actorDetails.getActorFirstName());
//        final Actor updatedEmployee = filmRepo.save(film);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    // Delete
//    @DeleteMapping("delete/{id}")
//    public Map<String, Boolean> deleteActor(@PathVariable(value = "id") int actorID)
//            throws ResourceAccessException{
//        Actor actor = filmRepo.findById(actorID)
//                .orElseThrow(() -> new ResourceAccessException("Actor not found at index " + actorID));
//
//        filmRepo.deleteById(actorID);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("Deleted", Boolean.TRUE);
//
//        return response;
//    }

}
