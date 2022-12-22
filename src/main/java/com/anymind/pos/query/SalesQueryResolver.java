package com.anymind.pos.query;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.anymind.pos.domain.Sales;
import com.anymind.pos.domain.SalesInput;
import com.anymind.pos.service.PaymentService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
@Validated
public class SalesQueryResolver implements GraphQLQueryResolver {
    private PaymentService paymentService;

    public SalesQueryResolver(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public List<Sales> sales(@Valid SalesInput salesInput) {
    	final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    	Timestamp startDateTimeSQL = new Timestamp(0);
    	Timestamp endDateTimeSQL = new Timestamp(0);
        try {        	
        	startDateTimeSQL = new Timestamp(DATE_TIME_FORMAT.parse(salesInput.getStartDateTime()).getTime());
        	endDateTimeSQL = new Timestamp(DATE_TIME_FORMAT.parse(salesInput.getEndDateTime()).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        
        return paymentService.retrieveHourlySales(startDateTimeSQL, endDateTimeSQL);
    }

}
