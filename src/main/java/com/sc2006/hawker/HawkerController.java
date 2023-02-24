package com.sc2006.hawker;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hawkers")
public class HawkerController {
    private final HawkerService hawkerservice;

    public HawkerController(HawkerService hawkerservice) {
        this.hawkerservice = hawkerservice;
    }

    @GetMapping
    public ResponseEntity<List<Hawker>> getAllHawkers(){
        return new ResponseEntity<List<Hawker>>(hawkerservice.allHawkers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hawker>> getSingleHawker(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Hawker>>(hawkerservice.singleHawker(id), HttpStatus.OK);
    }
}
