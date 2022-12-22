package com.anymind.pos.domain.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payment", schema = "anymind")
public class Payment {
	
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
    
    @Basic
    @Column(name = "customer_id")
	private int customerId;
    
    @Basic
    @Column(name = "payment_method_cd")
	private String paymentMethodCode;
    
    @Basic
    @Column(name = "price")
	private double price;
    
    @Basic
    @Column(name = "price_modifier")
	private double priceModifier;
    
    @Basic
    @Column(name = "final_price")
	private BigDecimal finalPrice;
    
    @Basic
    @Column(name = "points")
	private BigDecimal points;
    
    @Basic
    @Column(name = "date_time")
	private Timestamp dateTime;
    
    @Basic
    @Column(name = "additional_item_type")
	private String additionalItemType;
    
    @Basic
    @Column(name = "additional_item_description")
	private String additionalItemDescription;
    
}
