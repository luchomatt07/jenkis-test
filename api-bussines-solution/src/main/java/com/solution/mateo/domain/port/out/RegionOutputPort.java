package com.solution.mateo.domain.port.out;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Region;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegionOutputPort {

    Mono<BodyResponse<Object>> findById(String id, String idTxt);
    Mono<BodyResponse<Object>> save(Region region, String idTxt);
    Mono<BodyResponse<Object>> update(Region region,String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Region> findAll();
}
