package com.trainbooking.microservice.trainMapper;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.trainbooking.microservice.domain.AdminAddNewTrainRequest;
import com.trainbooking.microservice.domain.AdminSignUpRequest;
import com.trainbooking.microservice.domain.Stop;
import com.trainbooking.microservice.domain.TicketBookingDomain;
import com.trainbooking.microservice.domain.TicketBookingRequest;
import com.trainbooking.microservice.domain.TrainDomain;
import com.trainbooking.microservice.entity.Route;
import com.trainbooking.microservice.entity.TicketEntity;
import com.trainbooking.microservice.entity.TrainEntity;
import com.trainbooking.microservice.entity.TrainStopsEntity;
import com.trainbooking.microservice.entity.UsersEntity;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
@Component
public class TrainMapper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	/**
	 * Adding the new train Details
	 * @param trainEntity
	 * @param request
	 * @param trainStopsEntity 
	 * @param trainStation 
	 * @param route 
	 * @return
	 */
	public Route mapDomainToEntity(TrainEntity trainEntity, AdminAddNewTrainRequest request,
			TrainStopsEntity trainStopsEntity, Route route) {
		if (request.getRoute() != null) {
			route.setRouteName(request.getRoute().getRouteName());
			route.setDestination(request.getRoute().getDestination());
			route.setDuration(request.getRoute().getDuration());
			route.setSource(request.getRoute().getSource());
			route.setStartDate(request.getRoute().getStartDate());
			
			if (!CollectionUtils.isEmpty(request.getRoute().getTrainList())) {
				List<TrainEntity> trainsList= new ArrayList<TrainEntity>();
				request.getRoute().getTrainList().stream().forEach(trainList -> {
					TrainEntity entity= new TrainEntity();
					entity.setTrainName(trainList.getTrainName());
					entity.setTrainNumber(trainList.getTrainNumber());
					entity.setRoute(route);
					List<TrainStopsEntity> trainsStopsList= new ArrayList<TrainStopsEntity>();
					trainList.getStop().stream().forEach(tStop -> {
						TrainStopsEntity trainStops= new TrainStopsEntity();
						trainStops.setArriVal(tStop.getArriVal());
						trainStops.setStationName(tStop.getStationName());
						trainStops.setDeparture(tStop.getDeparture());
						trainStops.setRoute(route);
						trainStops.setTrain(entity);
						trainsStopsList.add(trainStops);//1,2
						entity.setTrainStops(trainsStopsList);//1,2	
						
					});	
					trainsList.add(entity);
					route.setTrains(trainsList);
				});
				
			}
		}
		return route;

	}

	/**
	 * New registration for USER and Admin
	 * @param entity
	 * @param request
	 * @return
	 */
	public UsersEntity userDomainToEntity(UsersEntity entity, AdminSignUpRequest request) {
		entity.setDob(request.getDob());
		entity.setEmailId(request.getEmailId());
		entity.setGender(request.getGender());
		entity.setLastName(request.getLastName());
		entity.setFirstName(request.getFirstName());
		entity.setUserRole(request.getUserRole());
		entity.setPhoneNumber(request.getPhoneNumber());
		entity.setPassWord(request.getPassWord());
		return entity;
		
	}

	/**
	 * Update the USER and ADMIN Details
	 * @param existRecord
	 * @param entity
	 * @param request
	 * @return
	 */
	public UsersEntity updateAdminOrUserDetails(Optional<UsersEntity> existRecord, UsersEntity entity, AdminSignUpRequest request) {
		UsersEntity usersEntity = existRecord.get();
		usersEntity.setDob(request.getDob()!=null ? request.getDob() :usersEntity.getDob());
		usersEntity.setEmailId(request.getEmailId()!=null ? request.getEmailId(): usersEntity.getEmailId());
		usersEntity.setGender(request.getGender()!=null ? request.getGender(): usersEntity.getGender());
		usersEntity.setFirstName(request.getFirstName()!=null ? request.getFirstName(): usersEntity.getFirstName());
		usersEntity.setLastName(request.getLastName()!=null ? request.getLastName() : usersEntity.getLastName());
		usersEntity.setUserRole(request.getUserRole()!=null ? request.getUserRole():usersEntity.getUserRole());
		usersEntity.setPassWord(request.getPassWord()!=null ? request.getPassWord(): usersEntity.getPassWord());
		usersEntity.setType(request.getType()!=null ? request.getType(): usersEntity.getType());
		usersEntity.setPhoneNumber(request.getPhoneNumber()!=null ? request.getPhoneNumber(): usersEntity.getPhoneNumber());
		return usersEntity;
		
	}

