package com.softlond.akdevmy.services.contracts;

import com.softlond.akdevmy.models.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    Mono<Course> findById(String id);
    Mono<Course> createCourse(Course course);
    Flux<Course> findAll();
    Flux<Course> searchCoursesByName(String name);
}
