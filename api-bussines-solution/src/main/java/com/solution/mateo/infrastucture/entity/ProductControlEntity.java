package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "product_control")
public class ProductControlEntity {

    @Id
    private String idProducto;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String flagEli;
    private String peligrosidad;
    private String constitucionQuimica;
    private LocalDateTime fechaInsert;
    private String usuarioInsert;
    private LocalDateTime fechaUpdate;
    private String usuarioUpdate;
    private LocalDateTime fechaDelete;
    private String usuarioDelete;
}
