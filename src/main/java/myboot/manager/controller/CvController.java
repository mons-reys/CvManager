package myboot.manager.controller;



import com.fasterxml.jackson.annotation.JsonView;
import myboot.manager.model.Activity;
import myboot.manager.model.Cv;
import myboot.manager.model.Person;
import myboot.manager.model.Views;
import myboot.manager.services.ActivityManager;
import myboot.manager.services.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class CvController {

    @Autowired
    private ActivityManager activityManager;

    @Autowired
    private PersonManager personManager;


    @PostMapping ("person/{personId}/cv")
    public ResponseEntity createCV(@PathVariable(value = "personId") Long personId, @RequestBody List<Activity> activities) {
        activityManager.createPersonCv(personId, activities);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/person/{personId}/cv")
    public ResponseEntity<Cv> showPersonCv(@PathVariable(value = "personId") Long personId) {
        Cv cv = activityManager.findCvByPersonId(personId);
        return new ResponseEntity<>(cv, HttpStatus.OK);
    }

    @GetMapping("/cvs")
    public ResponseEntity<List<Cv>> showAllCv() {
        List<Person> persons = personManager.showAllPersons();
        List<Cv> cvs = new ArrayList<Cv>();
        persons.forEach(person -> {
           Cv cv =  activityManager.findCvByPersonId(person.getId());
            cvs.add(cv);
        });
        return new ResponseEntity<>(cvs, HttpStatus.OK);
    }

    @PostMapping("/person/cv/{activityId}")
    public ResponseEntity<Cv> updatePersonCv(@PathVariable(value = "activityId") Long activityId, @RequestBody Activity activity) {
        activityManager.updatePersonActivity(activityId, activity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping ("/person/{personId}/cv")
    public ResponseEntity deletePersonCv(@PathVariable(value = "personId") Long personId) {
        activityManager.deletePersonCv(personId);
        return new ResponseEntity(HttpStatus.OK);
    }
}