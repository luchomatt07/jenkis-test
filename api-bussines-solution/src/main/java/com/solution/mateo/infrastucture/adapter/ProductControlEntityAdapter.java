package com.solution.mateo.infrastucture.adapter;

import com.solution.mateo.application.mapper.FoodMapper;
import com.solution.mateo.application.mapper.ProductControlMapper;
import com.solution.mateo.application.util.Constantes;
import com.solution.mateo.domain.model.BodyResponse;
import com.solution.mateo.domain.model.ProductoControl;
import com.solution.mateo.domain.port.out.ProductControlOutputPort;
import com.solution.mateo.infrastucture.repository.ProductControlRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
@AllArgsConstructor
@Log
public class ProductControlEntityAdapter implements ProductControlOutputPort {

    private final ProductControlRepository productControlRepository;
    @Override
    public Mono<BodyResponse<Object>> findById(String id, String idTxt) {
        return productControlRepository.findById(id)
                .map(ProductControlMapper.INSTANCE::toDto)
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt )
                        .data(x)
                        .build()
                )
                .switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt )
                        .build())
                ) .onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt )
                        .build())
                ;
    }

    @Override
    public Mono<BodyResponse<Object>> save(ProductoControl productoControl, String idTxt) {
        return productControlRepository.save(ProductControlMapper.INSTANCE.toEntity(productoControl))
                .map(ProductControlMapper.INSTANCE::toDto)
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt)
                        .data(x)
                        .build()
                )
                .switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt)
                        .build())
                ) .onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt)
                        .build())
                ;
    }

    @Override
    public Mono<BodyResponse<Object>> update(ProductoControl productoControl, String idTxt) {
        return productControlRepository.findById(productoControl.getIdProducto())
                .flatMap(y->  productControlRepository.save(ProductControlMapper.INSTANCE.toEntityId(productoControl))
                        .map(ProductControlMapper.INSTANCE::toDto) )
                .map(x->  BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_CERO)
                        .mensajeRespuesta(Constantes.MENSAJE_OK)
                        .idtransasacion(idTxt)
                        .data(x)
                        .build()
                )
                .switchIfEmpty(Mono.just(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ID_NOEXISTE)
                        .idtransasacion(idTxt)
                        .build())
                ).onErrorReturn(BodyResponse.builder()
                        .codRespuesta(Constantes.NUM_UNO)
                        .mensajeRespuesta(Constantes.MENSAJE_ERROR_INTERNO)
                        .idtransasacion(idTxt)
                        .build())
                ;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return productControlRepository.deleteById(id);
    }

    @Override
    public Flux<ProductoControl> findAll() {
        return productControlRepository.findAll().map(ProductControlMapper.INSTANCE::toDto);
    }
}
