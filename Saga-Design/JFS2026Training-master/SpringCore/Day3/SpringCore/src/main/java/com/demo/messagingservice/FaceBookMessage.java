package com.demo.messagingservice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("fb")
public class FaceBookMessage implements MessageService {

	// ngOnInit() and ngOnDestroy()
	// in spring bean Lifecycle method names are user defined

	public FaceBookMessage() {
		System.out.println("This FB Constructor");
	}

	@PostConstruct()
	public void init() {
		// add some resource for the instance
		System.out.println("The FB Instance Got Created!");
	}

	@PreDestroy()
	public void destroy() {
		// clean up resource work of code
		System.out.println("The FB Instance Is About to Get Destroy");
	}

	public void sendMessage(String message) {

		System.out.println("Facebook" + message);

	}
}
