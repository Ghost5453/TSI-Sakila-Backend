package SakilaAPI.FilmComponents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.film WHERE title = ?1")
    List<Film> findAllByTitle(String myTitle);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.film WHERE title LIKE %?1%")
    List<Film> findAllLikeTitle(String myLikeTitle);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.film WHERE description = ?1")
    List<Film> findAllByDescription(String myDescription);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.film WHERE description LIKE %?1%")
    List<Film> findAllLikeDescription(String myDescription);


}
