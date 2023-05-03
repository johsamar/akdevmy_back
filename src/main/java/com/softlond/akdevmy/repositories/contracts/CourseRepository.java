package com.softlond.akdevmy.repositories.contracts;

import com.softlond.akdevmy.models.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course,String> {
}
