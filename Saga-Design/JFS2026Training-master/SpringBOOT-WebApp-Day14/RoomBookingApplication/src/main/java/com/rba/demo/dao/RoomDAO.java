package com.rba.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.rba.demo.model.Room;


@Repository
public class RoomDAO {

	List<Room> rooms = new ArrayList<>();
	
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
	
	public List<Room> getAllRoom(){
		return rooms;
	}
	
	public Room findByRoomId(int roomId) {
		Room room = null;
	
//		Optional<Room> optional =  rooms.stream()
//		.filter((r)-> r.getRoomId()==roomId)
//		.findFirst();
//		
//		return  optional.get();
		
		for(Room tmp: rooms) {
			
			if(tmp.getRoomId() == roomId) {
				room = tmp;
			}
		}
		
		return room;
	}
	
	public List<Room> findByRoomCapacity(int roomCapacity) {
		
		return rooms.stream()
				.filter((r) -> r.getRoomCapacity() == roomCapacity)
				.collect(Collectors.toList());
	}
}
