package com.softlond.akdevmy.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.akdevmy.models.Test;
import com.softlond.akdevmy.repositories.contracts.ITestReactiveRepository;
import com.softlond.akdevmy.services.contracts.ITestService;

import reactor.core.publisher.Mono;

@Service
public class TestService implements ITestService {

	@Autowired
	private ITestReactiveRepository testRepository;

	@Override
	public Mono<Test> save(Test object) {
		Test newTest =  object;

		Mono<Test> saved = testRepository.insert(Mono.just(newTest));

		return saved.map(t -> {
			if (t == null) {
				return null;
			}

			return t;
		});

	}

}
