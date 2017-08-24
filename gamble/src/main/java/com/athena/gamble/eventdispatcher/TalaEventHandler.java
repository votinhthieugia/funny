package com.athena.gamble.eventdispatcher;

import com.athena.gamble.smartfox.GameId;
import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;

public class TalaEventHandler extends GameEventHandler {
	public TalaEventHandler() {
		registerService(GameId.TALA);
		registerEvent(SFSEventType.USER_JOIN_ROOM);
		registerEvent(SFSEventType.USER_LEAVE_ROOM);
		registerEvent(SFSEventType.USER_DISCONNECT);
	}
	
	@Override
	public void handleEvent(SFSEventType event, User user, String message, ISFSObject params) {
	}
}