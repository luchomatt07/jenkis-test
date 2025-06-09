package com.solution.mateo.domain.port.out;

import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Formula;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FormulaOutputPort {
    Mono<BodyResponse<Object>> findById(String id,String idTxt);
    Mono<BodyResponse<Object>> save(Formula formula, String idTxt);
    Mono<BodyResponse<Object>> update(Formula formula,String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Formula> findAll();
}
