package com.softlond.akdevmy.services.contracts;

import java.util.List;

import org.bson.types.ObjectId;

import com.softlond.akdevmy.models.Module;
import com.softlond.akdevmy.responses.CustomResponse;
import reactor.core.publisher.Mono;

public interface IModuleService {
	public Mono<CustomResponse<Module>> save(Module module);
	public Mono<CustomResponse<List<Module>>> getAll();
	public Mono<CustomResponse<Module>> findById(String id);
}
