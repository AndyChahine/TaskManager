package andrew.dev.view;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import andrew.dev.listeners.TaskItemPanelListener;
import andrew.dev.model.Task;
import andrew.dev.model.TaskListManager;

public class TaskItemPanel extends JPanel {
	
	private JPopupMenu popup;
	private Task currentTask;
	private TaskItemLabel currentTaskItem;
	private ArrayList<TaskItemLabel> taskItemLabels = new ArrayList<TaskItemLabel>();
	
	private TaskItemPanelListener listener;

	public TaskItemPanel() {
		setLayout(new GridLayout(100, 1));
		
		JMenuItem editMenu = new JMenuItem("Edit");
		editMenu.addActionListener((e) -> {
			listener.onTaskEdited(currentTask);
		});
		
		JMenuItem removeMenu = new JMenuItem("Remove");
		removeMenu.addActionListener((e) -> {
			listener.onTaskRemoved(currentTask);
		});
		
		popup = new JPopupMenu("Popup Title");
		popup.add(editMenu);
		popup.addSeparator();
		popup.add(removeMenu);
	}
	
	private void addTaskItemLabel(TaskItemLabel t) {
		t.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				currentTask = t.getTask();
				currentTaskItem = t;
				refreshBorder();
				listener.onTaskClicked(currentTask);
				
				if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
					listener.onTaskEdited(currentTask);
				}else if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(t, e.getX(), e.getY());
				}
			}
		});
		taskItemLabels.add(t);
	}
	
	public void refresh(TaskListManager taskList) {
		taskItemLabels.clear();
		removeAll();
		
		Collections.sort(taskList.getTasks());
		
		for(int i = 0; i < taskList.size(); i++) {
			TaskItemLabel item = new TaskItemLabel(taskList.getTask(i));
			addTaskItemLabel(item);
			add(taskItemLabels.get(i));
		}
		
		if(taskList.size() > 0) {
			currentTaskItem = taskItemLabels.get(taskItemLabels.size() - 1);
			currentTask = taskList.getTask(taskList.size() - 1);
		}
		
		currentTaskItem.setBorder(TaskItemLabel.SELECTED_BORDER);
		
		updateUI();
	}
	
	private void refreshBorder() {
		for(TaskItemLabel l : taskItemLabels) {
			l.setBorder(TaskItemLabel.DEFAULT_BORDER);
		}
		currentTaskItem.setBorder(TaskItemLabel.SELECTED_BORDER);
	}
	
	public void setListener(TaskItemPanelListener listener) {
		this.listener = listener;
	}
}