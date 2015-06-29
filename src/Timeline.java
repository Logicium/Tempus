import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

public class Timeline {
	public static Random rand = new Random();
	public Date rightNow = new Date();
	public int ProductivityPoints = 0;
	public static Calendar calendar = Calendar.getInstance();
	public static Day[] timeline = new Day[365];

	public Timeline() {
		// Timeline is populated with empty Days by default, for 365 days.
		for (int i = 0; i < 365; i++) {
			timeline[i] = new Day();
		}
	}

	public static void createEventInstances(Event e) {
		int daysLeftThisYear = 365-calendar.DAY_OF_YEAR;
		int numberOfRanges = daysLeftThisYear / e.frequency;
		System.out.println("For the " + e.name+ " assignment to be done done within a " + e.frequency+ " day frequency,");
		System.out.println("I will create " + numberOfRanges+ " ranges between now and the end of the year.");
		System.out.println("And randomly select a day between each range for the assignment due-date.\n");
		int timelineIndex = calendar.DAY_OF_YEAR;
		int rangeCount = timelineIndex;
		int lastIndex = timelineIndex;

		for (int z = 0; z < numberOfRanges; z++) {
			lastIndex = timelineIndex;
			timelineIndex = generateInstanceDeadline(e.frequency, rangeCount);
			Instance i = new Instance(e.name, timelineIndex, lastIndex,
					e.frequency);
			System.out.println("Placing an Instance of " + e.name + " at day "+ timelineIndex);
			timeline[timelineIndex].instances.add(i);
			generateReminders(i);
			rangeCount += e.frequency;
		}
	}

	public static int generateInstanceDeadline(int range, int offset) {
		int deadline = rand.nextInt(range) + offset;
		return deadline;
	}

	public static void generateReminders(Instance i) {

		int dynamicReminderSize = (int) (Math.round(i.reminderRange / 2.0));
		System.out.println("Generating " + dynamicReminderSize+ " reminders for this Instance...");
		System.out.println("The range in which these reminders can be placed is of size "+i.reminderRange);
		double dynamicCounter = 1.0;
		int lastIndex = 0;
		int reminderIndex = 0;
		for (int x = 0; x < dynamicReminderSize; x++) {
			lastIndex = reminderIndex;
			reminderIndex = (int) ((i.parentFrequency - (i.parentFrequency * dynamicCounter))+i.previousInstanceIndex);
			if (lastIndex == reminderIndex) {
				System.out.println("Whoops. The last reminder for the same Instance was on the same day.");
				System.out.println("Let's go to the next case.");
			} else {
				System.out.println("Reminder " + (x + 1) + " will be on day "+ reminderIndex);
				Reminder r = new Reminder(i, (x + 1), reminderIndex);
				timeline[reminderIndex].reminders.add(r);
			}
			dynamicCounter /= 2;
		}
		System.out.println("Reminder generation complete!");
	}

	public static int getDayIndex(Date d) {
		int index = 0;
		// Given a date, return its index given a year.
		return index;
	}

	public static void playToday() {
		// check if Timeline is empty. If it is, then run CommandLine, else:
		// Just grab the current time,
		// Convert it to a dayOfYear
		// And then throw that index into the timeline
		// Press Play.
	}

	public static Date convertDayofYearToDate(int dayOfYear) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		Date date = calendar.getTime();
		// System.out.println("Day of year " + dayOfYear + " = " + date);
		return date;
	}

}
