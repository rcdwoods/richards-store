package com.richards.store.model;

import com.richards.store.excepion.ExpiredCouponException;
import com.richards.store.excepion.InvalidCpfException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    private final Dimension defaultDimension = new Dimension(new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1"));

    @Test
    void mustCreateEmptyOrderWhenCpfIsValid() throws InvalidCpfException {
        Order order = new Order("123.456.789-09");
        Assertions.assertThat(order).isNotNull();
    }

    @Test
    void mustNotCreateEmptyOrderAndThrowExceptionWhenCpfIsInvalid() {
        Exception exception = assertThrows(InvalidCpfException.class, () -> {
           new Order("111.111.111-11");
        });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Invalid CPF.");
    }

    @Test
    void mustAddItemsToOrder() throws InvalidCpfException {
        Order order = new Order("123.456.789-09");
        order.addItem(new Item(1L, "Música", "CD", new BigDecimal("30"), new BigDecimal("1"), defaultDimension), 3);
        order.addItem(new Item(2L, "Vídeo", "DVD", new BigDecimal("50"), new BigDecimal("1"), defaultDimension), 1);
        order.addItem(new Item(3L, "Video", "VHS", new BigDecimal("10"), new BigDecimal("1"), defaultDimension), 2);

        Assertions.assertThat(order.getItems()).hasSize(3);
    }
}