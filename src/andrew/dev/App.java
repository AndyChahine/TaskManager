package andrew.dev;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

import andrew.dev.controller.AppController;
import andrew.dev.model.TaskListManager;
import andrew.dev.view.AppView;

public class App {

	public App() {
		FlatDarkLaf.setup();
		
		SwingUtilities.invokeLater(() -> {
			TaskListManager taskList = new TaskListManager();
			AppView view = new AppView();
			AppController controller = new AppController(view, taskList);
			view.show();
		});
	}
	
	public static void main(String[] args) {
		App app = new App();
	}
}
