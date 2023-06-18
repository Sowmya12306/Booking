package com.trainbooking.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trainbooking.microservice.entity.TicketEntity;

@Repository
public interface TicketBookRepository extends JpaRepository<TicketEntity, Long>, JpaSpecificationExecutor<TicketEntity> {

	@Query(value = "select * from {h-schema}TICKET_BOOKING where USER_ID =?1", nativeQuery = true)
	List<TicketEntity> findAllById(Long userId);
	
	@Query(value = "select * from {h-schema}TICKET_BOOKING where USER_ID=?1 ", nativeQuery = true)
	List<TicketEntity> findAllTickets(Long userId);

}