package com.anymind.pos.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Sales {
	String dateTime;
	BigDecimal sales;
	BigDecimal points;
}
