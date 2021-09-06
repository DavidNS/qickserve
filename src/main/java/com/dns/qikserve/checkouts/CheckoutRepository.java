package com.dns.qikserve.checkouts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dns.qikserve.checkouts.entities.CheckoutEntity;


public interface CheckoutRepository  extends JpaRepository<CheckoutEntity, Integer> {
	
}
