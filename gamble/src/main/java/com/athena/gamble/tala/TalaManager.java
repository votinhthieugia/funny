package com.athena.gamble.tala;

import com.athena.gamble.eventdispatcher.GameEventManager;
import com.athena.gamble.eventdispatcher.TalaEventHandler;
import com.athena.gamble.task.BaseScheduledTask;
import com.athena.gamble.task.TaskManager;

public class TalaManager extends BaseScheduledTask {
	TalaEventHandler eventHandler;
	
	public TalaManager() {
		register(TaskManager.getInstance());
		eventHandler = new TalaEventHandler();
		GameEventManager.getInstance().registerEventHandler(eventHandler);
	}

	@Override
	public void update() {
	}

	@Override
	public void release() {
	}
}
