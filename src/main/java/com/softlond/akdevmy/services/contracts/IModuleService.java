package com.softlond.akdevmy.services.contracts;

import java.util.List;

import com.softlond.akdevmy.dtos.ClassPositionDto;
import com.softlond.akdevmy.dtos.ModuleUpdateDto;
import com.softlond.akdevmy.models.Class;
import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.responses.CustomResponse;
import reactor.core.publisher.Mono;

public interface IModuleService {
	public Mono<CustomResponse<Module>> save(Module module);
	public Mono<CustomResponse<List<Module>>> getAll();
	public Mono<CustomResponse<Module>> findById(String id);
	public Mono<CustomResponse<Boolean>> deleteById(String id);
	public Mono<CustomResponse<Module>> addClass(String moduleId, Class theClass);
	public Mono<CustomResponse<Boolean>> deleteClass(String moduleId, String classId);
	public Mono<CustomResponse<ModuleUpdateDto>> updateModule(String moduleId, ModuleUpdateDto moduleUpdateDto);
	public Mono<CustomResponse<Class>> updateClass(String moduleId, String classId, Class theClass);
	public Mono<CustomResponse<List<Class>>> classesRepositioning(String moduleId, List<ClassPositionDto> classPositionDtos);
}
