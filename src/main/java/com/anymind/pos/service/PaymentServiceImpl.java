package com.anymind.pos.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.pos.domain.AdditionalItem;
import com.anymind.pos.domain.PaymentInput;
import com.anymind.pos.domain.Sales;
import com.anymind.pos.domain.SalesInterface;
import com.anymind.pos.domain.entity.Payment;
import com.anymind.pos.domain.entity.PaymentMethod;
import com.anymind.pos.repository.PaymentRepository;
import com.anymind.pos.util.ParserUtil;

import graphql.GraphQLException;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;
    private PaymentMethodService paymentMethodService;
    
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMethodService paymentMethodService) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodService = paymentMethodService;
    }
	
	@Override
	public Payment createPayment(PaymentInput paymentInput) {
		PaymentMethod paymentMethod = paymentMethodService.retrievePaymentMethodByCode(paymentInput.getPaymentMethod());					
		validatePriceModifier(paymentMethod, paymentInput.getPriceModifier());
		
		Payment payment = new Payment();
		payment.setCustomerId(paymentInput.getCustomerId());
		payment.setPaymentMethodCode(paymentInput.getPaymentMethod());
		payment.setPrice(paymentInput.getPrice());
		payment.setPriceModifier(paymentInput.getPriceModifier());
		payment.setFinalPrice(ParserUtil.parseDouble(paymentInput.getPrice() * paymentInput.getPriceModifier()));
		payment.setPoints(ParserUtil.parseDouble(paymentInput.getPrice() * paymentMethod.getPointsModifier()));	
		payment.setDateTime(ParserUtil.parseDateTime(paymentInput.getDateTime()));		
		
				
		Optional.ofNullable(paymentInput.getAdditionalItem()).ifPresent(additionalItem -> {
			Map<String, String> additionalItemMap = parseAdditionalItem(additionalItem);
			
			payment.setAdditionalItemType(additionalItemMap.get("type"));
			payment.setAdditionalItemDescription(additionalItemMap.get("description"));
		});

	
		return paymentRepository.save(payment);
	}
	
    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
    
    
	@Override
	public List<Sales> retrieveHourlySales(Timestamp startDateTime, Timestamp endDateTime) {
		List<SalesInterface> salesItfList = paymentRepository.fetchHourlySales(startDateTime, endDateTime);
		
		return salesItfList.stream()
				.map(salesItf -> {
					Sales sales = new Sales();
					sales.setDateTime(salesItf.getDateTime());
					sales.setSales(salesItf.getSales());
					sales.setPoints(salesItf.getPoints());
					return sales;
				})
				.collect(Collectors.toList());
	}

	private void validatePriceModifier(PaymentMethod paymentMethod, double priceModifier) {
		if (priceModifier < paymentMethod.getMinPriceModifier() || priceModifier > paymentMethod.getMaxPriceModifier()) {
			throw new GraphQLException("Invalid price modifier");
		}
	};
	
    private Map<String, String> parseAdditionalItem (AdditionalItem additionalItem) {
    	Map<String, String> additionalItemMap = new HashMap<String, String>();
    	
    	Optional.ofNullable(additionalItem.getCourier()).ifPresent(courier -> {
    		additionalItemMap.put("type", "courier");
    		additionalItemMap.put("description", courier);
    	});
    	
    	Optional.ofNullable(additionalItem.getLast4()).ifPresent(last4 -> {
    		additionalItemMap.put("type", "last4");
    		additionalItemMap.put("description", last4);
    	});
    	
    	Optional.ofNullable(additionalItem.getAccountInfo()).ifPresent(accountInfo -> {
    		additionalItemMap.put("type", "accountInfo");
    		additionalItemMap.put("description", accountInfo);
    	});
    	
    	Optional.ofNullable(additionalItem.getChequeInfo()).ifPresent(chequeInfo -> {
    		additionalItemMap.put("type", "chequeInfo");
    		additionalItemMap.put("description", chequeInfo);
    	});
    	
    	return additionalItemMap;
    }
    

}
