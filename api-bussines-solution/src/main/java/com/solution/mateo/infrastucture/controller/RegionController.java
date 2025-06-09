package com.solution.mateo.infrastucture.controller;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Region;
import com.solution.mateo.domain.port.in.RegionImputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/region")
@AllArgsConstructor
public class RegionController {

    private final RegionImputPort regionImputPort;

    // Create
    @Operation(summary = "Save Food", description = "save Region en data base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BodyResponse<Object>> addRegion(@RequestBody Region region,
                                                  @RequestHeader("idtransacion") String idtransacion) {
        return regionImputPort.save(region,idtransacion);
    }

    @Operation(summary = "get Food", description = "get Region of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping
    public Flux<Region> getRegion() {
        return regionImputPort.findAll();
    }

    @Operation(summary = "find Food", description = "find Region by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @GetMapping("/{id}")
    public Mono<BodyResponse<Object>> getRegionById(@PathVariable String id,
                                                      @RequestHeader("idtransacion") String idtransacion) {
        return regionImputPort.findById(id,idtransacion);
    }

    @Operation(summary = "update", description = "update Region en bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @PutMapping("/update")
    public Mono<BodyResponse<Object>> updateRegion(@RequestBody Region region,
                                                     @RequestHeader("idtransacion") String idtransacion) {
        return regionImputPort.update(region,idtransacion);
    }

    @Operation(summary = "delete", description = "delete Region of bd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "operation success"),
            @ApiResponse(responseCode = "400", description = "Problema Interno")
    })
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRegion(@PathVariable String id) {
        return regionImputPort.deleteById(id);
    }
}
