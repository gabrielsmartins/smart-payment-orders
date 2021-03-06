package br.gabrielsmartins.smartpayment.adapters.persistence.service;

import br.gabrielsmartins.smartpayment.adapters.persistence.entity.OrderEntity;
import reactor.core.publisher.Mono;

public interface ISaveOrderPersistenceService {

    Mono<OrderEntity> save(OrderEntity orderEntity);

}
