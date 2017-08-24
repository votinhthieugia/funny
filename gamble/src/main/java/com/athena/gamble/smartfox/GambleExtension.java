package com.athena.gamble.smartfox;

import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.athena.gamble.task.TaskManager;
import com.smartfoxserver.v2.SmartFoxServer;
import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class GambleExtension extends SFSExtension {
	ScheduledFuture<?> taskScheduler;
	TaskManager taskManager;

	public void init() {
		taskManager = TaskManager.getInstance();
		SmartFoxServer sfs = SmartFoxServer.getInstance();
		sfs.getEventManager().setThreadPoolSize(20);
		taskScheduler = sfs.getTaskScheduler().scheduleAtFixedRate(taskManager, 0, 1, TimeUnit.SECONDS);
		
		for (Map.Entry<String, Class<? extends RequestHandler>> entry : ServiceDefinition.services.entrySet()) {
			addRequestHandler(entry.getKey(), entry.getValue());
		}
		
		for (Map.Entry<SFSEventType, Class<? extends EventHandler>> entry : ServiceDefinition.events.entrySet()) {
			addEventHandler(entry.getKey(), entry.getValue());
		}
	}
	
	public void destroy() {
		taskManager.release();
	}
	
	public TaskManager getTaskManager() {
		return taskManager;
	}
}