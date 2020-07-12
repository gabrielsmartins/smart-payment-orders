package br.gabrielsmartins.smartpayment.adapters.persistence.repository.orders;

import br.gabrielsmartins.smartpayment.adapters.persistence.PersistenceAdapterTest;
import br.gabrielsmartins.smartpayment.adapters.persistence.entity.orders.OrderEntity;
import br.gabrielsmartins.smartpayment.application.domain.enums.PaymentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {PersistenceAdapterTest.class})
@ActiveProfiles("test")
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;


    @Test
    @DisplayName("Given Order When Save Then Return Saved Order")
    public void givenOrderWhenSaveThenReturnSavedOrder(){
        OrderEntity.OrderPaymentMethodEntity paymentMethod = OrderEntity.OrderPaymentMethodEntity.builder()
                .withDiscount(new BigDecimal(100.00))
                .withTotalAmountPaid(new BigDecimal(1400.00))
                .withPaymentType(PaymentType.CREDIT_CARD)
                .build();

        OrderEntity orderEntity = OrderEntity.builder()
                .withId(UUID.randomUUID().toString())
                .withPaymentNumberIdentifier(UUID.randomUUID().toString())
                .withDueDate(LocalDate.now())
                .withPaymentDate(LocalDate.now())
                .withTotalAmount(new BigDecimal(1500.00))
                .withTotalAmountPaid(new BigDecimal(1400.00))
                .build();

        orderEntity.addPaymentMethod(paymentMethod);


        OrderEntity savedOrder = this.repository.save(orderEntity);
        assertThat(savedOrder).isNotNull();
    }
}