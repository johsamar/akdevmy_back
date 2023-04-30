package com.softlond.akdevmy.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.softlond.akdevmy.exceptions.CustomException;
import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.repositories.contracts.IModuleReactiveRepository;
import com.softlond.akdevmy.responses.CustomResponse;
import com.softlond.akdevmy.services.contracts.IModuleService;

import reactor.core.publisher.Mono;

@Service
public class ModuleService implements IModuleService {

	@Autowired
	protected IModuleReactiveRepository moduleRepository;

	@Override
	public Mono<CustomResponse<Module>> save(Module module) {

		Mono<Module> moduleSaved = this.moduleRepository.save(module);

		Mono<CustomResponse<Module>> response = Mono.just(new CustomResponse<Module>());

		return moduleSaved.flatMap(m -> {
			if (m == null) {
				return Mono.error(new CustomException("El módulo no pudo ser guardado", null));
			}

			return response.map(r -> {
				r.setMessage("Módulo creado con éxito");
				r.setData(m);
				return r;
			});

		}).onErrorResume(e -> {

			if (e instanceof CustomException) {
				// TODO: Handle error
			}

			if (e instanceof IllegalArgumentException) {
				// TODO: Handle error
			}

			if (e instanceof OptimisticLockingFailureException) {
				// TODO: Handle error
			}
			
			return Mono.error(e);
		});
	}

}
