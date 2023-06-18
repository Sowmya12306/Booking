package com.trainbooking.microservice.service;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.trainbooking.microservice.appConstants.AppConstants;
import com.trainbooking.microservice.domain.AdminAddNewTrainRequest;
import com.trainbooking.microservice.domain.AdminResponse;
import com.trainbooking.microservice.domain.AdminSignUpRequest;
import com.trainbooking.microservice.domain.TicketBookingDomain;
import com.trainbooking.microservice.domain.TicketBookingRequest;
import com.trainbooking.microservice.domain.TrainDomain;
import com.trainbooking.microservice.entity.Route;
import com.trainbooking.microservice.entity.TicketEntity;
import com.trainbooking.microservice.entity.TrainEntity;
import com.trainbooking.microservice.entity.TrainStopsEntity;
import com.trainbooking.microservice.entity.UsersEntity;
import com.trainbooking.microservice.exception.BadRequestException;
import com.trainbooking.microservice.exception.Error;
import com.trainbooking.microservice.exception.Errors;
import com.trainbooking.microservice.exception.TrainBookingServiceException;
import com.trainbooking.microservice.repository.RouteRepository;
import com.trainbooking.microservice.repository.TicketBookRepository;
import com.trainbooking.microservice.repository.TrainRepository;
import com.trainbooking.microservice.repository.TrainStopsRepository;
import com.trainbooking.microservice.repository.UserRepository;
import com.trainbooking.microservice.trainMapper.TrainMapper;
import com.trainbooking.microservice.trainUtill.TrainUtill;

@Service
public class TrainBookingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final String CLASSNAME = "TrainBookingService";
	
	@Autowired(required = false)
	UserRepository userRepository;
	
	@Autowired(required = false)
	TrainStopsRepository trainStopsRepository;
	
	@Autowired(required = false)
	TrainRepository trainRepository;
	
	
	@Autowired(required = false)
	TicketBookRepository ticketBookingRepository;
	
	@Autowired(required = false)
	RouteRepository routeRepository;
	
	@Autowired
	TrainUtill trainUtill;
	
	@Autowired
	TrainMapper trainMapper;
	
	/**
	 * This method for registering the Admin
	 * @param request
	 * @return
	 */
	@Transactional
	public AdminResponse adminSignUp(AdminSignUpRequest request) {	
		AdminResponse adminResponse= new AdminResponse();
		UsersEntity userSignup= new UsersEntity();
		try {
			LOGGER.info("Inside Admin signUp");
			if(request!=null) {	
				UsersEntity save =null;
				Optional<UsersEntity> existRecord = userRepository.findByFirstNameAndEmailId(request.getFirstName(), request.getEmailId());
				if(existRecord.isPresent() && request.getUserId()==null) {
					//Error error = new Error("400", AppConstants.BAD_REQUEST);
		            throw new BadRequestException(null, "User Already Exist: " + request.getFirstName(), null);
				}else {
					//Updating existing Admin details
					if(existRecord.isPresent() && request.getUserId()!=null) {
						UsersEntity updateAdminOrUserDetails = trainMapper.updateAdminOrUserDetails(existRecord,userSignup,request);
						save = userRepository.saveAndFlush(updateAdminOrUserDetails);
						if(save!=null) {
							String message ="Admin/User Updated successFully!!";
							adminResponse=getResponse(adminResponse,message,null);
							
						}else {
							String message ="Admin/User Update is failed please check the details";
							adminResponse=getResponse(adminResponse,message,null);
						}
						
					}else {
						//saving the new Admin details
						userSignup = trainMapper.userDomainToEntity(userSignup, request);
						save = userRepository.save(userSignup);
						if(save!=null) {
							String message ="Admin/User Registered successFully!!";
							adminResponse=getResponse(adminResponse,message,null);
							
						}else {
							String message ="Admin/User registartion is failed please check the details";
							adminResponse=getResponse(adminResponse,message,null);
						}
					}
				}
				
			}else {
				throw new BadRequestException(null, "Requested fileds are mandatory " + request, null);
			}
			
		}catch (BadRequestException e) {
			LOGGER.error("Exception in Admin Service - registering the details", e);
			throw e;
		}
		return adminResponse;
	}
	

	private List<Error> getErrors(Error error) {
        List<Error> errors = new ArrayList<>();
        errors.add(error);
        return errors;
    }


	private AdminResponse getResponse(AdminResponse adminResponse, String message, String uuid) {
		adminResponse.setMessage(message);
		adminResponse.setRequestIdentifier(uuid);
		adminResponse.setTransactionDate(getTransactionDate());
		adminResponse.setSuccess(true);
		return adminResponse;

	}

