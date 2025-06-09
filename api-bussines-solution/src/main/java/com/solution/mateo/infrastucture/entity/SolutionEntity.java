package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "solution")
public class SolutionEntity {
    @Id
   // @Field("_id")
    private String id;
    private String idAlimento;
    private String idFormula;
    private String idPlague;
    private String periodoAplicacion;
    private String tiempoAplicacion;
    private String sugerencia;
    private String flagEli;
    private String idRegion;
    private LocalDateTime fechaInsert;
    private String usuarioInsert;
    private LocalDateTime fechaUpdate;
    private String usuarioUpdate;
    private LocalDateTime fechaDelete;
    private String usuarioDelete;
}
