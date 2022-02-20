package com.richards.store.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
    private Long id;
    private String type;
    private String name;
    private BigDecimal price;

    public Item(Long id, String type, String name, BigDecimal price, BigDecimal weight, Dimension dimension) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
