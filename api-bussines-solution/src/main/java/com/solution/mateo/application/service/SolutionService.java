package com.solution.mateo.application.service;

import com.solution.mateo.domain.cun.SolutionCun;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.Solution;
import com.solution.mateo.domain.port.in.SolutionImputPort;
import com.solution.mateo.domain.port.out.SolutionOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SolutionService implements SolutionImputPort {
    private final SolutionOutputPort solutionOutputPort;


    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return solutionOutputPort.findById(id,idTxt);
    }


    @Override
    public Flux<SolutionCun>  findBynamePlague(String id, String idTxt) {
        return solutionOutputPort.findBynamePlague(id,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> save(Solution solution, String idTxt) {
        return solutionOutputPort.save(solution,idTxt);
    }

    @Override
    public Mono<BodyResponse<Object>> update(Solution solution, String idTxt) {
        return solutionOutputPort.update(solution,idTxt);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return solutionOutputPort.deleteById(id);
    }

    @Override
    public Flux<Solution> findAll() {
        return solutionOutputPort.findAll();
    }
}
