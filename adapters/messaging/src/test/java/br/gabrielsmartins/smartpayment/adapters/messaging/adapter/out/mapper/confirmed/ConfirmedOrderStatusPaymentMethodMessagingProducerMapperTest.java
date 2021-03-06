package br.gabrielsmartins.smartpayment.adapters.messaging.adapter.out.mapper.confirmed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.gabrielsmartins.smartpayment.application.support.PaymentMethodSupport.defaultPaymentMethod;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfirmedOrderStatusPaymentMethodMessagingProducerMapperTest {

    private ConfirmedOrderStatusPaymentMethodMessagingProducerMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new ConfirmedOrderStatusPaymentMethodMessagingProducerMapper();
    }

    @Test
    @DisplayName("Given Payment Method When Map Then Return Message")
    public void givenPaymentMethodWhenMapThenReturnMessage(){
        var paymentMethod = defaultPaymentMethod().build();

        var message = this.mapper.mapToMessage(paymentMethod);

        assertThat(message).isNotNull();
        assertThat(message.getAmount()).isEqualTo(paymentMethod.getAmount());
        assertThat(message.getPaymentType().name()).isEqualTo(paymentMethod.getPaymentType().getDescription());
    }

}
