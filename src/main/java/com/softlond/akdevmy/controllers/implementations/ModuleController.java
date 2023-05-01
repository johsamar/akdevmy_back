package com.softlond.akdevmy.controllers.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softlond.akdevmy.controllers.contracts.IModuleController;
import com.softlond.akdevmy.exceptions.CustomException;
import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.responses.CustomResponse;
import com.softlond.akdevmy.services.contracts.IModuleService;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/modules")
public class ModuleController implements IModuleController {

	@Autowired
	protected IModuleService moduleService;

	@PostMapping("")
	@Override
	public Mono<ResponseEntity<CustomResponse<Module>>> createModule(@RequestBody Module module) {
		Mono<CustomResponse<Module>> savedModule = this.moduleService.save(module);

		return savedModule.map(m -> {			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json; charset=UTF-8");

			return new ResponseEntity<CustomResponse<Module>>(m, headers, HttpStatus.OK);

		}).onErrorResume(e -> {
			if (e instanceof CustomException) {
				CustomException exception = (CustomException) e;
				CustomResponse<Module> response = new CustomResponse<>();
				response.setMessage("Error al crear el módulo: " + exception.getMessage());
				return Mono.just(new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
			}

			return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

		});
	}

}
