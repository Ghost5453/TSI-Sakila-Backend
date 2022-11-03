package ApiComponents.Sakila.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE first_name = ?1")
    List<Actor> findActorFirstName(String myName);

    @Query(nativeQuery = true, value = "SELECT * FROM sakila.actor WHERE last_name = ?1")
    List<Actor> findActorLastName(String myName);


}
