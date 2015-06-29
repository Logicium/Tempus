import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


public class Day {

	public Scanner input = new Scanner(System.in);
	public Vector<Instance> instances = new Vector<Instance>();
	public Vector<Reminder> reminders = new Vector<Reminder>();

	public void play() {
		greetings();
		readReminders();
		readInstances();
		readPoints();
	}

	private void greetings() {
		System.out.println("Greetings, human. Today is "+new Date()+".");
	}
	
	private void greetings(int fauxDate) {
		System.out.println("Greetings, human. Today is "+fauxDate+".");
	}

	private void readReminders() {
		
		System.out.println("You have "+reminders.size()+ " reminders on upcoming assignments.");
		if (!(reminders.size() == 0)) {
			for (int i = 0; i < reminders.size(); i++) {
				Reminder r = reminders.get(i);
				System.out.println("This is the "+r.sequence+" time I've reminded you about "+r.parentInstance.name+".");
				System.out.println("You know that's due "+r.daysLeft+" days from now, right?");
				System.out.println("If you complete it now, I can give you "+r.points+" bonus Productivity Points for your work.");
				System.out.println("Will you complete the "+r.parentInstance.name+" assignment now? yes/no");
				String complete = input.nextLine();
				if(complete.contains("yes")){
					System.out.println("Hell yeah! Way to be proactive!");
					//Mark this instance complete. 
					//Award points specified points
				}
				else{
					System.out.println("That's okay. I'll see you next time on this one.");
				}
			}
			
		}
		
	}

	public void readInstances() {
		//check the number of Instances NOT completed on this Day.
		System.out.println("You have "+instances.size()+ " assignments due today.");
		if (!(instances.size() == 0)) {
			for (int i = 0; i < instances.size(); i++) {
				System.out.println("Assignment "+(i+1)+" is: "+instances.get(i).name+".");
				System.out.println("Did you complete this assignment on time? yes/no");
				String outcome = input.nextLine();
				if(outcome.contains("yes")){
					System.out.println("Thank you! Glad to see that I can help out!");
					instances.get(i).complete = true;
				}
				else{
					System.out.println("Seriously? You still didn't do it after all my reminders?");
					System.out.println("Type 'no' again to confirm you didn't do this assignment.");
					String confirm = input.nextLine();
					if(confirm.contains("no")){
						System.out.println("Well god damn. You should work on that right now.");
						instances.get(i).overdue = true;
						//Deduct points for being LATE
						//add instance to tomorrow.
					}
					else{
						System.out.println("Phew! For a second, I thought you lost sight of your dreams.");
						instances.get(i).complete = true;
					}
				}
			}
			
		}
	}

	private void readPoints() {
		//"You have <thisMany> points right now. A perfect score is <this>."
		//"Increase your score by completing assignments early!"
		//"If you complete your next <x> assignments early..."
		//"You can earn back missed points by achieving a Perfection streak!"	
	}
	
	public static String preface(){
		Random rand = new Random();
		String preface ="";
		String[] prefaces = {"I know you've finished ", "I bet you've completed ",
				"So how did it go for "};
		preface = prefaces[rand.nextInt(prefaces.length)];
		return preface;
	}
}
