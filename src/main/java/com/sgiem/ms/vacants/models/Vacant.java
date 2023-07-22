package com.sgiem.ms.vacants.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "vacants")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vacant {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String titulo;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String userCode;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String proceso;

    private List<Employee> candidatos;
}
