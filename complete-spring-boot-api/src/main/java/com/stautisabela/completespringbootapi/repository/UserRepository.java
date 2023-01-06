package com.stautisabela.completespringbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stautisabela.completespringbootapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
