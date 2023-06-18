package com.trainbooking.microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trainbooking.microservice.entity.TrainEntity;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity, Long>, JpaSpecificationExecutor<TrainEntity>{

	Optional<TrainEntity> findByTrainNumber(Long trainId);

	@Modifying
	@Query(value = "delete from {h-schema}TRAIN where TRAIN_ID =?1", nativeQuery =true )
	int deleteTrainId(Long trainId);

	@Query(value = "SELECT FROM {h-schema}TRAIN e where e.FROM_LOCATION=?1 and TO_LOCATION=?2", nativeQuery = true)
	List<TrainEntity> findByFromLocationAndToLocation(String fromLocation, String toLocation);

	@Modifying
	@Query(value = "update {h-schema}TRAIN set AVAILABLE_SEATS=?1 where TRAIN_ID=?2", nativeQuery = true)
	void updateTrainAvlSeats(Long avlSeats, Long trainId);



}