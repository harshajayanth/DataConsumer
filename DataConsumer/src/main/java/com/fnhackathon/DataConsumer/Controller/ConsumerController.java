package com.fnhackathon.DataConsumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnhackathon.DataConsumer.Service.ConsumerService;

@RestController
@RequestMapping("/api")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@PostMapping("/consume")
	public String Consume() {
		try {
		return consumerService.consumeOrder();
		}
		catch(Exception e) {
			return e.toString();
		}
	}
}
