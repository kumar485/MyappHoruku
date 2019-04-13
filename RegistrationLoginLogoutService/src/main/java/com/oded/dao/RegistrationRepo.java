package com.oded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oded.model.LoginModel;
import com.oded.model.UserModel;
@Repository
public interface RegistrationRepo extends JpaRepository<UserModel,Integer> {
	@Query(value="SELECT * FROM user_model u WHERE u.username = ?1 and u.password = ?2",nativeQuery=true)
	UserModel findUserPassword(String username,String password);

}