/**
 * For Validating the USER and ADMIN Credentials 
 * @param appId
 * @param uuid
 * @return
 */
	public AdminResponse validateAdminUser(String emailId, String passWord) {
		AdminResponse adminResponse= new AdminResponse();
		try {
			Optional<UsersEntity> userExist = userRepository.findByEmailIdAndPassWord(emailId, passWord);
			if(userExist.isPresent()) {
				String message="Welcome " +userExist.get().getFirstName();
				adminResponse=getResponse(adminResponse, message, null);
				return adminResponse;
			}else {
				//Please change asper request:)
				Optional<UsersEntity> findByEmailId = userRepository.findByEmailId(emailId);
				if(findByEmailId.isPresent()) {
					throw new BadRequestException(null, "Password doesnot match for emailId:  " + emailId, null);
				}else {
					throw new BadRequestException(null, "EmailId doesnot exist please sign-up  " + emailId, null);
				}
			}
		} catch (BadRequestException e) {
			LOGGER.error("Exception in validating Admin details", e);
			throw e;

		}
	}
	
	/**
	 * @return
	 */
	public String getTransactionDate(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat(AppConstants.UTC_FORMAT);
		String now="";
		try {
			now = format.format(date);
		} catch (Exception e) {
			LOGGER.error("Error while creating transaction date :", e);
		}  
		
		return now;
    }

/**
 * For Adding the new Train Details her and Updating the Train Details
 * @param request
 * @return
 */
	@Transactional
	public AdminResponse adminAddNewTrains(AdminAddNewTrainRequest request) {
		AdminResponse adminResponse = new AdminResponse();
		TrainEntity trainEntity = new TrainEntity();
		Route route = new Route();
		TrainStopsEntity trainStopsEntity = new TrainStopsEntity();
		try {
			// Need to check weather this user role Admin or not if its an user we should
			// throw an error
			if (request != null && request.getUserId() != null) {
				Optional<UsersEntity> userRoleCheck = userRepository.findByUserId(request.getUserId());
				if (userRoleCheck.isPresent() && userRoleCheck.get().getUserRole().equalsIgnoreCase("admin")) {
					// For edit the Specific train will get the TrainId from the request this can be
					// done admin
					if (request != null && request.getRoute().getRouteId() != null) {
						Optional<Route> trainExist = routeRepository.findByRouteId(request.getRoute().getRouteId());
						if (trainExist.isPresent()) {
							Route mapDomainToUpdateEntity = trainMapper.mapDomainToUpdateEntity(request,
									trainExist.get());
							if (mapDomainToUpdateEntity != null) {
								Route updatedTrainDetails = routeRepository.saveAndFlush(mapDomainToUpdateEntity);
								if (updatedTrainDetails != null) {
									String message = "Train Updated succsesfully trainName:"
											+ request.getRoute().getRouteName();
									adminResponse = getResponse(adminResponse, message, null);
								}
							} else {
								String message = "Train Details not updated please check the details"
										+ request.getTrainName();
								adminResponse = getResponse(adminResponse, message, null);
							}

						}
					} else {
						// For Adding the new train details we don't get TrainId first and this can be
						// done admin
						route = trainMapper.mapDomainToEntity(trainEntity, request, trainStopsEntity, route);
						Route saveTrain = routeRepository.saveAndFlush(route);

						if (saveTrain != null) {
							String message = "Train Added succsesfully!!" ;
							adminResponse = getResponse(adminResponse, message, null);
						} else {
							String message = "Train Details not inserted/updated please check the details";
							adminResponse = getResponse(adminResponse, message, null);
						}
					}

				} else {
					throw new BadRequestException(null, "user doesnot have the access to update the trainDetails: "
							+ userRoleCheck.get().getFirstName(), null);
				}
			}
		} catch (BadRequestException e) {
			LOGGER.error("Exception in Adding the new train details", e);
			throw e;

		}
		return adminResponse;
	}

	/**
	 * Deleted/Cancelled the train record from train table
	 * 
	 * @param appId
	 * @return
	 */
@Transactional
public AdminResponse deleteTrain(String trainId) {
	AdminResponse adminResponse= new AdminResponse();
	try {
		if(trainId!=null) {
			int deletChildRecord = trainStopsRepository.deleteTrainStops(Long.valueOf(trainId));
			if (deletChildRecord!=0) {
				 int deleteTrainId = trainRepository.deleteTrainId(Long.valueOf(trainId));
				if(deleteTrainId!=0) {
					String message ="Train Deleted Successfully :" +trainId;
					adminResponse=getResponse(adminResponse,message,null);
				}
			}
		}
	}catch (Exception e) {
		LOGGER.error("Exception in deleting the train details", e);
		throw e;
	}
	return adminResponse;
}

/**
 * getFromAndToLocDetails from train
 * @param appId
 * @param uuid
 * @return
 */
