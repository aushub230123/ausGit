package com.DSSystem.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.DSSystem.entity.User;





@Repository // marker annotation, which indicates that the underlying interface is a
			// repository

public interface UserRepository extends JpaRepository<User, Integer> {
	/*
	 * -> This repository is created for interacting with Users table from the
	 * database, by extending JpaRepository interface. -> JpaRepository is JPA
	 * specific extension of Repository. It contains the full API of CrudRepository
	 * and PagingAndSortingRepository. So it contains API for basic CRUD operations
	 * and also API for pagination and sorting.
	 */
//	SELECT * FROM USERS WHERE USER_EMAIL = 'T@T.COM';
	//selet * from users where us
	//select * from users where user_email = 'admin@gmail.com' and user_password = 'pass';
	User findByEmail(String email);
	User findByPhone(String phone);
	User findByEmailAndPassword(String email, String password);
	

	
}
