package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Plague;
import com.solution.mateo.domain.port.in.PlagueImputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/plague")
@AllArgsConstructor
public class PlagueController {
    private final PlagueImputPort plagueImputPort;

    // Create
    @Operation(summary = "Save Formula", description = "save Formula en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addPlague(@RequestBody Plague plague,
                                                  @RequestHeader("idtransacion") String idtransacion) {
        return plagueImputPort.save(plague,idtransacion);
    }

    @Operation(summary = "get Formula", description = "get Plague of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<Plague> getPlague() {
        return plagueImputPort.findAll();
    }

    @Operation(summary = "find Plague", description = "find Plague by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getPlagueById(@PathVariable String id,
                                                      @RequestHeader("idtransacion") String idtransacion) {
        return plagueImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update Plague en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updatePlague(@RequestBody Plague plague,
                                                     @RequestHeader("idtransacion") String idtransacion) {
        return plagueImputPort.update(plague,idtransacion);
    }

    @Operation(summary = "delete", description = "delete Plague of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePlague(@PathVariable String id) {
        return plagueImputPort.deleteById(id);
    }
}
