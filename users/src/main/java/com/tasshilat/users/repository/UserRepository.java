package com.tasshilat.users.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.tasshilat.users.beans.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM user p WHERE p.email = :email", nativeQuery = true)
	Optional<User> findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM user p WHERE p.role = false", nativeQuery = true)
	Optional<List<User>> findAllUsers();

}
