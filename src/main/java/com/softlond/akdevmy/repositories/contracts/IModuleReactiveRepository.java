package com.softlond.akdevmy.repositories.contracts;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.softlond.akdevmy.models.Module;

import reactor.core.publisher.Mono;

public interface IModuleReactiveRepository extends ReactiveMongoRepository<Module, String> {
	Mono<Module> insert(Mono<Module> module);
}
