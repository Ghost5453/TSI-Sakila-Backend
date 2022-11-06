package SakilaAPI.FilmComponents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmRepo extends JpaRepository<Film, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE title = ?1 LIMIT 1")
    Film findByTitle(String myTitle);

//    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE last_name = ?1")
//    List<Actor> findAllActorLastName(String myName);
//
//    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE first_name = ?1 LIMIT 1")
//    Actor findActorFirstName(String myName);
//
//    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE last_name = ?1 LIMIT 1")
//    Actor findActorLastName(String myName);

}
