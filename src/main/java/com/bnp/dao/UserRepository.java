package com.bnp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
