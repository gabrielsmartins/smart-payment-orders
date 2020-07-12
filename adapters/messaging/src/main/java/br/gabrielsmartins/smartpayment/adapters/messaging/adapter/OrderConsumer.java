package br.gabrielsmartins.smartpayment.adapters.messaging.adapter;

import br.gabrielsmartins.smartpayment.adapters.messaging.mapper.OrderMessagingMapper;
import br.gabrielsmartins.smartpayment.adapters.messaging.message.OrderMessage;
import br.gabrielsmartins.smartpayment.application.ports.in.orders.SaveOrderUseCase;
import br.gabrielsmartins.smartpayment.common.stereotype.MessagingAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;


@MessagingAdapter
@RequiredArgsConstructor
public class OrderConsumer {

    private final SaveOrderUseCase saveOrderUseCase;
    private final OrderMessagingMapper mapper;

    @Bean
    public Consumer<OrderMessage> consume(){
       return orderMessage ->  saveOrderUseCase.save(mapper.mapToDomain(orderMessage));
    }
}