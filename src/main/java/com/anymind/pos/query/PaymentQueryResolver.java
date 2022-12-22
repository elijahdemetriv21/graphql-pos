package com.anymind.pos.query;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anymind.pos.domain.entity.Payment;
import com.anymind.pos.service.PaymentService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class PaymentQueryResolver implements GraphQLQueryResolver {
    private PaymentService paymentService;

    public PaymentQueryResolver(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public List<Payment> paymentAll() {
        return paymentService.findAll();
    }

}
