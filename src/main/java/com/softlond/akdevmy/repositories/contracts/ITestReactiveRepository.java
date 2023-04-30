package com.softlond.akdevmy.repositories.contracts;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.softlond.akdevmy.models.Test;

import reactor.core.publisher.Mono;

public interface ITestReactiveRepository extends ReactiveMongoRepository<Test, String> {
	
	Mono<Test> findByGreetings(String greetings);

	Mono<Test> insert(Mono<Test> test);
}
