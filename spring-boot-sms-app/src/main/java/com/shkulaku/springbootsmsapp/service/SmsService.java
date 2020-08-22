package com.shkulaku.springbootsmsapp.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.shkulaku.springbootsmsapp.model.Sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SmsService {

	    
	    private final String ACCOUNT_SID ="ACaad008fc15b11a03f3dc2095da78ce78";

	    private final String AUTH_TOKEN = "3cf90474d3f9292388bbe3577e65b44d";

	    private final String FROM_NUMBER = "+12027602230";

	    public void send(Sms sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}