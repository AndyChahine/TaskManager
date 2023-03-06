package andrew.dev.controller;

import andrew.dev.listeners.TaskDialogListener;
import andrew.dev.model.Task;
import andrew.dev.model.TaskListManager;
import andrew.dev.view.AppView;

public class TaskDialogController implements TaskDialogListener{
	
	private AppView view;
	private TaskListManager taskList;

	public TaskDialogController(AppView view, TaskListManager taskList) {
		this.view = view;
		this.taskList = taskList;
	}
	
	@Override
	public void onTaskConfirmed(Task task) {
		taskList.addTask(task);
		view.getTaskPanel().refresh(taskList);
		view.getPreviewPanel().refresh(task);
	}
}
