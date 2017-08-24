package com.athena.gamble.smartfox;

import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

public abstract class EventHandler extends BaseServerEventHandler {
	public void handleServerEvent(ISFSEvent event) throws SFSException {
		User user = (User)event.getParameter(SFSEventParam.USER);
		String message = (String)event.getParameter(SFSEventParam.MESSAGE);
		ISFSObject params = (ISFSObject)event.getParameter(SFSEventParam.OBJECT);
		process(user, message, params);
	}
	
	protected abstract void process(User user, String message, ISFSObject params);
}