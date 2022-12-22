package com.anymind.pos.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ParserUtil {
	
	private ParserUtil() {}
	
	public static BigDecimal parseDouble (double value) {
		return new BigDecimal(value).setScale(2, RoundingMode.DOWN);
	}
	
    public static Timestamp parseDateTime(String dateTime) {
    	final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(dateTime).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
