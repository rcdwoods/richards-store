package com.richards.store.model;

import com.richards.store.excepion.ExpiredCouponException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

	@Test
	void mustApplyPercentageDiscountOnValue() {
		Coupon coupon = new Coupon("TEST_DISCOUNT", 20, LocalDate.now());
		BigDecimal itemWithDiscount = coupon.applyDiscountOnValue(new BigDecimal("100"));

		Assertions.assertThat(itemWithDiscount).isEqualTo(new BigDecimal("80.0"));
	}
}