//	public TrainStopsEntity mapDomainToTrainStopsEntity(TrainStopsEntity trainStopsEntity,
//			AdminAddNewTrainRequest request, TrainEntity trainEntity) {
//		if (CollectionUtils.isEmpty(request.getTrainStops())) {
//			request.getTrainStops().stream().forEach(tStop ->{
//				trainStopsEntity.setTrainStop1(tStop.getStop1());
//				trainStopsEntity.setTrainStop2(tStop.getStop2());
//				trainStopsEntity.setTrainStop3(tStop.getStop3());
//				trainStopsEntity.setTrains(trainEntity);
//			});
//		}
//		return trainStopsEntity;
//
//	}

	public Route mapDomainToUpdateEntity(AdminAddNewTrainRequest request, Route route2) {
		// Route route = new Route();
		// route2.setTrainName(request.getTrainName() != null ? request.getTrainName() :
		// route2.getTrainName());

		if (request.getRoute() != null) {
			route2.setDestination(request.getRoute().getDestination() != null ? request.getRoute().getDestination()
					: route2.getDestination());
			route2.setDuration(
					request.getRoute().getDuration() != null ? request.getRoute().getDuration() : route2.getDuration());
			route2.setRouteName(
					request.getRoute().getRouteName() != null ? request.getRoute().getRouteName() : route2.getRouteName());
			route2.setSource(
					request.getRoute().getSource() != null ? request.getRoute().getSource() : route2.getSource());
			route2.setStartDate(request.getRoute().getStartDate() != null ? request.getRoute().getStartDate()
					: route2.getStartDate());
			if (!CollectionUtils.isEmpty(route2.getTrains()) && request.getRoute().getTrainList() != null) {
				List<TrainEntity> trainsList = new ArrayList<TrainEntity>();
				request.getRoute().getTrainList().stream().forEach(trainList -> {
					TrainEntity trainEntity = new TrainEntity();
					Optional<TrainEntity> findAny = route2.getTrains().stream()
							.filter(req -> req.getTrainId().equals(trainList.getTrainId())).findAny();
					if (findAny.isPresent()) {
						trainEntity.setTrainId(trainList.getTrainId() != null ? trainList.getTrainId()
								: findAny.get().getTrainId());
						trainEntity.setTrainName(trainList.getTrainName() != null ? trainList.getTrainName()
								: findAny.get().getTrainName());
						trainEntity.setTrainNumber(trainList.getTrainNumber() != null ? trainList.getTrainNumber()
								: findAny.get().getTrainNumber());
						trainEntity.setRoute(route2);
						//trainsList.add(trainEntity);
						List<TrainStopsEntity> trainsStopsList = new ArrayList<TrainStopsEntity>();
						trainList.getStop().stream().forEach(tStopList -> {
							Optional<TrainStopsEntity> findAnyTStops = findAny.get().getTrainStops().stream()
									.filter(req1 -> req1.getTrainStopId().equals(tStopList.getStopId())).findAny();
							if (findAnyTStops.isPresent()) {
								TrainStopsEntity stopsEntity = new TrainStopsEntity();
								stopsEntity.setTrainStopId(tStopList.getStopId()!=null ? tStopList.getStopId(): findAnyTStops.get().getTrainStopId());
								stopsEntity.setArriVal(tStopList.getArriVal()!=null ? tStopList.getArriVal(): findAnyTStops.get().getArriVal());
								stopsEntity.setStationName(tStopList.getStationName()!=null ? tStopList.getStationName(): findAnyTStops.get().getStationName());
								stopsEntity.setDeparture(tStopList.getDeparture()!=null ? tStopList.getDeparture(): findAnyTStops.get().getDeparture());
								stopsEntity.setTrain(trainEntity);
								stopsEntity.setRoute(route2);
								trainsStopsList.add(stopsEntity);
								trainEntity.setTrainStops(trainsStopsList);
								trainsList.add(trainEntity);
							}
						});

					}

				});

				route2.setTrains(trainsList);

			}

		}
		return route2;
	}

	/**
	 * Fetching the Source and destination train list
	 * @param route
	 * @param routeDomain
	 * @return
	 */
	public List<com.trainbooking.microservice.domain.Route> mapTrainEntityToDomain(Route route, List<com.trainbooking.microservice.domain.Route> routeDomain) {
		List<com.trainbooking.microservice.domain.Route> routeList= new ArrayList<com.trainbooking.microservice.domain.Route>();
			com.trainbooking.microservice.domain.Route tDomain = new com.trainbooking.microservice.domain.Route();
			tDomain.setDestination(route.getDestination());
			tDomain.setDuration(route.getDuration());
			tDomain.setSource(route.getSource());
			tDomain.setRouteName(route.getRouteName());
			tDomain.setStartDate(route.getStartDate());
			tDomain.setRouteId(route.getRouteId());
			if(route.getTrains()!=null) {
				List<TrainDomain> trainDomains= new ArrayList<TrainDomain>();
				route.getTrains().stream().forEach(train ->{
					TrainDomain trainDomain= new TrainDomain();
					trainDomain.setTrainId(train.getTrainNumber());
					trainDomain.setTrainName(train.getTrainName());
					trainDomain.setTrainNumber(train.getTrainNumber());
					List<Stop> stops= new ArrayList<Stop>();
					train.getTrainStops().forEach(tStop ->{
						Stop domain= new Stop();
						domain.setStopId(tStop.getTrainStopId());
						domain.setArriVal(tStop.getArriVal());
						domain.setDeparture(tStop.getDeparture());
						domain.setStationName(tStop.getStationName());
						stops.add(domain);
						
					});
					
					trainDomain.setStop(stops);
					trainDomains.add(trainDomain);
					tDomain.setTrainList(trainDomains);
				});
			}
			routeList.add(tDomain);	
		return routeList;	
	}

	/**
	 * TicketDomain Mapper
	 * @param request
	 * @param usersEntity1
	 * @param ticketEntity
	 * @param route 
	 * @param usersEntity1 
	 * @return
	 */
	public TicketEntity mapTicketDomainToEntity(TicketBookingRequest request, UsersEntity usersEntity, TicketEntity ticketEntity, Route route, UsersEntity usersEntity1) {
		ticketEntity.setDate(request.getDate());
		ticketEntity.setDestination(request.getDestination());
		ticketEntity.setSource(request.getSource());
		ticketEntity.setTrainNumber(request.getTrainNumber().toString());
		ticketEntity.setUser(usersEntity1);
		ticketEntity.setRoute(route);
		return ticketEntity;
		
	}

	public List<TicketBookingDomain> mapEntityToDomainUserTicketInfo(List<TicketEntity> getAllUserInfo,
			List<TicketBookingDomain> bookingDomainList) {
		getAllUserInfo.stream().forEach(usr ->{
			TicketBookingDomain bookingDomain= new TicketBookingDomain();
			bookingDomain.setTicketId(usr.getTicketId());
			bookingDomain.setDate(usr.getDate());
			bookingDomain.setTrainNumber(usr.getTrainNumber());
			bookingDomain.setFromLocation(usr.getSource());
			bookingDomain.setToLocation(usr.getDestination());	
			bookingDomainList.add(bookingDomain);			
		});
		return bookingDomainList;
	}
