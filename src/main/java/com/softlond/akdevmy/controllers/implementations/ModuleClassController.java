package com.softlond.akdevmy.controllers.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softlond.akdevmy.controllers.contracts.IModuleClassController;
import com.softlond.akdevmy.models.Class;
import com.softlond.akdevmy.responses.CustomResponse;

import reactor.core.publisher.Mono;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/modules/{moduleId}/class")
public class ModuleClassController implements IModuleClassController{

	@CrossOrigin(origins = "*")
	@PostMapping("")
	@Override
	public Mono<ResponseEntity<CustomResponse<Class>>> addClass(@PathVariable String moduleId, Class theClass) {
		
		
		return null;
	}
	
}
