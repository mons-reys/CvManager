package myboot.manager.dao;

import java.util.List;

import myboot.manager.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import myboot.manager.model.Person;





@Repository
@Transactional
public interface PersonRepository  extends JpaRepository<Person, Long> {

	@Query(value = "SELECT * FROM Person p WHERE p.firstname = ?1", nativeQuery = true)
	List<Person> findByFirstName(String name);
}