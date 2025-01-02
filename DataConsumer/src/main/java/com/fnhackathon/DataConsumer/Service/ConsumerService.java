package com.fnhackathon.DataConsumer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@Service
public class ConsumerService {

	@Value("${kafka.serverconfig}")
	private String ServerConfig;
	
	
	@Autowired
	private RedisService redisService;
	
	List<String> messages=new ArrayList();
	
	@KafkaListener(topics= "${kafka.topic}",groupId="console-consumer-14409")
	public void consumemessage(String message) {
		 try {
	            messages.add(message);

	            //Send to Redis
	            messages.forEach(item->{
		            redisService.insertOrder(item);
	            });
	            
	        } catch (Exception e) {
	        	return;
	        }
	}

	public String consumeOrder() {
        String Response=  messages.size() + " Messages Consumed and Sent To Redis";
        messages.clear();
        return Response;
    }
}
