package myboot.manager.controller;



import myboot.manager.model.Activity;
import myboot.manager.model.Cv;
import myboot.manager.model.Cv;
import myboot.manager.model.Person;
import myboot.manager.services.CvManager;
import myboot.manager.services.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class Controller {

    @Autowired
    private CvManager cvManager;

    @Autowired
    private PersonManager personManager;

    @PostMapping ("person/{personId}/{cvId}/cvs")
public ResponseEntity createCV(@PathVariable(value = "personId") Long personId,@PathVariable(value = "cvId") Long cvId, @RequestBody List<Activity> activities) {
        Cv cv = cvManager.readSingleCv(cvId);
        activities.forEach(activity -> activity.setCv(cv));
        cvManager.createPersonCv(personId, cv);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping ("{personId}/cv/add")
    public ResponseEntity createCv(@PathVariable(value = "personId") Long personId) {
        Cv cv = new Cv();
        cv.setPerson(personManager.readSinglePerson(personId));
        cvManager.createCv(cv);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @GetMapping("/person/{personId}/cvs")
    public ResponseEntity<List<Cv>> showPersonCvs(@PathVariable(value = "personId") Long personId) {

        List<Cv> cvs = cvManager.findByPersonId(personId);
        System.out.println(cvs);
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @GetMapping("/cv/get/all")
    public ResponseEntity<List<Cv>> showAllCvs() {
        List<Cv> cvs = cvManager.showAllCvs();
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @DeleteMapping ("/cv/remove/{id}")
    public ResponseEntity deleteCvById(@PathVariable @RequestBody Long id) {
        cvManager.deleteSingleCv(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping ("/cv/update/{id}")
    public ResponseEntity updateCvById(@PathVariable @RequestBody Long id, @RequestBody Cv cv) {
        cvManager.updateSinglePost(id, cv);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/cv/get/{id}")
    public ResponseEntity<Cv> getSingleCv(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(cvManager.readSingleCv(id), HttpStatus.OK);
    }

    //Perosn
    @PostMapping ("/person/add")
    public ResponseEntity createPost(@RequestBody Person person) {
        personManager.createPerson(person);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/person/all")
    public ResponseEntity<List<Person>> showAllPersons() {
        return new ResponseEntity<>(personManager.showAllPersons(), HttpStatus.OK);
    }

    @DeleteMapping ("/person/remove/{id}")
    public ResponseEntity deletePersonById(@PathVariable @RequestBody Long id) {
        personManager.deleteSinglePerson(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping ("/person/update/{id}")
    public ResponseEntity updatePersonById(@PathVariable @RequestBody Long id, @RequestBody Person person) {
        personManager.updateSinglePerson(id, person);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping ("/person/find/{id}")
    public ResponseEntity<List<Person>> showPersonsByPart(@PathVariable @RequestBody String part) {
        return new ResponseEntity( personManager.findPersonByPart(part), HttpStatus.OK);
    }

    @GetMapping("/person/get/{id}")
    public ResponseEntity<Person> getSinglePerson(@PathVariable @RequestBody Long id) {
       Person person =  personManager.readSinglePerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}