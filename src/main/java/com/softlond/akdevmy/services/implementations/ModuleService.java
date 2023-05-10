package com.softlond.akdevmy.services.implementations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.akdevmy.exceptions.CustomException;
import com.softlond.akdevmy.models.Class;
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

		return this.moduleRepository.findById(id)

				.flatMap(m -> {
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
						customException = new CustomException("El id del modulo fue recibido como null", e, 400);
					}

					return Mono.error(customException);
				}).switchIfEmpty(response.map(r -> {
					r.setMessage("El módulo con el id indicado no existe");
					r.setData(null);
					return r;
				})

				);

	}

	@Override
	public Mono<CustomResponse<Boolean>> deleteById(String id) {

		return this.moduleRepository.existsById(id).flatMap(exists -> {
			CustomException customException = new CustomException("El módulo con el id indicado no existe", null);
			if (!exists) {
				return Mono.error(customException);
			}
			return this.moduleRepository.deleteById(id).then(Mono.just(true));

		}).flatMap(deleted -> {
			CustomResponse<Boolean> response = new CustomResponse<>();
			response.setData(deleted);
			response.setMessage("Módulo eliminado con éxito");
			return Mono.just(response);
		}).onErrorResume(e -> {
			CustomException customException = new CustomException(
					"El módulo no pudo ser eliminado por un error desconocido", e, 500);

			if (e instanceof CustomException) {
				customException = new CustomException(e.getMessage(), e, 400);
			}

			if (e instanceof IllegalArgumentException) {
				customException = new CustomException("El id del modulo fue recibido como null", e, 400);
			}
			return Mono.error(customException);
		});
	}

	@Override
	public Mono<CustomResponse<Module>> addClass(String moduleId, Class theClass) {
		return this.moduleRepository.findById(moduleId).flatMap(m -> {
			List<Class> classes = m.getClasses();
			classes.add(theClass);
			m.setClasses(classes);
			return this.moduleRepository.save(m);
		}).map(updatedModule -> {
			CustomResponse<Module> response = new CustomResponse<>();
			response.setData(updatedModule);
			response.setMessage("Clase añadida con éxito");
			return response;
		}).switchIfEmpty(Mono.error(new CustomException("No se encontró el módulo con el ID proporcionado", null)))
				.onErrorResume(e -> {
					CustomException customException = new CustomException(
							"La clase no pudo ser añadida al módulo por un error desconocido", e, 500);

					if (e instanceof CustomException) {
						customException = new CustomException(e.getMessage(), e, 400);
					}

					if (e instanceof IllegalArgumentException) {
						customException = new CustomException("El id del modulo fue recibido como null", e, 400);
					}
					return Mono.error(customException);
				});
	}

	@Override
	public Mono<CustomResponse<Boolean>> deleteClass(String moduleId, String classId) {
		return this.moduleRepository.findById(moduleId).flatMap(module -> {
			boolean removed = module.getClasses().removeIf(c -> c.get_id().equals(classId));
			return removed
					? this.moduleRepository.save(module)
							.thenReturn(new CustomResponse<Boolean>("Clase eliminada exitosamente", true))
					: Mono.error(new CustomException("La clase no se encontró en el módulo especificado", null));
		}).switchIfEmpty(Mono.just(new CustomResponse<Boolean>("El módulo especificado no existe", false)))
				.onErrorResume(e -> {
					CustomException customException = new CustomException(
							"La clase no pudo ser eliminada por un error desconocido", e, 500);

					if (e instanceof CustomException) {
						customException = new CustomException(e.getMessage(), e, 400);
					}

					if (e instanceof IllegalArgumentException) {
						customException = new CustomException("El id del modulo fue recibido como null", e, 400);
					}
					return Mono.error(customException);
				});
	}

}
