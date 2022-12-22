package com.anymind.pos.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public static String changeDateFormat(String dateTimeStr) {
    	final SimpleDateFormat SQL_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	final SimpleDateFormat NEW_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    	
        try {
            Date dateTime =  SQL_DATE_TIME_FORMAT.parse(dateTimeStr);
            return NEW_DATE_TIME_FORMAT.format(dateTime);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
