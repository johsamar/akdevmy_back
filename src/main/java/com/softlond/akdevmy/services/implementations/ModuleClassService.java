package com.softlond.akdevmy.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.akdevmy.repositories.contracts.IModuleReactiveRepository;
import com.softlond.akdevmy.responses.CustomResponse;
import com.softlond.akdevmy.services.contracts.IModuleClassService;
import com.softlond.akdevmy.models.Class;

import reactor.core.publisher.Mono;

@Service
public class ModuleClassService implements IModuleClassService {

	@Autowired
	protected IModuleReactiveRepository moduleRepository;

	@Override
	public Mono<CustomResponse<Class>> addClass(Class theClass) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
