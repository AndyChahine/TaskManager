package andrew.dev.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FooterPanel extends JPanel {

	public FooterPanel() {
		setPreferredSize(new Dimension(800, 35));
		setBorder(BorderFactory.createEtchedBorder());
	}
}
