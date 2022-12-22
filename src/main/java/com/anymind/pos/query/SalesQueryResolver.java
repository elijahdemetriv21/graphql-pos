package com.anymind.pos.query;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anymind.pos.domain.Sales;
import com.anymind.pos.service.PaymentService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class SalesQueryResolver implements GraphQLQueryResolver {
    private PaymentService paymentService;

    public SalesQueryResolver(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public List<Sales> salesFor(String startDateTime, String endDateTime) {
    	final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    	Timestamp startDateTimeSQL = new Timestamp(0);
    	Timestamp endDateTimeSQL = new Timestamp(0);
        try {
        	
        	startDateTimeSQL = new Timestamp(DATE_TIME_FORMAT.parse(startDateTime).getTime());
        	endDateTimeSQL = new Timestamp(DATE_TIME_FORMAT.parse(endDateTime).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        
        return paymentService.retrieveHourlySales(startDateTimeSQL, endDateTimeSQL);
    }

}
