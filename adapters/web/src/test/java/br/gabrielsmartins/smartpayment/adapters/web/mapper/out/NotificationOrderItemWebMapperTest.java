package br.gabrielsmartins.smartpayment.adapters.web.mapper.out;

import br.gabrielsmartins.smartpayment.adapters.web.adapter.out.dto.NotificationOrderItemDTO;
import br.gabrielsmartins.smartpayment.application.domain.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.gabrielsmartins.smartpayment.application.support.OrderItemSupport.defaultOrderItem;
import static org.assertj.core.api.Assertions.assertThat;

public class NotificationOrderItemWebMapperTest {

    private NotificationOrderItemWebMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new NotificationOrderItemWebMapperImpl();
    }

    @Test
    @DisplayName("Given Order Item When Map Then Return Notification Dto")
    public void givenOrderItemWhenMapThenReturnNotificationDto(){

        OrderItem item = defaultOrderItem().build();

        NotificationOrderItemDTO itemDto = this.mapper.mapToDto(item);

        assertThat(itemDto).hasNoNullFieldsOrProperties();
        assertThat(itemDto.getProductId()).isEqualTo(item.getProductId());
        assertThat(itemDto.getQuantity()).isEqualTo(item.getQuantity());
        assertThat(itemDto.getAmount()).isEqualTo(item.getAmount());
    }
}
