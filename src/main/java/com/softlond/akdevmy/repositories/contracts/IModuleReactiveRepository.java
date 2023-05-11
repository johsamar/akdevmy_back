package com.softlond.akdevmy.repositories.contracts;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.softlond.akdevmy.models.Module;

public interface IModuleReactiveRepository extends ReactiveMongoRepository<Module, String> {
}
