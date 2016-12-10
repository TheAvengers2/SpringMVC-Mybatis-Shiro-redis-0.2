package com.sojson.demo.domain;

import net.sf.json.JSONObject;

public class Contact {

	private int id;
	
	private String sender;
	
	private String received;
	
	public Contact(int id,String sender,String received){
		this.id = id;
		this.sender = sender;
		this.received = received;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceived() {
		return received;
	}

	public void setReceived(String received) {
		this.received = received;
	}
	
	public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}
