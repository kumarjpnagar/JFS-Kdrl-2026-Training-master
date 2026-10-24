package com.rba.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rba.demo.entities.RoomEntity;

public interface RoomRepositroy extends JpaRepository<RoomEntity, Integer> {

}
