package com.athena.gamble.smartfox;

import com.smartfoxserver.v2.annotations.MultiHandler;
import com.smartfoxserver.v2.api.SFSApi;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.Zone;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

@MultiHandler
public class RequestHandler extends BaseClientRequestHandler {
	protected Zone zone;
	protected SFSExtension extension;
	protected SFSApi sfsApi;
	
	public void handleClientRequest(User user, ISFSObject params) {
		extension = getParentExtension();
		zone = extension.getParentZone();
		sfsApi = (SFSApi)getApi();
		
		ISFSObject out = new SFSObject();
		String requestId = params.getUtfString(SFSExtension.MULTIHANDLER_REQUEST_ID);
		String commandId = GetCommandId(requestId);
		handleRequest(commandId, user, params, out);
		extension.send(requestId, out, user);
		trace("handleClientRequest:done");
		afterRequest();
	}
	
	protected void handleRequest(String commandId, User player, ISFSObject params, ISFSObject out) {
	}
	
	protected void afterRequest() {
	}
	
	private String GetCommandId(String requestId) {
		String[] arr = requestId.split("\\.");
		return arr[arr.length - 1];
	}
}