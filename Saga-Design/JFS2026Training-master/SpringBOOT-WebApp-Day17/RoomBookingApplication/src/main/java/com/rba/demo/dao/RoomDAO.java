package com.rba.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rba.demo.dto.RoomDTO;
import com.rba.demo.entities.RoomEntity;
import com.rba.demo.exceptions.RoomIDExistsException;
import com.rba.demo.exceptions.RoomIDNotFoundException;
import com.rba.demo.model.Room;


@Repository
public class RoomDAO {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RoomRepositroy roomRepository;
	
	static List<Room> rooms = new ArrayList<>();
	
	public RoomDAO() {
	
		Room room1  = new Room(101,"TMCC",34);
		Room room2  = new Room(102,"TMCC Training Room",34);
		Room room3  = new Room(103,"TMCC Auditorium",80);
		Room room4  = new Room(104,"Library",24);
		Room room5  = new Room(105,"Learning Hall",80);
		
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room5);
	}
	
	public List<RoomEntity> getAllRoom(){
		//select * from rooms
		return roomRepository.findAll();
	}
	
	public Room findByRoomId(int roomId) throws RoomIDNotFoundException {
		//Room room = null;
	
//		Optional<Room> optional =  rooms.stream()
//		.filter((r)-> r.getRoomId()==roomId)
//		.findFirst();
//		
//		return  optional.get();
		
//		for(Room tmp: rooms) {
//			
//			if(tmp.getRoomId() == roomId) {
//				room = tmp;
//			}
//		}
		//select * from rooms where roomid = ?
		Optional<RoomEntity> re = roomRepository.findById(roomId);
		RoomEntity roomEntity = null;
		if(re.isEmpty()) {
			throw  new RoomIDNotFoundException("Hey Your Given Room ID Does Not Exists!");
		}else {
			roomEntity = re.get();
		}
		Room room = modelMapper.map(roomEntity,Room.class);
		return room;
	}
	
	public List<Room> findByRoomCapacity(int roomCapacity) {
		
		return rooms.stream()
				.filter((r) -> r.getRoomCapacity() == roomCapacity)
				.collect(Collectors.toList());
	}
	
	public void insertRoom(RoomDTO roomDTO) throws RoomIDExistsException {
		
		RoomEntity roomEntity = modelMapper.map(roomDTO, RoomEntity.class);
	
		//persist the object into ORM engine and
		//the ORM engine will parallely instruct 
		//the DB to create an equalant row 
		//and the row will be mapped to this object
		//Hibernate ORM Lifecycle
		
		//select * from rooms where roomid = ?
		Optional<RoomEntity> re = roomRepository.findById(roomEntity.getRoomId());
		
		if(!re.isEmpty()) {
			throw  new RoomIDExistsException("Hey , Already Room Exists");
		}
		
		roomRepository.save(roomEntity);
	}
}
