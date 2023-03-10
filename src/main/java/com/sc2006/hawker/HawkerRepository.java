package com.sc2006.hawker;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HawkerRepository extends MongoRepository<Hawker, ObjectId> {
    Optional<Hawker> findHawkerBySerialno(String serial_no);
}
