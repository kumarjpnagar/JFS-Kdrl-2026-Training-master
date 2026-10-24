package com.rba.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "rooms")
public class RoomEntity {

	//CRUD
	//To create aunique filed which is called as ID field
	@Id //will mark the column of the table as P.K.C
	//@Column(name = "roomid")
	private int roomId;
	@Column(unique = true,nullable = false) //unique constraint
	private String roomName;
	//@Column(name = "capacity")
	private int roomCapacity;
	
	@Transient //(Non-Persistent Field)
	private int roomrentCalculation;
}
