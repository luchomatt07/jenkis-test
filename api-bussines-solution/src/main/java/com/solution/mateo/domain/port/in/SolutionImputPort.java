package com.solution.mateo.domain.port.in;

import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Solution;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolutionImputPort {
    Mono<BodyResponse<Object>> findById(String id, String idTxt);

    Flux<SolutionCun>  findBynamePlague(String id, String idTxt);
    Mono<BodyResponse<Object>> save(Solution solution, String idTxt);
    Mono<BodyResponse<Object>> update(Solution solution,String idTxt);
    Mono<Void> deleteById(String id);
    Flux<Solution> findAll();
}
