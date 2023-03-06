package andrew.dev.model;

public class SubTask {

	private String description;
	private boolean isCompleted;
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isCompleted() {
		return isCompleted;
	}
}
