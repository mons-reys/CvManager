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

public class CvController {

    @Autowired
    private ActivityManager activityManager;


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