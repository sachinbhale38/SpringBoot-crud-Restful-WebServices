package com.ingecno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ingecno.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {
	
	@Query("select r from Register r where r.username = :username")
	public Register getUserByUserName(@Param("username") String username);

	@Query("select r from Register r where r.email = :email")
	public Register getUserByEmail(@Param("email") String email);
	
	@Query("select r from Register r where r.email = :email and r.password = :password")
	public Register checkLogin(@Param("email") String email,@Param("password") String password);



}
