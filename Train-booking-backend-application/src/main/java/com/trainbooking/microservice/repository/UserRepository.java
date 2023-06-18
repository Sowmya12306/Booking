package com.trainbooking.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trainbooking.microservice.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity>  {

	Optional<UsersEntity> findByFirstNameAndEmailId(String firstName, String emailId);

	Optional<UsersEntity> findByEmailIdAndPassWord(String emailId, String passWord);

	Optional<UsersEntity> findByEmailId(String emailId);

	@Query(value = "select * from {h-schema}USERS where firstName= ?1", nativeQuery = true)
	UsersEntity findByFirstName(String name);

	@Query(value = "select * from {h-schema}USERS where userId= ?1", nativeQuery = true)
	Optional<UsersEntity> findUserInfo(Long userId);

	Optional<UsersEntity> findByUserId(Long userId);

}