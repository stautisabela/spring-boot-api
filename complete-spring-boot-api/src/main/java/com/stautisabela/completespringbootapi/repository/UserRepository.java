package com.stautisabela.completespringbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stautisabela.completespringbootapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Modifying
	@Query("UPDATE User u SET u.active = false WHERE u.id =:id")
	void disactivateUser(@Param("id") String id);
	
	@Modifying
	@Query("UPDATE User u SET u.active = true WHERE u.id =:id")
	User activateUser(@Param("id") String id);
}
