package andrew.dev.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import andrew.dev.model.SubTask;
import andrew.dev.model.Task;

public class PreviewItemPanel extends JPanel {

	public PreviewItemPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
	}
	
	private void addSubTask(SubTask subTask, int index, int size) {
		String html = "<html><p style='font-family:Inter; font-size:16pt;'>";
		String strikeSubTask = "<s>" + subTask.getDescription() + "</s>";
		String end = "</p></html>";
		
		JCheckBox chckbxNewCheckBox = new JCheckBox();
		if(subTask.isCompleted()) {
			chckbxNewCheckBox.setSelected(true);
			chckbxNewCheckBox.setText(html + strikeSubTask + end);
		}else {
			chckbxNewCheckBox.setSelected(false);
			chckbxNewCheckBox.setText(html + subTask.getDescription() + end);
		}
		chckbxNewCheckBox.addActionListener((e) ->{
			if(chckbxNewCheckBox.isSelected()) {
				chckbxNewCheckBox.setText(html + strikeSubTask + end);
				subTask.setCompleted(true);
			}else {
				chckbxNewCheckBox.setText(html + subTask.getDescription() + end);
				subTask.setCompleted(false);
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = index + 1;
		if(index >= size - 1) {
			gbc_chckbxNewCheckBox.weightx = 1.0;
			gbc_chckbxNewCheckBox.gridwidth = GridBagConstraints.REMAINDER;
			gbc_chckbxNewCheckBox.weighty = 1.0;
		}
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
	}
	
	public void refresh(Task task) {
		removeAll();
		
		for(int i = 0; i < task.subTasks.size(); i++) {
			addSubTask(task.subTasks.get(i), i, task.subTasks.size());
		}
		
		updateUI();
	}
}
