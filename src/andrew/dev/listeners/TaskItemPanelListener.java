package andrew.dev.listeners;

import andrew.dev.model.Task;

public interface TaskItemPanelListener {

	public void onTaskClicked(Task task);
	public void onTaskCreated();
	public void onTaskRemoved(Task task);
	public void onTaskEdited(Task task);
}
