package com.trainbooking.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trainbooking.microservice.entity.TrainStopsEntity;

@Repository
public interface TrainStopsRepository extends JpaRepository<TrainStopsEntity, Long>, JpaSpecificationExecutor<TrainStopsEntity>{

	@Modifying
	@Query(value = "delete from {h-schema}TRAIN_STOPS e where e.TRAIN_ID =?1", nativeQuery = true)
	int deleteTrainStops(Long trainId);
	@Query(value = "select * from {h-schema}TRAIN_STOPS e where e.STATION_NAME=?1", nativeQuery = true)
	Optional<TrainStopsEntity> stationInfo(String destination);


}