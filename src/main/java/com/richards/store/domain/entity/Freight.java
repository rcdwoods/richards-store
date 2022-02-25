package com.richards.store.domain.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Freight {

	private Item item;
	private BigDecimal distanceInKilometers;

	public Freight(Item item, BigDecimal distanceInKilometers) {
		this.item = item;
		this.distanceInKilometers = distanceInKilometers;
	}

	public BigDecimal getPrice() {
		BigDecimal minimumPrice = new BigDecimal("10.0");
		BigDecimal price = distanceInKilometers
			.multiply(item.getVolume())
			.multiply(item.getDensity())
			.divide(BigDecimal.valueOf(100))
			.setScale(1, RoundingMode.HALF_UP);
		return price.compareTo(minimumPrice) < 0  ? minimumPrice : price;
	}
}
