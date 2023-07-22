package com.sgiem.ms.vacants.services.impl;

import com.sgiem.ms.vacants.dto.VacantResponse;
import com.sgiem.ms.vacants.models.Vacant;
import com.sgiem.ms.vacants.repository.GenericRepositories;
import com.sgiem.ms.vacants.repository.VacantRepositories;
import com.sgiem.ms.vacants.services.VacantService;
import com.sgiem.ms.vacants.utils.commons.Commons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class VacantServiceImpl extends CrudServiceImpl<Vacant, String> implements VacantService {

    @Autowired
    private VacantRepositories vacantRepositories;

    @Override
    protected GenericRepositories<Vacant, String> getRepo() {
        return vacantRepositories;
    }

    @Override
    public Mono<Flux<VacantResponse>> getVacantProcess(String code, String proceso) {
        return Mono.just(vacantRepositories.findByUserCode(code)
                .filter(pro -> pro.getProceso().equalsIgnoreCase(proceso))
                .map(Commons::convertToDtoRes));
    }
}