public AdminResponse getFromAndToLocDetails(String fromLocation, String toLocation) {
	AdminResponse adminResponse = new AdminResponse();
	List<com.trainbooking.microservice.domain.Route> routeDomain = new ArrayList<com.trainbooking.microservice.domain.Route>();
	try {
		Optional<Route> routeDetails = routeRepository.findBySourceAndDestination(fromLocation, toLocation);
		if (routeDetails.isPresent()) {
			List<com.trainbooking.microservice.domain.Route> mapTrainEntityToDomain = trainMapper
					.mapTrainEntityToDomain(routeDetails.get(), routeDomain);
			adminResponse.setRoute(mapTrainEntityToDomain);
			adminResponse.setSuccess(true);
			adminResponse.setTransactionDate(getTransactionDate());

		} else {
			throw new BadRequestException(null, "no train found from " + fromLocation + " to " + toLocation, null);
		}
	} catch (BadRequestException e) {
		LOGGER.error("Exception while getting train details", e);
		throw e;

	}
	return adminResponse;
}


/**
 * this is for booking the ticket
 * @param request
 * @return
 */
@Transactional
public AdminResponse adminUserTicketBook(TicketBookingRequest request) {
	AdminResponse adminResponse = new AdminResponse();
	TicketEntity ticketEntity = new TicketEntity();
	try {
		// Checking the USER/Admin details
		Optional<TrainEntity> trainDetails = trainRepository.findByTrainNumber(request.getTrainNumber());
		if(trainDetails.isPresent()) {
		Optional<UsersEntity> userDetails = userRepository.findByUserId(request.getUserId());
		if (userDetails.isPresent()) {
			Optional<Route> routeDetails = routeRepository.findByRouteId(request.getRouteId());
			if (routeDetails.isPresent()) {
				Optional<TrainStopsEntity> stopTicket = trainStopsRepository.stationInfo(request.getDestination());
//				Optional<TrainStopsEntity> findAny = routeDetails.get().getTrainStops().stream().filter(stop-> stop.getStationName().equals(stopTicket.get().getArriVal())).findAny();
				if(stopTicket.isPresent()) {
					for(TrainStopsEntity trainStop : routeDetails.get().getTrainStops()) {
						if(trainStop.getStationName().equalsIgnoreCase(stopTicket.get().getStationName())) {
							TicketEntity mapTicketDomainToEntity = trainMapper.mapTicketDomainToEntity(request, userDetails.get(), ticketEntity, routeDetails.get(), userDetails.get());
							TicketEntity bookTicket = ticketBookingRepository.saveAndFlush(mapTicketDomainToEntity);
							if(bookTicket!=null) {
								String message = "Ticket Booked Successfully! " + bookTicket.getTicketId();
								adminResponse = getResponse(adminResponse, message, null);								}
						}
					}
//				TicketEntity mapTicketDomainToEntity = trainMapper.mapTicketDomainToEntity(request,
//						userDetails.get(), ticketEntity, routeDetails.get(), userDetails.get());
//				TicketEntity bookTicket = ticketBookingRepository.saveAndFlush(mapTicketDomainToEntity);
//				if (bookTicket != null) {
//					String message = "Ticket Booked Successfully! " + bookTicket.getTicketId();
//					adminResponse = getResponse(adminResponse, message, null);
//				}
			}
		}else {
			String message = "source and destination are not available";
			getResponse(adminResponse, message, null);
			adminResponse.setSuccess(false);
		}
	}
		}
}	
		catch (Exception e) {
		LOGGER.error("Exception while booking the tikcet", e);
		throw e;
	}

	return adminResponse;
}


/**
 * Getting Booking History Information
 * @param appId
 * @return
 */
public AdminResponse getBookingHistoryDetails(String userId) {
	AdminResponse adminResponse = new AdminResponse();
	List<TicketBookingDomain> bookingDomainList = new ArrayList<>();
	List<TicketBookingDomain> adminTicketViewInfo = new ArrayList<>();
	try {
		Optional<UsersEntity> userRoleCheck = userRepository.findById(Long.valueOf(userId));
		if (userRoleCheck.isPresent()) {
			if (userRoleCheck.get().getUserRole().equals("Admin")) {
				List<TicketEntity> getAllUserInfo = ticketBookingRepository.findAllTickets(Long.valueOf(userId));
				if (!CollectionUtils.isEmpty(getAllUserInfo)) {
					adminTicketViewInfo = trainMapper.mapEntityToDomainUserTicketInfo(getAllUserInfo,
							bookingDomainList);
				}
			} else {
				List<TicketEntity> findById = ticketBookingRepository.findAllById(Long.valueOf(userId));
				if (!CollectionUtils.isEmpty(findById)) {
					adminTicketViewInfo = trainMapper.mapEntityToDomainUserTicketInfo(findById, bookingDomainList);

				}
			}
			if (CollectionUtils.isEmpty(adminTicketViewInfo)) {
				throw new BadRequestException(null, "Error while getting the userDetails", null);
			} else {
				adminResponse.setUserDomain(adminTicketViewInfo);
				getResponse(adminResponse, null, null);
			}
		}
	} catch (BadRequestException e) {
		LOGGER.error("Exception while getting user details", e);
		throw e;

	}
	return adminResponse;
}	
}