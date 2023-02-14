package com.speaking.clock.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.speaking.clock.exception.InvalidTimeException;
import com.speaking.clock.exception.NumberFormaterException;
import com.speaking.clock.exception.TimeConvertionException;
import com.speaking.clock.model.ApiResponseModel;
import com.speaking.clock.model.SpeakingClockModel;

@Service
public class SpeakingClockService {

	SpeakingClockModel modelObj = new SpeakingClockModel();
	
	public String[] checkTimeValidOrNot(String time) {

        try {
        	time.trim().split(":");
        } catch (Exception e) {
            throw new NumberFormaterException();
        }

        String[] times = time.trim().split(":");

        try {
            Integer.parseInt(times[0]);
            Integer.parseInt(times[1]);
        } catch (Exception e) {
            throw new NumberFormaterException();
        }
        return times;
    }
	
	public ApiResponseModel speakingClockFunction(String time) {
		
		ApiResponseModel apiResponse = new ApiResponseModel();
		
		String[] times = checkTimeValidOrNot(time);

        String hourInWords = convertToWords(Integer.parseInt(times[0]), Integer.parseInt(times[1]));

        if (hourInWords.equals("")) {
        	throw new TimeConvertionException();
        } else {
        	
        	apiResponse.setMsg(hourInWords);
        	apiResponse.setDateTime(LocalDateTime.now());
        }
        return apiResponse;
	}

	private String convertToWords(int hour, int minutes) {

		String result ="";
		
		try {

        if (minutes == 0) {

            if (hour == 12) {
            	return "It's Midday";
            }else if (hour == 24) {
            	return "It's Midnight";
            }else {
            	 result = "It's "+ modelObj.ONES[hour % 12];
            }

        } else if (minutes % 10 == 0) {
        	 result = "It's " + modelObj.ONES[hour % 12]+""+ modelObj.TENS[(minutes / 10)];
        } else if (minutes < 10 || minutes > 20) {
        	result = "It's " + modelObj.ONES[hour % 12]+""+ modelObj.TENS[(minutes / 10)]+""+modelObj.ONES[minutes % 10];
        } else {
        	 result = "It's " + modelObj.ONES[hour % 12]+""+ modelObj.ONES[minutes];
        }

		} catch (Exception e) {
			throw new InvalidTimeException();
		}
        return result.trim();
    }
}
