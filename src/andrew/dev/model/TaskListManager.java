package andrew.dev.model;

import java.util.ArrayList;

public class TaskListManager {

	private ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public void removeTask(Task task) {
		tasks.remove(task);
	}
	
	public Task getTask(int index) {
		return tasks.get(index);
	}
	
	public int size() {
		return tasks.size();
	}
	
	public ArrayList<Task> getTasks(){
		return tasks;
	}
	
	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
}
