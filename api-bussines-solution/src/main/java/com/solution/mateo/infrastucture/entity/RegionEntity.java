package com.solution.mateo.infrastucture.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "region")
public class RegionEntity {
    @Id
    private String idRegion;
    private String nombre;
    private String latitud;
    private String flagEli;
    private LocalDateTime fechaInsert;
    private String usuarioInsert;
    private LocalDateTime fechaUpdate;
    private String usuarioUpdate;
    private LocalDateTime fechaDelete;
    private String usuarioDelete;
}
