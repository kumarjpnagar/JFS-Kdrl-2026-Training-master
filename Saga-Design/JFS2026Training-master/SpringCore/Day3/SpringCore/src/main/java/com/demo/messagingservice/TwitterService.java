package com.demo.messagingservice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("twitter")
public class TwitterService implements MessageService {

	@PostConstruct()
	public void init() {
		// add some resource for the instance
		System.out.println("The Twitter Instance Got Created!");
	}

	@PreDestroy()
	public void destroy() {
		// clean up resource work of code
		System.out.println("The Twitter Instance Is About to Get Destroy");
	}
	
	//@Value(value = "4")
	//Spring Expression Language
	//SPeL syntax ${} #{}
	@Value("${messageLimit}")
	private int ml;
	
	private int shortMessageLines;

	public TwitterService() {
		// TODO Auto-generated constructor stub
	}
	
	public TwitterService(int shortMessageLines) {
		this.shortMessageLines = shortMessageLines;
	}

	// Implementation for the Contract method is defined here
	public void sendMessage(String message) {
			System.out.println(ml);
		if (this.shortMessageLines <= ml)
			System.out.println("Twitter:" + message);
		else
			System.out.println("Sorry the Tweet is more than 4 lines!.. ");

	}
}
