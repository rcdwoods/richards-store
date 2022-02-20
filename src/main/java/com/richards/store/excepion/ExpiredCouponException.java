package com.richards.store.excepion;

public class ExpiredCouponException extends Exception {
	public ExpiredCouponException(String message) {
		super(message);
	}
}
