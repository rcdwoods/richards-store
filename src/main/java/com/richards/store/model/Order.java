package com.richards.store.model;

import com.richards.store.excepion.ExpiredCouponException;
import com.richards.store.excepion.InvalidCpfException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;
    private Cpf cpf;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Coupon discountCoupon;

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
