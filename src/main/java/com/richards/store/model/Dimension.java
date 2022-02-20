package com.richards.store.model;

import java.math.BigDecimal;

public class Dimension {
	private BigDecimal heightInCentimeters;
	private BigDecimal widthInCentimeters;
	private BigDecimal depthInCentimeters;

	public Dimension(BigDecimal heightInCentimeters, BigDecimal widthInCentimeters, BigDecimal depthInCentimeters) {
		this.heightInCentimeters = heightInCentimeters;
		this.widthInCentimeters = widthInCentimeters;
		this.depthInCentimeters = depthInCentimeters;
	}

	public BigDecimal getVolumeInMeters() {
		BigDecimal volumeInCentimeters = heightInCentimeters.multiply(widthInCentimeters).multiply(depthInCentimeters);
		return convertVolumeToMeters(volumeInCentimeters);
	}

	private BigDecimal convertVolumeToMeters(BigDecimal centimeters) {
		return centimeters.divide(new BigDecimal("1000000"));
	}
}
