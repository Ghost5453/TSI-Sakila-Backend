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

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE actor.first_name = ?1")
    List<Film> getFilmsByActorFirstName(String myName);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE actor.last_name = ?2")
    List<Film> getFilmsByActorLastName(String myName);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE actor.first_name = ?1 AND actor.last_name = ?2")
    List<Film> getFilmsByActorFullName(String myFirstName, String myLastName);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE actor.first_name = ?1")
    List<Film> getAllFilmsLikeActorFirstName(String myName);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE actor.last_name = ?2")
    List<Film> getAllActorsLikeActorLastName(String myName);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE actor.first_name = ?1 AND actor.last_name = ?2")
    List<Film> getAllFilmsLikeActorFullName(String myFirstName, String myLastName);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film WHERE title LIKE %?1% OR description LIKE %?1%")
    List<Film> searchAllFilms(String myQuery);
}
