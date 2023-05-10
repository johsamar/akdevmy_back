package com.softlond.akdevmy.services.implementations;

import com.softlond.akdevmy.Exception.CustomException;
import com.softlond.akdevmy.models.Course;
import com.softlond.akdevmy.repositories.contracts.CourseRepository;
import com.softlond.akdevmy.services.contracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class CourseImplementService implements CourseService {


    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
    @Autowired
    CourseRepository courseRepository;


    @Override
    public Mono<Course> findById(String id){

        return this.courseRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Error al buscar la colección curso")));
    }

    public Flux<Course> findAll(){

        return courseRepository.findAll()
                .switchIfEmpty(Mono.error(new Exception("Error")));
    }

    @Override
    public Mono<Course> createCourse(Course course) {
        return courseRepository.save(course)
                .switchIfEmpty(Mono.error(new Exception("Error al crear el curso")));

    }

    @Override
    public Mono<Course> updateCourse(Course course, String id){
        return courseRepository.findById(id)
                .flatMap(contactoActualizado -> {
                    course.setId(id);
                    return courseRepository.save(course);
                }).switchIfEmpty(Mono.error(new Exception("Curso no encontrado")));
    }

    @Override
    public Mono<Void> deleteCourse(String id){
        return  courseRepository.deleteById(id);
    }

    @Override
    public Flux<Course> searchCoursesByName(String name) {

        Query query = new Query();

        query.addCriteria(Criteria
                .where("name")
                .regex(name)
        );

        return reactiveMongoTemplate
                .find(query, Course.class).onErrorResume(
                        er ->{
                            CustomException customException = new  CustomException(
                                    "Error",
                                    er,
                                    500
                            );
                            return Mono.error(customException);
                        }
                );
    }
}
