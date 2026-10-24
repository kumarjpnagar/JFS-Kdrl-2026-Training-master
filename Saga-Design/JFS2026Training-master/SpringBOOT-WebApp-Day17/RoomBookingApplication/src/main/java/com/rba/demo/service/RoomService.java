package com.rba.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rba.demo.dao.RoomDAO;
import com.rba.demo.dto.RoomDTO;
import com.rba.demo.entities.RoomEntity;
import com.rba.demo.exceptions.RoomIDExistsException;
import com.rba.demo.exceptions.RoomIDNotFoundException;
import com.rba.demo.model.Room;

@Service
public class RoomService {

	@Autowired
	RoomDAO roomDAO;
	String demo;
	
	public List<RoomEntity> getAllRoom(){
		return  roomDAO.getAllRoom();
	}
	
	public Room findByRoomId(int roomId)throws RoomIDNotFoundException  {
		
		return roomDAO.findByRoomId(roomId);
	}
	
	public List<Room> findByRoomCapacity(int roomCapacity) {
		
		return roomDAO.findByRoomCapacity(roomCapacity);
	}
	
	public void insertRoom(RoomDTO roomDTO)throws RoomIDExistsException {
		
		roomDAO.insertRoom(roomDTO);
	}
}
