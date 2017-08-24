package com.athena.gamble.eventdispatcher;

import java.util.ArrayList;
import java.util.List;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;

public class GameEventManager {
	static GameEventManager instance;
	List<GameEventHandler> eventHandlers;
	
	public static GameEventManager getInstance() {
		if (instance == null) {
			instance = new GameEventManager();
		}
		
		return instance;
	}
	
	private GameEventManager() {
		eventHandlers = new ArrayList<GameEventHandler>();
	}
	
	public void handleEvent(SFSEventType event, User user, String message, ISFSObject params) {
		String serviceName = "";
		
		for (GameEventHandler handler : eventHandlers) {
			if (handler.hasService(serviceName) && handler.hasEventHandler(event)) {
				handler.handleEvent(event, user, message, params);
			}
		}
	}
	
	public void registerEventHandler(GameEventHandler handler) {
		eventHandlers.add(handler);
	}
}
