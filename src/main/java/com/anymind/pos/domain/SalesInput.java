package com.anymind.pos.domain;

import com.anymind.pos.validator.DateConstraint;

import lombok.Data;

@Data
public class SalesInput {
	
	@DateConstraint(format = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	String startDateTime;
	
	@DateConstraint(format = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	String endDateTime;
}
