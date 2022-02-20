package com.richards.store.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FreightTest {

	@Test
	void mustCalculateFreightBasedOnCameraCharacteristics() {
		Dimension dimension = new Dimension(new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("10"));
		Item camera = new Item(1L, "Eletronic", "Camera", new BigDecimal("900"), new BigDecimal("1"), dimension);
		Freight freight = new Freight(camera, new BigDecimal("1000"));

		Assertions.assertThat(freight.getPrice()).isEqualTo(new BigDecimal("10.0"));
	}

	@Test
	void mustCalculateFreightBasedOnEletricGuitarCharacteristics() {
		Dimension dimension = new Dimension(new BigDecimal("100"), new BigDecimal("30"), new BigDecimal("10"));
		Item eletricGuitar = new Item(1L, "Instruments", "Eletric Guitar", new BigDecimal("500"), new BigDecimal("3"), dimension);
		Freight freight = new Freight(eletricGuitar, new BigDecimal("1000"));

		Assertions.assertThat(freight.getPrice()).isEqualTo(new BigDecimal("30.0"));
	}

	@Test
	void mustCalculateFreightBasedOnFreezerCharacteristics() {
		Dimension dimension = new Dimension(new BigDecimal("200"), new BigDecimal("100"), new BigDecimal("50"));
		Item freezer = new Item(1L, "Eletronic", "Freezer", new BigDecimal("2000"), new BigDecimal("40"), dimension);
		Freight freight = new Freight(freezer, new BigDecimal("1000"));

		Assertions.assertThat(freight.getPrice()).isEqualTo(new BigDecimal("400.0"));
	}

	@Test
	void mustReturnDefaultValueAsPriceWhenFreightPriceIsLessThanIt() {
		Dimension dimension = new Dimension(new BigDecimal("10"), new BigDecimal("10"), new BigDecimal("10"));
		Item freezer = new Item(1L, "Eletronic", "iPhone", new BigDecimal("3000"), new BigDecimal("0.5"), dimension);
		Freight freight = new Freight(freezer, new BigDecimal("1000"));

		Assertions.assertThat(freight.getPrice()).isEqualTo(new BigDecimal("10.0"));
	}

}