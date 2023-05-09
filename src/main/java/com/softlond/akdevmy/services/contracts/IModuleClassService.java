package com.softlond.akdevmy.services.contracts;

import com.softlond.akdevmy.models.Class;
import com.softlond.akdevmy.responses.CustomResponse;
import reactor.core.publisher.Mono;

public interface IModuleClassService {
	public Mono<CustomResponse<Class>> addClass(Class theClass);
}
