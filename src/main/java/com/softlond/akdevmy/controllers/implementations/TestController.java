package com.softlond.akdevmy.controllers.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softlond.akdevmy.models.Test;
import com.softlond.akdevmy.services.contracts.ITestService;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/tests")
public class TestController {

	@Autowired
	private ITestService testService;

	@PostMapping("")
	public Mono<ResponseEntity<Test>> usuarios(@RequestBody Test test) {
		Mono<Test> saved = testService.save(test);

		return saved.map(t -> {
			if (t == null) {
				return null;
			}
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json; charset=UTF-8");

			return new ResponseEntity<Test>(t, headers, HttpStatus.OK);
		});

	}

}
