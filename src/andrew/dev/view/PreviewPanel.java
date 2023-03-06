package andrew.dev.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import andrew.dev.model.Task;

public class PreviewPanel extends JPanel {
	
	private PreviewItemPanel previewItemPanel;

	public PreviewPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setMinimumSize(new Dimension(320, 240));
		setPreferredSize(new Dimension(400, 520));
		setBorder(BorderFactory.createEtchedBorder());
		
		previewItemPanel = new PreviewItemPanel();
		
		JScrollPane scrollPane = new JScrollPane(previewItemPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		add(scrollPane);
	}
	
	public void refresh(Task task) {
		previewItemPanel.refresh(task);
	}
	
	public PreviewItemPanel getPreviewItemPanel() {
		return previewItemPanel;
	}
}
