package br.gabrielsmartins.smartpayment.application.domain.state;

import br.gabrielsmartins.smartpayment.application.domain.Order;
import br.gabrielsmartins.smartpayment.application.domain.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmedOrderStateTest {
	
	private ConfirmedOrderState state;
	private Order order;
	
	@BeforeEach
	public void setup() {
		this.order = new Order();
		this.state = new ConfirmedOrderState(order);
	}

	@Test
	@DisplayName("Given State When Reject Method Is Called Then Return Rejected State")
	public void givenStateWhenRejectMethodIsCalledThenReturnRejectedState() {
		OrderState state = this.state.reject(order);
		assertThat(state).isInstanceOf(RejectedOrderState.class);
	}

	@Test
	@DisplayName("Given State When Next Method Is Called Then Return Completed State")
	public void givenStateWhenNextMethodIsCalledThenReturnCompletedState() {
		OrderState state = this.state.next(order);
		assertThat(state).isInstanceOf(CompletedOrderState.class);
	}
	
	@Test
	@DisplayName("Given State When Get Status Method Is Called Then Return Order Status")
	public void givenStateWhenGetStatusMethodIsCalledThenReturnOrderStatus() {
		OrderStatus status = this.state.getStatus();
		assertThat(status).isEqualTo(OrderStatus.CONFIRMED);
	}

}
