package com.anymind.pos.domain;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class AdditionalItem {

	@Pattern(regexp = "YAMATO|SAGAWA")
	private String courier;
	
	@Length(min = 4, max = 4)
	private String last4;
	
	private String accountInfo;
	
	private String chequeInfo;
}
