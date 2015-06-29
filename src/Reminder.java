
public class Reminder {

	public Instance parentInstance;
	public int reminderNumber;
	public String reminder;
	public String sequence;
	public int daysLeft;
	public int index;
	public int points;
	
	public Reminder(Instance i, int reminderNumber, int index) {
		this.parentInstance = i;
		this.reminderNumber = reminderNumber;
		this.index  = index;
		setSequence();
		daysLeft = i.index-index;
	}

	public void setSequence(){
		switch(reminderNumber){
		case(1): sequence = "first"; points = 40;break;
		case(2): sequence = "second"; points = 30;break;
		case(3): sequence = "third"; points = 20;break;
		default: sequence = "almost last";points = 15;break;
		}
	}
	
	//The reminder object reads the Delta data to create the strings to be said
	//It can read in from an 'Ideas.txt' file to pick from the category and select the idea. 
	//It will write the idea to the Instance. You can also tell it 'new idea'.
	
}
