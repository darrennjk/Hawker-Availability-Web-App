package com.sc2006.hawker;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HawkerRepository extends MongoRepository<Hawker, ObjectId> {
}
