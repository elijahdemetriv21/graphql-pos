package com.anymind.pos.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anymind.pos.domain.SalesInterface;
import com.anymind.pos.domain.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query(value = "SELECT " + 
			"CONVERT(DATE_FORMAT(p.date_time,'%Y-%m-%d-%H:00:00'), DATETIME) as dateTime, " + 
			"SUM(p.final_price) as sales, " + 
			"SUM(p.points) as points " + 
			"from anymind.payment p " + 
			"where p.date_time between ?1 and ?2 " + 
			"group by dateTime " +
			"order by dateTime", nativeQuery = true)
	List<SalesInterface> fetchHourlySales(Timestamp startDateTime, Timestamp endDateTime);
}	
