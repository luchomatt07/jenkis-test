package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.ProductoControl;
import com.solution.mateo.domain.port.in.ProductControlImputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product_control")
@AllArgsConstructor
public class ProductControlController {

    private final ProductControlImputPort productControlImputPort;
    // Create
    @Operation(summary = "Save Food", description = "save ProductoControl en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addAlimento(@RequestBody ProductoControl productoControl,
                                                  @RequestHeader("idtransacion") String idtransacion) {
        return productControlImputPort.save(productoControl,idtransacion);
    }

    @Operation(summary = "get Food", description = "get ProductoControl of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<ProductoControl> getAlimentos() {
        return productControlImputPort.findAll();
    }

    @Operation(summary = "find Food", description = "find ProductoControl by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getAlimentoById(@PathVariable String id,
                                                      @RequestHeader("idtransacion") String idtransacion) {
        return productControlImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update ProductoControl en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updateAlimento(@RequestBody ProductoControl productoControl,
                                                     @RequestHeader("idtransacion") String idtransacion) {
        return productControlImputPort.update(productoControl,idtransacion);
    }

    @Operation(summary = "delete", description = "delete ProductoControl of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAlimento(@PathVariable String id) {
        return productControlImputPort.deleteById(id);
    }
}
