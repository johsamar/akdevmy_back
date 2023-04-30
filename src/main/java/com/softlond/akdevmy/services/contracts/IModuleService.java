package com.softlond.akdevmy.services.contracts;

import com.softlond.akdevmy.models.Module;

import reactor.core.publisher.Mono;

public interface IModuleService {
	public Mono<Module> save(Module module);
}
