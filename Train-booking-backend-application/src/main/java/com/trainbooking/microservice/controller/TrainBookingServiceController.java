package com.trainbooking.microservice.controller;

import java.lang.invoke.MethodHandles;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainbooking.microservice.appConstants.AppConstants;
import com.trainbooking.microservice.domain.AdminAddNewTrainRequest;
import com.trainbooking.microservice.domain.AdminResponse;
import com.trainbooking.microservice.domain.AdminSignUpRequest;
import com.trainbooking.microservice.domain.TicketBookingRequest;
import com.trainbooking.microservice.exception.Errors;
import com.trainbooking.microservice.service.TrainBookingService;
import com.trainbooking.microservice.trainUtill.TrainUtill;

@RestController
public class TrainBookingServiceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired(required = false)
	TrainUtill trainUtill;
	
	@Autowired
	TrainBookingService trainBookingService;
	
	@PostMapping(path = "/api/v1/adminSignup")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "adminSignUpFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
	 
	public ResponseEntity<AdminResponse> adminSignUp( 
			@RequestBody AdminSignUpRequest request
	) {
		LOGGER.info("start: Admin signUp call");
		AdminResponse response = trainBookingService.adminSignUp(request);
		LOGGER.info("end: Admin signUp End call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
//	public ResponseEntity<AdminResponse> adminSignUpFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
//			Throwable exception) {
//		AdminResponse response = new AdminResponse();
//		Errors error = new Errors();
//		response.setRequestIdentifier(uuid);
//		response.setSuccess(false);
//		response.setTransactionDate(trainUtill.getTransactionDate());
//		error.setErrorMessage(exception.getMessage());
//		response.setErrors(error);
//		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@GetMapping(path = "/api/v1/validateAdminUser")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "validateAdminFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
	 
	public ResponseEntity<AdminResponse> validateAdminUser(
			@RequestParam(name = "emailId" ,required = true) String emailId,
			@RequestParam(name = "PassWord", required = true) String PassWord
	) {
		LOGGER.info("start: Admin signUp call");
		AdminResponse response = trainBookingService.validateAdminUser(emailId, PassWord);
		LOGGER.info("end: Admin signUp End call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
	public ResponseEntity<AdminResponse> validateAdminFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
			Throwable exception) {
		AdminResponse response = new AdminResponse();
		Errors error = new Errors();
		response.setRequestIdentifier(uuid);
		response.setSuccess(false);
		response.setTransactionDate(trainUtill.getTransactionDate());
		error.setErrorMessage(exception.getMessage());
		response.setErrors(error);
		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PostMapping(path = "/api/v1/adminAddNewTrains")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "adminAddNewTrainsFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
	 
	public ResponseEntity<AdminResponse> adminAddNewTrains( 
			@Valid @RequestBody AdminAddNewTrainRequest request
	) {
		LOGGER.info("start: Admin signUp call");
		AdminResponse response = trainBookingService.adminAddNewTrains(request);
		LOGGER.info("end: Admin signUp End call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
//	public ResponseEntity<AdminResponse> adminAddNewTrainsFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
//			Throwable exception) {
//		AdminResponse response = new AdminResponse();
//		Errors error = new Errors();
//		response.setRequestIdentifier(uuid);
//		response.setSuccess(false);
//		response.setTransactionDate(trainUtill.getTransactionDate());
//		error.setErrorMessage(exception.getMessage());
//		response.setErrors(error);
//		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@DeleteMapping(path = "/api/v1/deleteTrain")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "deleteTrainInfoFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
	 
	public ResponseEntity<AdminResponse> deleteTrainInfo(
			@RequestParam(name = "trainId", required = true) String trainId
	) {
		LOGGER.info("start: deleteTrain call");
		AdminResponse response = trainBookingService.deleteTrain(trainId);
		LOGGER.info("end: deleteTrain call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
//	public ResponseEntity<AdminResponse> deleteTrainInfoFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
//			Throwable exception) {
//		AdminResponse response = new AdminResponse();
//		Errors error = new Errors();
//		response.setRequestIdentifier(uuid);
//		response.setSuccess(false);
//		response.setTransactionDate(trainUtill.getTransactionDate());
//		error.setErrorMessage(exception.getMessage());
//		response.setErrors(error);
//		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@GetMapping(path = "/api/v1/getFromAndToLocDetails")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "getFromAndToLocDetailsFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
//	 
	public ResponseEntity<AdminResponse> getFromAndToLocDetails(
			@RequestParam(name = "fromLocation", required = true) String fromLocation,
			@RequestParam(name = "toLocation", required = true) String toLocation
	) {
		LOGGER.info("start: Admin getFromAndToLocDetails call");
		AdminResponse response = trainBookingService.getFromAndToLocDetails(fromLocation, toLocation);
		LOGGER.info("end: Admin getFromAndToLocDetails End call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
//	public ResponseEntity<AdminResponse> getFromAndToLocDetailsFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
//			Throwable exception) {
//		AdminResponse response = new AdminResponse();
//		Errors error = new Errors();
//		response.setRequestIdentifier(uuid);
//		response.setSuccess(false);
//		response.setTransactionDate(trainUtill.getTransactionDate());
//		error.setErrorMessage(exception.getMessage());
//		response.setErrors(error);
//		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@PostMapping(path = "/api/v1/adminUserTicketBook")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "adminUserTicketBookFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
	 
	public ResponseEntity<AdminResponse> adminUserTicketBook( 
			@Valid @RequestBody TicketBookingRequest request
	) {
		LOGGER.info("start: Admin signUp call");
		AdminResponse response = trainBookingService.adminUserTicketBook(request);
		LOGGER.info("end: Admin signUp End call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
//	public ResponseEntity<AdminResponse> adminUserTicketBookFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
//			Throwable exception) {
//		AdminResponse response = new AdminResponse();
//		Errors error = new Errors();
//		response.setRequestIdentifier(uuid);
//		response.setSuccess(false);
//		response.setTransactionDate(trainUtill.getTransactionDate());
//		error.setErrorMessage(exception.getMessage());
//		response.setErrors(error);
//		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@GetMapping(path = "/api/v1/getBookingHistoryDetails")
//	@HystrixCommand(commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "480000") }, threadPoolProperties = {
//		    @HystrixProperty(name = "maximumSize", value = "20"),
//		    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true") }, fallbackMethod = "getBookingHistoryDetailsFallback", ignoreExceptions = {
//			TrainBookingServiceException.class, BadRequestException.class,DataNotFoundException.class }
//	  )
	 
	public ResponseEntity<AdminResponse> getBookingHistoryDetails(
			@RequestParam(name = "userId", required = true) String userId
	) {
		LOGGER.info("start: Admin getFromAndToLocDetails call");
		AdminResponse response = trainBookingService.getBookingHistoryDetails(userId);
		LOGGER.info("end: Admin getFromAndToLocDetails End call");
		return new ResponseEntity<AdminResponse>(response, HttpStatus.OK);
	}
//	public ResponseEntity<AdminResponse> getBookingHistoryDetailsFallback(@RequestHeader(name = AppConstants.UUID) String uuid,
//			Throwable exception) {
//		AdminResponse response = new AdminResponse();
//		Errors error = new Errors();
//		response.setRequestIdentifier(uuid);
//		response.setSuccess(false);
//		response.setTransactionDate(trainUtill.getTransactionDate());
//		error.setErrorMessage(exception.getMessage());
//		response.setErrors(error);
//		return new ResponseEntity<AdminResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	 
}
