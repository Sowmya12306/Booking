package com.trainbooking.microservice.trainUtill;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.trainbooking.microservice.appConstants.AppConstants;

@Component
public class TrainUtill {
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
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

}
