package com.rba.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class Room {

	@Min(100)
	@Max(999)
	private int roomId;
	
	@Length(min = 5, max =20,message = "Please have minimun 5 cahracters")
	//@Pattern()
	private String roomName;
	private int roomCapacity;
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", roomCapacity=" + roomCapacity + "]";
	}

	public Room(int roomId, String roomName, int roomCapacity) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomCapacity = roomCapacity;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	
	
}
