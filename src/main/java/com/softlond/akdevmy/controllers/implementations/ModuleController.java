package com.softlond.akdevmy.controllers.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.akdevmy.controllers.contracts.IModuleController;
import com.softlond.akdevmy.dtos.ModuleUpdateDto;
import com.softlond.akdevmy.exceptions.CustomException;
import com.softlond.akdevmy.models.Class;
import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.responses.CustomResponse;
import com.softlond.akdevmy.services.contracts.IModuleService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/modules")
public class ModuleController implements IModuleController {

	@Autowired
	protected IModuleService moduleService;

	@CrossOrigin(origins = "*")
	@PostMapping("")
	@Override
	public Mono<ResponseEntity<CustomResponse<Module>>> createModule(@Valid @RequestBody Module module) {
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

	@CrossOrigin(origins = "*")
	@GetMapping("")
	@Override
	public Mono<ResponseEntity<CustomResponse<List<Module>>>> getAll() {
		Mono<CustomResponse<List<Module>>> allModules = this.moduleService.getAll();

		return allModules.map(m -> {

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json; charset=UTF-8");

			return new ResponseEntity<CustomResponse<List<Module>>>(m, headers, HttpStatus.OK);
		}).onErrorResume(e -> {
			if (e instanceof CustomException) {
				CustomException exception = (CustomException) e;
				CustomResponse<List<Module>> response = new CustomResponse<>();
				response.setMessage("Error al obtener módulos: " + exception.getMessage());
				return Mono.just(new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
			}

			return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

		});
	}

	@CrossOrigin(origins = "*")
	@GetMapping("findById/{id}")
	@Override
	public Mono<ResponseEntity<CustomResponse<Module>>> findById(@PathVariable String id) {

		return this.moduleService.findById(id).map(m -> {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json; charset=UTF-8");

			return new ResponseEntity<CustomResponse<Module>>(m, headers, HttpStatus.OK);

		}).onErrorResume(e -> {
			System.out.println("Entró a l error");
			CustomResponse<Module> response = new CustomResponse<>();
			if (e instanceof CustomException) {
				CustomException exception = (CustomException) e;
				response.setMessage("Error al buscar el módulo: " + exception.getMessage());
				return Mono.just(new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
			}

			return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

		});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("deleteById/{id}")
	@Override
	public Mono<ResponseEntity<CustomResponse<Boolean>>> deletById(@PathVariable String id) {

		return this.moduleService.deleteById(id)
				.map(r -> ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8")
						.body(new CustomResponse<Boolean>(r.getMessage(), r.getData())))
				.onErrorResume(e -> {
					CustomResponse<Boolean> response = new CustomResponse<>();
					if (e instanceof CustomException) {
						CustomException exception = (CustomException) e;
						response.setMessage("Error al buscar el módulo: " + exception.getMessage());
						return Mono.just(
								new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
					}

					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

				});
	}

	@CrossOrigin(origins = "*")
	@PostMapping("{moduleId}/class")
	@Override
	public Mono<ResponseEntity<CustomResponse<Module>>> addClass(@PathVariable String moduleId,
			@RequestBody Class theClass) {
		return this.moduleService.addClass(moduleId, theClass)
				.map(r -> ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8")
						.body(new CustomResponse<Module>(r.getMessage(), r.getData())))
				.onErrorResume(e -> {
					CustomResponse<Module> response = new CustomResponse<>();
					if (e instanceof CustomException) {
						CustomException exception = (CustomException) e;
						response.setMessage("Error al añadir la clase: " + exception.getMessage());
						return Mono.just(
								new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
					}

					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

				});
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("{moduleId}/class/{classId}")
	@Override
	public Mono<ResponseEntity<CustomResponse<Boolean>>> deleteClass(@PathVariable String moduleId,
			@PathVariable String classId) {

		return this.moduleService.deleteClass(moduleId, classId)
				.map(r -> ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8")
						.body(new CustomResponse<Boolean>(r.getMessage(), r.getData())))
				.onErrorResume(e -> {
					CustomResponse<Boolean> response = new CustomResponse<>();
					if (e instanceof CustomException) {
						CustomException exception = (CustomException) e;
						response.setMessage("Error al eliminar la clase: " + exception.getMessage());
						return Mono.just(
								new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
					}

					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

				});
	}

	@CrossOrigin(origins = "*")
	@PatchMapping("{moduleId}")
	@Override
	public Mono<ResponseEntity<CustomResponse<ModuleUpdateDto>>> updateModule(@PathVariable String moduleId,
			@Valid @RequestBody ModuleUpdateDto moduleUpdateDto) {

		return this.moduleService.updateModule(moduleId, moduleUpdateDto)
				.map(r -> ResponseEntity.ok().header("Content-Type", "application/json; charset=UTF-8")
						.body(new CustomResponse<ModuleUpdateDto>(r.getMessage(), r.getData())))
				.onErrorResume(e -> {
					CustomResponse<ModuleUpdateDto> response = new CustomResponse<>();
					if (e instanceof CustomException) {
						CustomException exception = (CustomException) e;
						response.setMessage("Error al actualizar el módulo: " + exception.getMessage());
						return Mono.just(
								new ResponseEntity<>(response, HttpStatusCode.valueOf(exception.getStatusCode())));
					}

					return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

				});
	}

}
