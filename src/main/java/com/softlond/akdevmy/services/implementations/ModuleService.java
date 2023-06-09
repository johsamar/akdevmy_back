package com.softlond.akdevmy.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.akdevmy.exceptions.CustomException;
import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.repositories.contracts.IModuleReactiveRepository;
import com.softlond.akdevmy.responses.CustomResponse;
import com.softlond.akdevmy.services.contracts.IModuleService;

import reactor.core.publisher.Flux;
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
			return response.map(r -> {
				r.setMessage("Módulo creado con éxito");
				r.setData(m);
				return r;
			});

		}).onErrorResume(e -> {
			CustomException customException = new CustomException(
					"El módulo no pudo ser guardado por un error desconocido", e, 500);

			if (e instanceof IllegalArgumentException) {
				// TODO: Handle error
				/*
				 * If necessary, you can set the message and/or the statusCode of the custom
				 * exception.
				 */
			}

			if (e instanceof OptimisticLockingFailureException) {
				// TODO: Handle error
				/*
				 * If necessary, you can set the message and/or the statusCode of the custom
				 * exception.
				 */
			}

			return Mono.error(customException);
		});
	}

	@Override
	public Mono<CustomResponse<List<Module>>> getAll() {
		Flux<Module> modules = this.moduleRepository.findAll();

		return modules.collectList().map(moduleList -> {
			return new CustomResponse<List<Module>>("Módulos obtenidos con éxito", moduleList);
		}).onErrorResume(e -> {
			CustomException customException = new CustomException(
					"Los módulos no pudieron ser obtenidos por un error desconocido", e, 500);
			/*
			 * Here you can add validations to handle the different errors. Also, if
			 * necessary, you can set the message and/or the statusCode of the custom
			 * exception.
			 */

			return Mono.error(customException);
		});
	}

	@Override
	public Mono<CustomResponse<Module>> findById(String id) {
		Mono<CustomResponse<Module>> response = Mono.just(new CustomResponse<Module>());

		return this.moduleRepository.findById(id).flatMap(m -> {
			return response.map(r -> {
				r.setMessage("Módulo encontrado con éxito");
				r.setData(m);
				return r;
			});
		}).onErrorResume(e -> {
			CustomException customException = new CustomException(
					"El modulo no pudo ser obtenido por un error desconocido", e, 500);
			if (e instanceof IllegalArgumentException) {
				/*
				 * TODO: Fix logic to catch IllegalArgumentException type error that returns
				 * IllegalArgumentException if id is null. Then remove the validation from the
				 * controller.
				 */
				customException = new CustomException("El id del module fue recibido como null", e, 400);
			}

			return Mono.error(customException);
		}).switchIfEmpty(response.map(r -> {
			r.setMessage("El módulo con el id indicado no existe");
			r.setData(null);
			return r;
		})

		);
	}

}
