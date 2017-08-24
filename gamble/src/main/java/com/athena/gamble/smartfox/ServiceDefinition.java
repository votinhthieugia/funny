package com.athena.gamble.smartfox;

import java.util.HashMap;

import com.athena.gamble.smartfox.eventhandler.LoginEventHandler;
import com.athena.gamble.smartfox.eventhandler.LogoutEventHandler;
import com.athena.gamble.smartfox.requesthandler.TalaRequestHandler;
import com.smartfoxserver.v2.core.SFSEventType;

public class ServiceDefinition {
	public static HashMap<String, Class<? extends RequestHandler>> services;
	public static HashMap<SFSEventType, Class<? extends EventHandler>> events;
	
	static {
		services = new HashMap<String, Class<? extends RequestHandler>>();
		services.put(GameId.TALA, TalaRequestHandler.class);
		
		events = new HashMap<SFSEventType, Class<? extends EventHandler>>();
		events.put(SFSEventType.USER_LOGIN, LoginEventHandler.class);
		events.put(SFSEventType.USER_LOGOUT, LogoutEventHandler.class);
	}
}