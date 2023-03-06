package andrew.dev.controller;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import andrew.dev.listeners.HeaderPanelListener;
import andrew.dev.listeners.TaskItemPanelListener;
import andrew.dev.model.Task;
import andrew.dev.model.TaskListManager;
import andrew.dev.view.AppView;

public class AppController implements TaskItemPanelListener, HeaderPanelListener {

	private AppView view;
	private TaskListManager taskList;
	
	private TaskDialogController taskDialogController;
	
	public AppController(AppView view, TaskListManager taskList) {
		this.view = view;
		this.taskList = taskList;
		
		taskDialogController = new TaskDialogController(view, taskList);
		
		setupCallbacks();
	}
	
	public void setupCallbacks() {
		view.getHeaderPanel().setListener(this);
		view.getTaskPanel().setListener(this);
		view.getTaskPanel().getTaskItemPanel().setListener(this);
		view.getTaskCreationDialog().setListener(taskDialogController);
	}

	@Override
	public void onTaskClicked(Task task) {
		view.getPreviewPanel().refresh(task);
	}

	@Override
	public void onTaskCreated() {
		view.showTaskDialog();
	}

	@Override
	public void onTaskRemoved(Task task) {
		taskList.removeTask(task);
		view.getTaskPanel().refresh(taskList);
		if(taskList.size() > 0) {
			view.getPreviewPanel().refresh(taskList.getTask(taskList.getTasks().size() - 1));
		}else {
			view.getPreviewPanel().getPreviewItemPanel().removeAll();
			view.getPreviewPanel().getPreviewItemPanel().updateUI();
		}
	}

	@Override
	public void onTaskEdited(Task task) {
		System.out.println("task edited " + task + " " + task.hashCode());
	}

	@Override
	public void onAddTaskButtonPressed() {
		view.showTaskDialog();
	}
	
	@Override
	public void onSearchButtonPressed(String text) {
		ArrayList<Task> filteredList = (ArrayList<Task>) taskList.getTasks().stream().filter(getFilter(Task::getName, text)).collect(Collectors.toList());
		TaskListManager filteredTasks = new TaskListManager();
		filteredTasks.setTasks(filteredList);
		view.getTaskPanel().refresh(filteredTasks);
	}
	
	static final Pattern SPACE = Pattern.compile("\\s+");
	
	private static <T> Predicate<T> getFilter(Function<? super T, String> f, String words) {
		String regex = SPACE.splitAsStream(words).map(Pattern::quote).collect(Collectors.joining("|"));
		Predicate<String> sp = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).asPredicate();
		
		return t -> sp.test(f.apply(t));
	}
}
