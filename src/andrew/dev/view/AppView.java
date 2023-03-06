package andrew.dev.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

public class AppView {

	private JFrame frame;
	private HeaderPanel headerPanel;
	private TaskPanel taskPanel;
	private PreviewPanel previewPanel;
	private TaskCreationDialog dialog;
	
	public AppView() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(960, 540));
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setTitle("Task Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		headerPanel = new HeaderPanel();
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		
		NavBarPanel navBarPanel = new NavBarPanel();
		frame.getContentPane().add(navBarPanel, BorderLayout.WEST);
		
		taskPanel = new TaskPanel();
		frame.getContentPane().add(taskPanel, BorderLayout.CENTER);
		
		previewPanel = new PreviewPanel();
		frame.getContentPane().add(previewPanel, BorderLayout.EAST);
		
		FooterPanel footerPanel = new FooterPanel();
		frame.getContentPane().add(footerPanel, BorderLayout.SOUTH);
		
		dialog = new TaskCreationDialog(frame);
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void showTaskDialog() {
		dialog.setVisible(true);
	}
	
	public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}
	
	public TaskPanel getTaskPanel() {
		return taskPanel;
	}
	
	public PreviewPanel getPreviewPanel() {
		return previewPanel;
	}
	
	public TaskCreationDialog getTaskCreationDialog() {
		return dialog;
	}
}
