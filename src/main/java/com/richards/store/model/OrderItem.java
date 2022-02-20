package com.richards.store.model;

import java.math.BigDecimal;

public class OrderItem {
    private Long itemId;
    private BigDecimal price;
    private Integer amount;

    public OrderItem(Long itemId, BigDecimal price, Integer amount) {
        this.itemId = itemId;
        this.price = price;
        this.amount = amount;
    }

    public BigDecimal getFinalPrice() {
        return price.multiply(BigDecimal.valueOf(amount));
    }
}
