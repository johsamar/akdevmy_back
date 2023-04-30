package com.softlond.akdevmy.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.repositories.contracts.IModuleReactiveRepository;
import com.softlond.akdevmy.services.contracts.IModuleService;

import reactor.core.publisher.Mono;

@Service
public class ModuleService implements IModuleService {

	@Autowired
	protected IModuleReactiveRepository moduleRepository;

	@Override
	public Mono<Module> save(Module module) {
		// TODO Auto-generated method stub

		Mono<Module> moduleSaved = this.moduleRepository.save(module);

		return moduleSaved.map(m -> {
			if (m == null) {
				return null;
			}

			return m;
		});
	}

}
