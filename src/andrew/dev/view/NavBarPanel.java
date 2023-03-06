package andrew.dev.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class NavBarPanel extends JPanel {

	public NavBarPanel() {
		setPreferredSize(new Dimension(160, 520));
		setMinimumSize(new Dimension(50, 10));
		setBorder(BorderFactory.createEtchedBorder());
	}
}
