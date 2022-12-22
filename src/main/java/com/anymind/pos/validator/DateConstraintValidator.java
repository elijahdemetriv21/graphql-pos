package com.anymind.pos.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateConstraintValidator implements ConstraintValidator<DateConstraint, String> {

	private String format;

    @Override
    public void initialize(final DateConstraint constraintAnnotation) {
    	this.format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
    	final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(format);
    	 try {
             DATE_TIME_FORMAT.parse(value);
             return true;
         } catch (ParseException e) {
             return false;
         }
    }

}
