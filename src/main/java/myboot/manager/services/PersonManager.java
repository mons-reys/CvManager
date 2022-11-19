package myboot.manager.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myboot.manager.dao.PersonRepository;
import myboot.manager.model.Cv;
import myboot.manager.model.Person;


@Service
@Transactional
public class PersonManager {

	 @Autowired
	 PersonRepository pr;

    public void createPerson(Person p) {
        pr.save(p);
    }

    public Person getPersonByFirstName(String firstName) {
        List<Person> persons = pr.findByFirstName(firstName);
        return persons.get(0);
    }

   
    public void deletePeron(String firstName) {
    	List<Person> persons = pr.findByFirstName(firstName);
    	Person person = persons.get(0);
    	if(person != null) {
        	pr.delete(person);
    	}
    	
    }



	

}



