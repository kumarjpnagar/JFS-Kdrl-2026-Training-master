package com.rba.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rba.demo.dto.RoomDTO;
import com.rba.demo.model.Book;
import com.rba.demo.model.Room;
import com.rba.demo.service.RoomService;

//@Controller
@RestController
@RequestMapping("/rooms/api")
public class RoomBookingController {

	@Autowired
	RoomService roomService;
	
	@Autowired
	Book book;
	
	@Autowired
	ModelMapper modelMapper;
	
	//RequestHandler Methods
	//GET,POST,PUT,DELETE
	//doGet(),doPost()
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	//@GetMapping("/welcome")
	//@PostMapping
	//@PutMapping
	//@DeleteMapping
	@ResponseBody
	//Annotation that indicates a method return value 
			//should be bound to the webresponse body
	public String welcome() {
		return "Welcome To Room Booking!";
	}
	
	@GetMapping("/allrooms")
	//@ResponseBody
	public List<Room> getAllRooms() {
		int x = 10/0;
		return roomService.getAllRoom();
	}
	
//	@ExceptionHandler(value = {ArrayIndexOutOfBoundsException.class})
//	public String handleAnyException1(Exception ex) {
//		
//		return "This is an Array Index Error: "+ex.getMessage();
//	}
//	
	@ExceptionHandler(value = {ArithmeticException.class})
	public String handleAnyException2(Exception ex) {
		
		return "SABARI: "+ex.getMessage();	
	}
//	1. RequestParam
//	2. PathVariable - URITemplating Concept
//	3. Sending the complete Object DATA - RequestBody
	
//	@GetMapping("/roomid")
//	public Room findByRoomId(@RequestParam("rid") int roomId,
//				@RequestParam("rname") String roomname) {
//		
////		HttpServletRequest request;
////		
////		String id = request.getParameter("rid");
////		
////		int rid = Integer.parseInt(id);
//		
//		return roomService.findByRoomId(roomId);
//	
//	}
	
	//URITempalting - Concept
	//URITemplating Variable in your endpoint
	@GetMapping(value = "/roomid/{roomId}/{roomName}"
			,produces = {MediaType.APPLICATION_XML_VALUE})
	public Room findByRoomId(@PathVariable int roomId,
			@PathVariable String roomName) {
		
		return roomService.findByRoomId(roomId);
	
	}
	
	@GetMapping(value="/roomcapacity/{rcapacity}",produces = {MediaType.APPLICATION_XML_VALUE})
	public List<Room> findByRoomCapacity(@PathVariable(value = "rcapacity") int roomCapacity){
		
		return roomService.findByRoomCapacity(roomCapacity);
	}
	
	
	
	@PostMapping(value= "/insert",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RoomDTO> insertRoom(@RequestBody @Valid Room room) {
		
		//Manual Mapping from Room to RoomDTO is happening
		//RoomDTO roomDTO = new RoomDTO(room.getRoomId(),room.getRoomName(),room.getRoomCapacity());
		ModelMapper mp1 = new ModelMapper();
		RoomDTO roomDTO = mp1.map(room, RoomDTO.class);
		System.out.println(roomDTO);
		roomService.insertRoom(roomDTO);
		
		HttpHeaders headerMap = new HttpHeaders();
		//MediaType mediaType = new MediaType(MediaType.APPLICATION_XML_VALUE);
		//httpHeader.setContentType(mediaType);
		headerMap.setContentLength(10);
		
		//ResponseEntity<RoomDTO> responseEntity = new ResponseEntity<RoomDTO>(roomDTO,HttpStatus.CREATED);
		
		ResponseEntity<RoomDTO> responseEntity = new ResponseEntity<RoomDTO>(roomDTO,headerMap,HttpStatus.OK);
		return responseEntity;
		
	}
	
	
	@GetMapping("/book")
	public void printBookDetails() {
		book.printBookName();
	}
	
}