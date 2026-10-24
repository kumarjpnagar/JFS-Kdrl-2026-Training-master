package com.rba.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rba.demo.entities.RoomEntity;

public interface RoomRepositroy extends JpaRepository<RoomEntity, Integer> {

	//DQL - Data Query Language
	public List<RoomEntity> findByRoomCapacity(int roomCapacity);
	
	//DML - Data Manipulation Language
	@Transactional
	public int deleteByRoomCapacity(int roomCapacity);
	
	@Transactional
	@Modifying
	//Indicates a query method should be considered as modifying query 
	@Query(value = "update RoomEntity set roomCapacity= :roomCapacity where roomId= :roomId")
	public void updateRoomCapacity(int roomId, int roomCapacity);
}
