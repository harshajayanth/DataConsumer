package com.fnhackathon.DataConsumer.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class RedisService {
	
	@Value("${redis.port}")
	private int REDIS_PORT;
	
	private Jedis getJedisConnection() {
		Jedis jedis=new Jedis("localhost",REDIS_PORT);
		return jedis;
	}

	public void insertOrder(String Message) {
		Jedis jedis=getJedisConnection();
		
		 JSONObject jsonMessage = new JSONObject(Message);

		jedis.hset("TradeOrders",jsonMessage.getString("ticker"),String.valueOf(jsonMessage));
	}

}
