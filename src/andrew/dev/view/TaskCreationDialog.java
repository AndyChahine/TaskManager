package andrew.dev.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import andrew.dev.listeners.TaskDialogListener;
import andrew.dev.model.SubTask;
import andrew.dev.model.Task;

public class TaskCreationDialog extends JDialog{
	private static final long serialVersionUID = -681828029661779159L;
	
	public JCheckBox urgentCheckBox;
	public JCheckBox importantCheckBox;
	public JSpinner timeToFinishSpinner;
	public JCheckBox deadlineCheckBox;
	public JComboBox<String> monthComboBox;
	public JComboBox<String> dayComboBox;
	public JComboBox<String> yearComboBox;
	public JComboBox<String> hourComboBox;
	public JComboBox<String> minComboBox;
	public JComboBox<String> ampmComboBox;
	public JButton okButton;
	public JButton cancelButton;
	public JTextField txtTask;
	
	private final JPanel contentPanel = new JPanel();
	
	private TaskDialogListener listener;
	
	public TaskCreationDialog(JFrame parentComponent) {
		super(parentComponent, "Create a New Task", true);
		setResizable(false);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(parentComponent);
		
		urgentCheckBox = new JCheckBox("Urgent");
		urgentCheckBox.setFont(new Font("Inter", Font.PLAIN, 14));
		urgentCheckBox.setBounds(23, 54, 93, 21);
		contentPanel.add(urgentCheckBox);
		
		importantCheckBox = new JCheckBox("Important");
		importantCheckBox.setFont(new Font("Inter", Font.PLAIN, 14));
		importantCheckBox.setBounds(118, 54, 93, 21);
		contentPanel.add(importantCheckBox);
		
		JLabel lblNewLabel = new JLabel("Est. time to complete task in minutes");
		lblNewLabel.setFont(new Font("Inter", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 85, 256, 18);
		contentPanel.add(lblNewLabel);
		
		timeToFinishSpinner = new JSpinner();
		timeToFinishSpinner.setBounds(23, 113, 93, 20);
		contentPanel.add(timeToFinishSpinner);
		
		deadlineCheckBox = new JCheckBox("Deadline");
		deadlineCheckBox.setFont(new Font("Inter", Font.PLAIN, 14));
		deadlineCheckBox.setBounds(23, 143, 93, 21);
		contentPanel.add(deadlineCheckBox);
		
		monthComboBox = new JComboBox<String>();
		monthComboBox.setEnabled(false);
		monthComboBox.setFont(new Font("Inter", Font.PLAIN, 14));
		monthComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthComboBox.setBounds(23, 174, 93, 21);
		contentPanel.add(monthComboBox);
		
		dayComboBox = new JComboBox<String>();
		dayComboBox.setEnabled(false);
		dayComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox.setFont(new Font("Inter", Font.PLAIN, 14));
		dayComboBox.setBounds(118, 174, 53, 21);
		contentPanel.add(dayComboBox);
		
		yearComboBox = new JComboBox<String>();
		yearComboBox.setEnabled(false);
		yearComboBox.setFont(new Font("Inter", Font.PLAIN, 14));
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099"}));
		yearComboBox.setBounds(173, 174, 72, 21);
		contentPanel.add(yearComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Task Name:");
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 31, 82, 13);
		contentPanel.add(lblNewLabel_1);
		
		txtTask = new JTextField();
		txtTask.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTask.setText("Task");
		txtTask.setFont(new Font("Inter", Font.PLAIN, 14));
		txtTask.setBounds(107, 28, 119, 19);
		contentPanel.add(txtTask);
		txtTask.setColumns(10);
		
		hourComboBox = new JComboBox();
		hourComboBox.setEnabled(false);
		hourComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		hourComboBox.setFont(new Font("Inter", Font.PLAIN, 14));
		hourComboBox.setBounds(261, 174, 55, 21);
		contentPanel.add(hourComboBox);
		
		minComboBox = new JComboBox();
		minComboBox.setEnabled(false);
		minComboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		minComboBox.setFont(new Font("Inter", Font.PLAIN, 14));
		minComboBox.setBounds(318, 174, 55, 21);
		contentPanel.add(minComboBox);
		
		ampmComboBox = new JComboBox();
		ampmComboBox.setEnabled(false);
		ampmComboBox.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		ampmComboBox.setFont(new Font("Inter", Font.PLAIN, 14));
		ampmComboBox.setBounds(375, 174, 58, 21);
		contentPanel.add(ampmComboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Sub Tasks");
		lblNewLabel_2.setFont(new Font("Inter", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(23, 240, 82, 13);
		contentPanel.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Inter", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(23, 263, 580, 139);
		
		contentPanel.add(scrollPane);
		
		deadlineCheckBox.addActionListener((event) -> {
			
			if(deadlineCheckBox.isSelected()) {
				monthComboBox.setEnabled(true);
				dayComboBox.setEnabled(true);
				yearComboBox.setEnabled(true);
				hourComboBox.setEnabled(true);
				minComboBox.setEnabled(true);
				ampmComboBox.setEnabled(true);
			}else {
				monthComboBox.setEnabled(false);
				dayComboBox.setEnabled(false);
				yearComboBox.setEnabled(false);
				hourComboBox.setEnabled(false);
				minComboBox.setEnabled(false);
				ampmComboBox.setEnabled(false);
			}
		});
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener((e) -> {
					LocalDateTime deadline = LocalDateTime.of(Integer.valueOf((String)yearComboBox.getSelectedItem()), monthComboBox.getSelectedIndex() + 1, Integer.valueOf((String)dayComboBox.getSelectedItem()), Integer.valueOf((String)hourComboBox.getSelectedItem()), minComboBox.getSelectedIndex());
					Task task = new Task(txtTask.getText(), urgentCheckBox.isSelected(), importantCheckBox.isSelected(), deadlineCheckBox.isSelected(), deadline, (String)ampmComboBox.getSelectedItem(), (int)timeToFinishSpinner.getValue());
					
					String[] tokens = textArea.getText().split("\n");
					ArrayList<SubTask> subTasks = new ArrayList<SubTask>();
					for(int i = 0; i < tokens.length; i++) {
						if("".equals(tokens[i])) {
							continue;
						}
						System.out.println(i + " " + tokens[i]);
						SubTask st = new SubTask();
						st.setDescription(tokens[i]);
						subTasks.add(st);
					}
					
					task.subTasks = subTasks;
					
					listener.onTaskConfirmed(task);
					dispose();
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener((e) -> {
					dispose();
				});
			}
		}
	}
	
	public void setListener(TaskDialogListener listener) {
		this.listener = listener;
	}
}
