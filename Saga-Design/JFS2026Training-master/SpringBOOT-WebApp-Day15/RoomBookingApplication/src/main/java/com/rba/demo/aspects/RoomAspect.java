package com.rba.demo.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.rba.demo.dto.RoomDTO;

@Aspect
@Configuration
public class RoomAspect {
	
	@AfterReturning(value="execution(public * insertRoom(..))",returning = "responseEntity")
	public void insertRoom(Object responseEntity) {
		
		System.out.println(responseEntity);
		//System.out.println(responseEntity.getBody());
		//ResponseEntity<String> re = (ResponseEntity<String>) responseEntity;
		//System.out.println(re.getBody());
		//System.out.println(room.getRoomName());
		//ResponseEntity<RoomDTO> response = (ResponseEntity<RoomDTO>) responseEntity;
		
		//System.out.println(response.getBody().getRoomName());
	}
}
