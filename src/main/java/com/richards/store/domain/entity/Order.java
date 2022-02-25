package com.richards.store.domain.entity;

import com.richards.store.excepion.ExpiredCouponException;
import com.richards.store.excepion.InvalidCpfException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Cpf cpf;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Coupon discountCoupon;
    private Freight freight;

    public Order(String cpf) throws InvalidCpfException {
        this.cpf = new Cpf(cpf);
    }

    public List<OrderItem> getItems() {
        return this.orderItems;
    }

    public void addItem(Item item, Integer amount) {
        orderItems.add(new OrderItem(item.getId(), item.getPrice(), amount));
    }

    public void addDiscountCoupon(Coupon coupon) throws ExpiredCouponException {
        if (coupon.isExpired()) throw new ExpiredCouponException("Expired coupon.");
        this.discountCoupon = coupon;
    }

    public void setFreight(Freight freight) {
        this.freight = freight;
    }

    public BigDecimal getFinalPrice() {
        BigDecimal freightPrice = this.freight != null ? this.freight.getPrice() : new BigDecimal("0");
        BigDecimal totalPrice = orderItems
            .stream()
            .map(OrderItem::getFinalPrice)
            .reduce(new BigDecimal("0"), BigDecimal::add);
        return applyCoupon(totalPrice).subtract(freightPrice);
    }

    private BigDecimal applyCoupon(BigDecimal value) {
        return this.discountCoupon != null ? this.discountCoupon.applyDiscountOnValue(value) : value;
    }
}
