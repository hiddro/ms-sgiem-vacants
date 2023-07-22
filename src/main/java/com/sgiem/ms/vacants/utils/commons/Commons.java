package com.sgiem.ms.vacants.utils.commons;

import com.sgiem.ms.vacants.dto.VacantResponse;
import com.sgiem.ms.vacants.models.Vacant;
import org.modelmapper.ModelMapper;

public class Commons {

    public static final ModelMapper modelMapper = new ModelMapper();

    public static Vacant convertToEntity(com.sgiem.ms.vacants.dto.VacantRequest empReq) {
        Vacant empEnt = modelMapper.map(empReq, Vacant.class);

        return empEnt;
    }

    public static VacantResponse convertToDtoRes(Vacant emp) {
        VacantResponse empRes = modelMapper.map(emp, VacantResponse.class);

        return empRes;
    }

}
