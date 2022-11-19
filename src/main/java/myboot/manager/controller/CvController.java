package myboot.manager.controller;



import myboot.manager.model.Cv;
import myboot.manager.services.CvManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CvController {

    @Autowired
    private CvManager cvManager;

    @PostMapping ("/add")
    public ResponseEntity createPost(@RequestBody Cv cv) {
        cvManager.createCv(cv);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cv>> showAllPosts() {
        return new ResponseEntity<>(cvManager.showAllCvs(), HttpStatus.OK);
    }



}