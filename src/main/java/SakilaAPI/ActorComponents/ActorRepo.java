package SakilaAPI.ActorComponents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE first_name = ?1")
    List<Actor> findAllActorFirstName(String myName);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE last_name = ?1")
    List<Actor> findAllActorLastName(String myName);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE first_name = ?1 LIMIT 1")
    Actor findActorFirstName(String myName);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE last_name = ?1 LIMIT 1")
    Actor findActorLastName(String myName);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE first_name LIKE %?1% OR last_name LIKE %?1%")
    List<Actor> findActorLikeName(String myName);

}
