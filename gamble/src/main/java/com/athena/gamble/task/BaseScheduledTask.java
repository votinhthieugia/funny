package com.athena.gamble.task;

import com.smartfoxserver.v2.extensions.SFSExtension;

public abstract class BaseScheduledTask {
	SFSExtension extension;
	
	public void register(TaskManager taskManager) {
		taskManager.addTask(this);
	}
	
	public void setExtension(SFSExtension extension) {
		this.extension = extension;
	}
	
	public abstract void update();
	public abstract void release();
}