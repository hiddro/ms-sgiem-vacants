package com.sgiem.ms.vacants.repository;

import com.sgiem.ms.vacants.models.Vacant;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VacantRepositories extends GenericRepositories<Vacant, String>{

    Flux<Vacant> findByUserCode(String code);
}
