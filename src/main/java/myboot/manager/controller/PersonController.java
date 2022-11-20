package myboot.manager.controller;



import myboot.manager.model.Activity;
import myboot.manager.model.Cv;
import myboot.manager.model.Person;
import myboot.manager.services.ActivityManager;
import myboot.manager.services.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class PersonController {

    @Autowired
    private PersonManager personManager;

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