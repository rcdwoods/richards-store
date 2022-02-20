package com.richards.store.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Freight {

	private Item item;
	private BigDecimal distanceInKilometers;

	public Freight(Item item, BigDecimal distanceInKilometers) {
		this.item = item;
		this.distanceInKilometers = distanceInKilometers;
	}
}
