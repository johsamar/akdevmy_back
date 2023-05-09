package com.softlond.akdevmy.controllers.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.responses.CustomResponse;

import reactor.core.publisher.Mono;


public interface IModuleController {
	public Mono<ResponseEntity<CustomResponse<Module>>> createModule(Module module);
	public Mono<ResponseEntity<CustomResponse<List<Module>>>> getAll();
	public Mono<ResponseEntity<CustomResponse<Module>>> findById(String id);
	public Mono<ResponseEntity<CustomResponse<Boolean>>> deletById(String id);
}
