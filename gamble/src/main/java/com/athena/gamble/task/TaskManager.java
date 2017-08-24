package com.athena.gamble.task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Runnable {
	private static TaskManager instance;
	List<BaseScheduledTask> tasks;
	
	public static TaskManager getInstance() {
		if (instance == null) {
			instance = new TaskManager();
		}
		
		return instance;
	}
	
	private TaskManager() {
		tasks = new ArrayList<BaseScheduledTask>();
	}
	
	public void addTask(BaseScheduledTask task) {
		tasks.add(task);
	}
	
	public void release() {
		for (BaseScheduledTask task : tasks) {
			task.release();
		}
	}
	
	public void run() {
		for (BaseScheduledTask task : tasks) {
			task.update();
		}
	}
}