//
//	public TrainStation mapDomainToStationEntity(TrainEntity saveTrain, TrainStopsEntity trainStopsEntity,
//			TrainStation trainStation, AdminAddNewTrainRequest request) {
//		if (request.getStation() != null) {
//			trainStation.setStationName(request.getStation().getStationName());
//			if (request.getStop() != null) {
//				trainStopsEntity.setDeparture(request.getStop().getDeparture());
//				trainStopsEntity.setArriVal(request.getStop().getArriVal());
//				trainStopsEntity.setTrainStation(trainStation);
//				trainStopsEntity.setRoute(saveTrain.getRoute());
//			}
//		}
//
//		return trainStation;
//
//	}


//	/**
//	 * for updating the train station and stop details 
//	 * @param updatedTrainDetails
//	 * @param request
//	 * @param station
//	 * @return
//	 */
//	public TrainStation mapDomainToTrainStationEntity(TrainEntity updatedTrainDetails, AdminAddNewTrainRequest request, TrainStation station) {
//		List<TrainStopsEntity> stopsEntities= new ArrayList<TrainStopsEntity>();
//		if(request.getStation().getStationId()!=null) {			
//			station.setStationName(request.getStation().getStationName()!=null ? request.getStation().getStationName(): station.getStationName());
//			if(request.getStop()!=null && station.getStops()!=null) {
//				station.getStops().setArriVal(request.getStop().getArriVal()!=null ? request.getStop().getArriVal(): station.getStops().getArriVal());
//				station.getStops().setDeparture(request.getStop().getDeparture()!=null ? request.getStop().getDeparture(): station.getStops().getDeparture());
//				if(updatedTrainDetails.getRoute()!=null) {
//				station.getStops().setRoute(updatedTrainDetails.getRoute());
//				}
//			}
//		}
//		return station;
//		
//	}

	

}
