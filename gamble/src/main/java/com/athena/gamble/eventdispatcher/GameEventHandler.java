package com.athena.gamble.eventdispatcher;

import java.util.HashSet;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;

public abstract class GameEventHandler {
	HashSet<SFSEventType> events = new HashSet<SFSEventType>();
	String serviceName;
	
	public abstract void handleEvent(SFSEventType event, User user, String message, ISFSObject params);
	
	void registerService(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public boolean hasService(String serviceName) {
		return this.serviceName.equals(serviceName);
	}
	
	public void registerEvent(SFSEventType event) {
		events.add(event);
	}
	
	public boolean hasEventHandler(SFSEventType event) {
		return events.contains(event);
	}
}