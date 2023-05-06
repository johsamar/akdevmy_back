package com.softlond.akdevmy.controllers.implementations;


import com.softlond.akdevmy.Exception.CustomException;
import com.softlond.akdevmy.models.Course;
import com.softlond.akdevmy.responses.CustomResponse;
import com.softlond.akdevmy.services.contracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping(value = "/findCourses/{id}")
    public Mono<ResponseEntity<CustomResponse<Course>>> findById(@PathVariable String id) {

        return  courseService.findById(id).map(c -> ResponseEntity.ok()
                        .header("Content-Type", "application/json; charset=UTF-8")
                        .body(new CustomResponse<>("Ok: ",c)))
                .onErrorResume(err -> {
                    CustomResponse<Course> resp = new CustomResponse<>();
                    if (err instanceof CustomException) {
                        CustomException customException = (CustomException) err;
                        resp.setMessage("Error: " + customException.getMessage());
                        return Mono.just(new ResponseEntity<>(resp, HttpStatusCode.valueOf(customException.getStatusCode())));
                    }
                    return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }




    @PostMapping("/createCourse")
    public Mono<ResponseEntity<CustomResponse<Course>>> createCourse(@RequestBody Course course){

       return courseService.createCourse(course).map(c -> ResponseEntity.ok()
                        .header("Content-Type", "application/json; charset=UTF-8")
                        .body(new CustomResponse<>("Ok: ",c)))
                .onErrorResume(err -> {
                    CustomResponse<Course> resp = new CustomResponse<>();
                    if (err instanceof CustomException) {
                        CustomException customException = (CustomException) err;
                        resp.setMessage("Error: " + customException.getMessage());
                        return Mono.just(new ResponseEntity<>(resp, HttpStatusCode.valueOf(customException.getStatusCode())));
                    }
                    return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                });

    }


    //List all
    @GetMapping("/listCourses")
    public Flux<Course> listCuorses(){

        return courseService.findAll();
    }

    //list by name
    @GetMapping("/search")
    public Flux<Course> searchCoursesByName(@RequestParam("name") String name) {

        return courseService.searchCoursesByName(name);
    }



}
