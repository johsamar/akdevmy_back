package com.softlond.akdevmy.repositories.contracts;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.softlond.akdevmy.models.Module;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IModuleReactiveRepository extends ReactiveMongoRepository<Module, String> {
	@Query(value = "{}", fields = "{'_id':1 , 'name' : 1, 'description':1, 'idCourse': 1}")
	public Flux<Module> findAll();

	@Aggregation(pipeline = {
            "{$match: { _id: ?0 }}",
            "{$unwind: '$classes'}",
            "{$sort: { 'classes.position': 1 }}",
            "{$group: { _id: '$_id', name: { $first: '$name' }, description: { $first: '$description' }, idCourse: { $first: '$idCourse' }, classes: { $push: '$classes' } } }"
    })
	public Mono<Module> findById(String id);
}
