package com.softlond.akdevmy.controllers.contracts;

import org.springframework.http.ResponseEntity;

import com.softlond.akdevmy.models.Module;

import reactor.core.publisher.Mono;


public interface IModuleController {
	public Mono<ResponseEntity<Module>> createModule(Module module);
}
