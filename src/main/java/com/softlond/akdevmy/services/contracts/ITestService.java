package com.softlond.akdevmy.services.contracts;

import com.softlond.akdevmy.models.Test;

import reactor.core.publisher.Mono;

public interface ITestService {
	public Mono<Test> save(Test object);
}
