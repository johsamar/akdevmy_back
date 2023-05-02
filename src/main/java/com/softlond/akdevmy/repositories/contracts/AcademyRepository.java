package com.softlond.akdevmy.repositories.contracts;

import com.softlond.akdevmy.models.AcademyEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends MongoRepository<AcademyEntity, ObjectId>{

}
