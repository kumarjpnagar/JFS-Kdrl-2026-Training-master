package com.rba.demo.model;

public class Room {

	private int roomId;
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
