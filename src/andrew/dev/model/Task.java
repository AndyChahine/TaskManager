package andrew.dev.model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task implements Comparable<Task> {

	public String name;
	public boolean isUrgent;
	public boolean isImportant;
	public boolean hasDeadline;
	public LocalDateTime deadline;
	public int timeToComplete;
	public String ampm = "AM";
	public int priority = 0;
	
	public ArrayList<SubTask> subTasks = new ArrayList<SubTask>();
	
	public Task(String name) {
		this(name, false, false, false, null, "AM", 0);
	}
	
	public Task(String name, boolean isUrgent, boolean isImportant, boolean hasDeadline, LocalDateTime deadline, String ampm, int timeToComplete) {
		this.name = name;
		this.isUrgent = isUrgent;
		this.isImportant = isImportant;
		this.hasDeadline = hasDeadline;
		this.deadline = deadline;
		this.ampm = ampm;
		this.timeToComplete = timeToComplete;
		
		if(isUrgent && isImportant) {
        	priority = 4;
        }else if(isImportant) {
        	priority = 3;
        }else if(isUrgent) {
        	priority = 2;
        }else {
        	priority = 1;
        }
	}
	
	public String getDeadlineAsString() {
		int hour = deadline.getHour();
		
		int formatHour = hour;
		formatHour %= 12;
		
		if("PM".equals(ampm)) {
			formatHour = 12;
		}
		
		String res = deadline.getMonthValue() + "/" + deadline.getDayOfMonth() + "/" + deadline.getYear() + "  " + formatHour + ":" + (deadline.getMinute() < 10 ? "0" + deadline.getMinute() : deadline.getMinute()) + " " + ampm;
		return res;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " Urgent: " + isUrgent + " Important: " + isImportant + " Deadline: " + getDeadlineAsString();
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Task t) {
		return t.priority - priority;
	}
}
