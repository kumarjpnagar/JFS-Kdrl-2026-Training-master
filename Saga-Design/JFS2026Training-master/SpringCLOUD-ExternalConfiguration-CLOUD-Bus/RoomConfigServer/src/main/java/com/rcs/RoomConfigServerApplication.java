package com.rcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//Activate this application as Config Server
@EnableConfigServer
public class RoomConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomConfigServerApplication.class, args);
	}

}
