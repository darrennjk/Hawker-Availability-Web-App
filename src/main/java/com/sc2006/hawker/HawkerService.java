package com.sc2006.hawker;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HawkerService {
    private final HawkerRepository hawkerrepository;

    public HawkerService(HawkerRepository hawkerrepository) {
        this.hawkerrepository = hawkerrepository;
    }

    public List<Hawker> allHawkers(){
        return hawkerrepository.findAll();
    }

    public Optional<Hawker> singleHawker(String serial_no){
        return hawkerrepository.findHawkerBySerialno(serial_no);
    }
}
