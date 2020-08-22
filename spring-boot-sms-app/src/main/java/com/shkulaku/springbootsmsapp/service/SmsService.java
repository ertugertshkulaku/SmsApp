package com.shkulaku.springbootsmsapp.service;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.shkulaku.springbootsmsapp.model.Sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SmsService {

	    
	    private final String ACCOUNT_SID ="Enter SID";

	    private final String AUTH_TOKEN = "Enter pass";

	    private final String FROM_NUMBER = "Enter number";

	    public void send(Sms sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}
