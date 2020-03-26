package com.cognizant.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {}
