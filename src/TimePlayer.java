import java.util.Scanner;

public class TimePlayer {

	public static Scanner input = new Scanner(System.in);
	public static Timeline timeline = new Timeline();

	public static void main(String[] args) {
		timeline.playToday();
		CommandLine();
		demoPlay();
		
	}

	public static void CommandLine() {
		
		System.out.println("Entering command line mode.");
		System.out.println("Type 'add' to add a new Event\nType 'delete' to delete Events\nType 'complete' to update Instances.");
		System.out.println("Enter your command. Type 'q' to quit: ");
		String command = input.nextLine();
		char moreCommands = command.charAt(0);
		while(moreCommands != 'q'){
			switch(command){
			case("add"): addNewEvent(); break;
			case("delete"): deleteEvent();break;
			case("complete"): updateInstances();break;
			case("print"): printTimeline();break;
			}
			System.out.println("Enter your command:");
			command =input.nextLine();
			moreCommands = command.charAt(0);
		}
	}
	
	public static void demoPlay(){
		for(int i =0;i<14;i++){
			timeline.timeline[i].play();
		}
	}

	private static void printTimeline() {
		// Prints next n days of the timeline, starting from present. 
		
	}

	private static void updateInstances() {
		// TODO Auto-generated method stub
		//POINTS are awarded, if the completion is at 50% completion time. Points reduce to the default score on due-date. 
		//Points reduce to zero after the next 12.5% days after due date.
	}

	private static void deleteEvent() {
		// TODO Auto-generated method stub
		
	}

	public static void addNewEvent() {
		char addMore = ' ';
		while (addMore != 'n') {
			System.out.println("Give me the name of your event: ");
			String name = input.nextLine();
			System.out.println("Give me the category of your event: ");
			String category = input.nextLine();
			System.out.println("Give me the frequency in days of this event: ");
			
			int frequency = (int) input.nextDouble();
			
			System.out.println("Generating Event...");
			timeline.createEventInstances(new Event(name, category, frequency));
			System.out.println("Add another event? y/n");
			String skip = input.nextLine();
			String more = input.nextLine();
			addMore = more.charAt(0);
		}
	}
}
