package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "formula")
public class FormulaEntity {
    @Id
    private String idFormula;
    private String idProductoControl;
    private Long cantidad;
    private String medida;
    private String comentario;
    private String presentacion;
    private String flagEli;
    private LocalDateTime fechaInsert;
    private String usuarioInsert;
    private LocalDateTime fechaUpdate;
    private String usuarioUpdate;
    private LocalDateTime fechaDelete;
    private String usuarioDelete;
}
