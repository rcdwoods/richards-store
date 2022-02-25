package com.richards.store.domain;

import com.richards.store.domain.entity.Dimension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DimensionTest {

	@Test
	void mustCreateDimensionAndCalculateCorrectVolume() {
		Dimension dimension = new Dimension(new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("10"));
		Assertions.assertThat(dimension.getVolumeInMeters()).isEqualTo(new BigDecimal("0.003"));
	}


}