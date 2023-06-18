package com.trainbooking.microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trainbooking.microservice.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {

	Optional<Route> findByRouteId(Long routeId);

	Optional<Route> findBySourceAndDestination(String fromLocation, String toLocation);
	
	@Modifying
	@Query(value = "delete from {h-schema}ROUTE e where e.TRAIN_ID =?1", nativeQuery = true)
	int deleteRoute(Long routeId);

	//List<Route> findBySourceAndDestination(String fromLocation, String toLocation);

}
