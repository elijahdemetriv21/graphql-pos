package com.anymind.pos.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payment_method", schema = "anymind")
public class PaymentMethod {
	
    @Id
    @Column(name = "payment_method_cd")
	private String paymentMethodCode;
    
    @Basic
    @Column(name = "min_price_modifier")
	private double minPriceModifier;
    
    @Basic
    @Column(name = "max_price_modifier")
	private double maxPriceModifier;
    
    @Basic
    @Column(name = "points_modifier")
	private double pointsModifier;

}
