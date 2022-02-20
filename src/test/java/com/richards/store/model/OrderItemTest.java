package com.richards.store.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OrderItemTest {
	@Test
	void mustCreateOrderItemAndCalculateFinalPrice() {
		OrderItem item = new OrderItem(1L, new BigDecimal("30"), 3);
		Assertions.assertThat(item.getFinalPrice()).isEqualTo(new BigDecimal("90"));
	}
}