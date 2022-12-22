package com.anymind.pos;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ParserUtil {
	private ParserUtil(){}
	
	public static double parseDouble(double value) {
		final DecimalFormat df = new DecimalFormat("0.00"); 
		df.setRoundingMode(RoundingMode.UP);
		
		return Double.valueOf(df.format(value));
	}
}
