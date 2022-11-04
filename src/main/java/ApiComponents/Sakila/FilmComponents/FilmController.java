package ApiComponents.Sakila.FilmComponents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
