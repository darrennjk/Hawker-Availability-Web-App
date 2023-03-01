package com.sc2006.hawker;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/hawkers") //This mapping will be handled by this controller
public class HawkerController {
    private final HawkerService hawkerservice;

    public HawkerController(HawkerService hawkerservice) {
        this.hawkerservice = hawkerservice;
    }

    @GetMapping
    public ResponseEntity<List<Hawker>> getAllHawkers(){
        return new ResponseEntity<List<Hawker>>(hawkerservice.allHawkers(), HttpStatus.OK);
    }

    @GetMapping("/{Serial_no}")
    public ResponseEntity<Optional<Hawker>> getSingleHawker(@PathVariable String Serial_no){
        return new ResponseEntity<Optional<Hawker>>(hawkerservice.singleHawker(Serial_no), HttpStatus.OK);
    }
}
