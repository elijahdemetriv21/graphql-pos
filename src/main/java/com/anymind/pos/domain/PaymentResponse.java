package com.anymind.pos.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PaymentResponse {
	BigDecimal finalPrice;
	BigDecimal points;
}
