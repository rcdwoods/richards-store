package com.richards.store.domain;

import com.richards.store.domain.entity.Coupon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class CouponTest {

	@Test
	void mustApplyPercentageDiscountOnValue() {
		Coupon coupon = new Coupon("TEST_DISCOUNT", 20, LocalDate.now());
		BigDecimal itemWithDiscount = coupon.applyDiscountOnValue(new BigDecimal("100"));

		Assertions.assertThat(itemWithDiscount).isEqualTo(new BigDecimal("80.0"));
	}
}
