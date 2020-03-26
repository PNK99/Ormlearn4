package com.cognizant.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm.models.User;

public interface UserRepository extends JpaRepository<User, Long> {}
