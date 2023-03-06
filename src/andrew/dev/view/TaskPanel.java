package andrew.dev.view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import andrew.dev.listeners.TaskItemPanelListener;
import andrew.dev.model.TaskListManager;

public class TaskPanel extends JPanel {

	private TaskItemPanel taskItemPanel;
	
	private TaskItemPanelListener listener;
	
	public TaskPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMinimumSize(new Dimension(320, 240));
		setPreferredSize(new Dimension(400, 520));
		setBorder(BorderFactory.createEtchedBorder());
		
		JPopupMenu popup = new JPopupMenu();
		
		JMenuItem createMenu = new JMenuItem("Create Task");
		createMenu.addActionListener((e) -> {
			listener.onTaskCreated();
		});
		popup.add(createMenu);
		
		taskItemPanel = new TaskItemPanel();
		taskItemPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					popup.show(taskItemPanel, e.getX(), e.getY());
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(taskItemPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		add(scrollPane);
	}
	
	public void refresh(TaskListManager taskList) {
		taskItemPanel.refresh(taskList);
	}
	
	public TaskItemPanel getTaskItemPanel() {
		return taskItemPanel;
	}
	
	public void setListener(TaskItemPanelListener listener) {
		this.listener = listener;
	}
}
