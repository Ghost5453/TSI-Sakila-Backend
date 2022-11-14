package SakilaAPI.FilmComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("films")
@CrossOrigin
public class FilmController {
    private Random rnd = new Random();
    private int rndCheck;

    @Autowired
    private FilmRepo filmRepo;

    public FilmController(FilmRepo myFilmRepo)
    {
        this.filmRepo = myFilmRepo;
    }

    //Reed All
    @GetMapping("")
    public @ResponseBody
    Iterable<Film> getAllFilms(){
        return filmRepo.findAll();
    }

    // Create
    @PostMapping("")
    public Film createFilm(@Validated @RequestBody Film film)
    {
        return filmRepo.save(film);
    }

    @GetMapping("/rand")
    public Film getRandFilm()
    {
        do {
            rndCheck = rnd.nextInt(1000);
        } while (rndCheck == 0);
        return getSignalFilm(rndCheck);
    }

    // Get by ID (Read)
    @GetMapping("/{id}")
    public Film getSignalFilm(@PathVariable(value = "id") int filmID)
    {
        return filmRepo.findById(filmID)
                .orElseThrow(() -> new ResourceAccessException("Film not found at index " + filmID));
    }

    @GetMapping("likeTitle/{name}")
    public @ResponseBody List<Film> getAllFilmsLikeTitle(@PathVariable(value = "name") String findLike)
    {
        return filmRepo.findAllLikeTitle(findLike);
    }

    @GetMapping("byTitle/{name}")
    public @ResponseBody List<Film> getAllFilmsByTitle(@PathVariable(value = "name") String findName)
    {
        return filmRepo.findAllByTitle(findName);
    }

    @GetMapping("likeDescription/{name}")
    public @ResponseBody List<Film> getAllFilmsLikeDescription(@PathVariable(value = "name") String findDescription)
    {
        return filmRepo.findAllLikeDescription(findDescription);
    }

    @GetMapping("byDescription/{name}")
    public @ResponseBody List<Film> getAllFilmsByDescription(@PathVariable(value = "name") String findDescription)
    {
        return filmRepo.findAllByDescription(findDescription);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Film> updateActor(@PathVariable(value = "id") int filmID,
                @Validated @RequestBody Film filmDetails)
            throws ResourceAccessException {
        Film film = filmRepo.findById(filmID)
                .orElseThrow(() -> new ResourceAccessException("Film not found by " + filmID));

        film.setFilmID(filmDetails.getFilmID());
        film.setFilmTitle(filmDetails.getFilmTitle());
        film.setFilmDescription(filmDetails.getFilmDescription());
        film.setFilmLanguageID(filmDetails.getFilmLanguageID());
        film.setFilmRentalDuration(filmDetails.getFilmRentalDuration());
        film.setFilmRentalPrice(filmDetails.getFilmRentalPrice());
        film.setFilmLength(filmDetails.getFilmLength());
        film.setFilmReplacementCost(filmDetails.getFilmReplacementCost());
        film.setFilmRating(filmDetails.getFilmRating());
        film.setFilmFeatures(filmDetails.getFilmFeatures());
        final Film updatedFilm = filmRepo.save(film);
        return ResponseEntity.ok(updatedFilm);
    }

    // Delete
    @DeleteMapping("delete/{id}")
    public Map<String, Boolean> deleteActor(@PathVariable(value = "id") int filmID)
            throws ResourceAccessException{
        Film film = filmRepo.findById(filmID)
                .orElseThrow(() -> new ResourceAccessException("Film not found at index " + filmID));

        filmRepo.deleteById(filmID);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return response;
    }

}