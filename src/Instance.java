import java.util.Vector;


public class Instance {
	
	public String name;
	public String category;
	public int index;
	public int parentFrequency;
	public int previousInstanceIndex;
	public int reminderRange;
	
	//Reminders use the following variables to generate compelling calls to action:
	public boolean complete=false;
	public boolean overdue=false;
	
	//Date utility required to process these variables:
	public int dayOfWeek;
	public int month;
	public int weekOfMonth;
	
	public Instance(String name, int timelineIndex, int lastIndex, int frequency) {
		this.name = name;
		this.index = timelineIndex;
		this.previousInstanceIndex = lastIndex;
		this.parentFrequency = frequency;
		this.reminderRange = index - lastIndex;
	}
}
