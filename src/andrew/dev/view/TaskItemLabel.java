package andrew.dev.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import andrew.dev.model.Task;

public class TaskItemLabel extends JLabel {
	
	public static final Border DEFAULT_BORDER = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, false), BorderFactory.createEmptyBorder(10, 20, 10, 20));
	public static final Border SELECTED_BORDER = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GREEN.brighter(), 1, false), BorderFactory.createEmptyBorder(10, 20, 10, 20));
	
	private Task task;
	
	private boolean isActive;

	public TaskItemLabel(Task task) {
		this.task = task;
		setOpaque(true);
		setBackground(Color.WHITE);
		
		switch(task.priority) {
		case 4: setForeground(Color.RED);
			break;
		case 3: setForeground(Color.YELLOW.darker());
			break;
		case 2: setForeground(Color.GREEN);
			break;
		case 1: setForeground(Color.BLACK);
			break;
		default: setForeground(Color.BLACK);
			break;
		}
		
		String due = "";
		if(task.hasDeadline) {
			due = "Due: " + task.getDeadlineAsString();
		}
		
		setBorder(DEFAULT_BORDER);
		setText("<html> <span style='font-family:Inter; font-size:24pt;'>" + task.name + "</span> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <span style='font-size:16pt;'>" + " " + due + "</span> </html>");
		
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(new Color(40, 150, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setBackground(new Color(125, 192, 255));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(125, 192, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!isActive) {
					setBackground(Color.WHITE);
				}
			}
			
		});
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
}
