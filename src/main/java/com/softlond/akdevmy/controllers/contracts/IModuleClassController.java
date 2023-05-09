package com.softlond.akdevmy.controllers.contracts;

import org.springframework.http.ResponseEntity;

import com.softlond.akdevmy.models.Class;
import com.softlond.akdevmy.responses.CustomResponse;

import reactor.core.publisher.Mono;

public interface IModuleClassController {
	Mono<ResponseEntity<CustomResponse<Class>>> addClass(String id, Class theClass);
}
