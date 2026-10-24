package com.rba.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rba.demo.dao.RoomDAO;
import com.rba.demo.dto.RoomDTO;
import com.rba.demo.model.Room;

@Service
public class RoomService {

	@Autowired
	RoomDAO roomDAO;
	
	public List<Room> getAllRoom(){
		return  roomDAO.getAllRoom();
	}
	
	public Room findByRoomId(int roomId) {
		
		return roomDAO.findByRoomId(roomId);
	}
	
	public List<Room> findByRoomCapacity(int roomCapacity) {
		
		return roomDAO.findByRoomCapacity(roomCapacity);
	}
	
	public void insertRoom(RoomDTO roomDTO) {
		
		roomDAO.insertRoom(roomDTO);
	}
}
