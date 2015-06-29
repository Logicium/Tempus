import java.util.Vector;


public class Event {

	
	public String name; 
	public String category;
	public int frequency; //1 = daily, 7=weekly, 30 = monthly, ect
	//Depending on the frequency of event, calculate indexes:
	
	public Vector<Instance> instances = new Vector<Instance>();
	
	public Event(String name, String category, int frequency) {
		this.name = name;
		this.category = category;
		this.frequency = frequency;
	}

}
