package com.dns.qikserve.baskets;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dns.qikserve.baskets.entities.BasketEntity;


public interface BasketRepository  extends JpaRepository<BasketEntity, Integer> {

}
