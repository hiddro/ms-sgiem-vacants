package com.sgiem.ms.vacants.controller;

import com.sgiem.ms.vacants.api.v1.VacantApi;
import com.sgiem.ms.vacants.dto.VacantRequest;
import com.sgiem.ms.vacants.dto.VacantResponse;
import com.sgiem.ms.vacants.services.VacantService;
import com.sgiem.ms.vacants.utils.commons.Commons;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/sgiem")
@CrossOrigin(origins = "*")
public class VacantController implements com.sgiem.ms.vacants.api.v1.VacantApi {

    @Autowired
    private VacantService vacantService;
    @Override
    public Mono<ResponseEntity<VacantResponse>> registerVacant(Mono<VacantRequest> vacantRequest, ServerWebExchange exchange) {
        return vacantRequest.flatMap(emp -> vacantService.save(Commons.convertToEntity(emp)))
                .map(Commons::convertToDtoRes)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                );
    }

    @Override
    public Mono<ResponseEntity<Flux<VacantResponse>>> listVacantsProcess(String code, String proceso, ServerWebExchange exchange) {
        return vacantService.getVacantProcess(code, proceso)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                ).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
