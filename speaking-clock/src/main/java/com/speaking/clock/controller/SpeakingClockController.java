package com.speaking.clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speaking.clock.exception.TimeNotfoundException;
import com.speaking.clock.model.ApiResponseModel;
import com.speaking.clock.service.SpeakingClockService;

@RestController
public class SpeakingClockController {
	
	@Autowired
	SpeakingClockService speakingClockService;
	
	@GetMapping("/speaking")
	public ResponseEntity<?> getTime(@RequestParam(value = "time") String time) {
		if(time == null || time.equals("")) {
			throw new TimeNotfoundException();
		}
		ApiResponseModel response = speakingClockService.speakingClockFunction(time);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
