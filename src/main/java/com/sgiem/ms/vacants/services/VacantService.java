package com.sgiem.ms.vacants.services;

import com.sgiem.ms.vacants.dto.VacantResponse;
import com.sgiem.ms.vacants.models.Vacant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VacantService extends CrudService<Vacant, String>{

    Mono<Flux<VacantResponse>> getVacantProcess(String code, String proceso);
}
