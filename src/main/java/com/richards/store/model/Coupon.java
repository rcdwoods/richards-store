package com.richards.store.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Coupon {
	private String code;
	private Integer percentage;
	private LocalDate expirationDate;

	public Coupon(String code, Integer percentage, LocalDate expirationDate) {
		this.code = code;
		this.percentage = percentage;
		this.expirationDate = expirationDate;
	}

	public BigDecimal applyDiscountOnValue(BigDecimal value) {
		return value.subtract(value.multiply(BigDecimal.valueOf(getPercentage())));
	}

	private Double getPercentage() {
		return this.percentage / 100.0;
	}

	public Boolean isExpired () {
		return this.expirationDate.isBefore(LocalDate.now());
	}
}
