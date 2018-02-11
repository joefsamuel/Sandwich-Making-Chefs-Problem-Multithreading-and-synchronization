import java.util.List;

/**
 * Agent class to represent an agent that randomly chooses two ingredients to be on the table.
 * @author joefs
 *
 */

public class Agent extends Thread{

	private List<String> table;
	private String name;

	private String ingredient1;
	private String ingredient2;
	private String ingredient3;

	private final int minimum = 1;
	private final int maximum = 3;

	/**
	 * Constructor
	 * @param name	Name of the thread
	 * @param table	the table on to which ingredients will be put/taken to make sandwich
	 * @param ingredient1	one of the item necessary to form a complete sandwich
	 * @param ingredient2	one of the item necessary to form a complete sandwich
	 * @param ingredient3	one of the item necessary to form a complete sandwich
	 */
	public Agent(String name, List<String> table, String ingredient1, String ingredient2, String ingredient3) {
		super(name);
		this.name = name;
		this.table = table;
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.ingredient3 = ingredient3;

	}

	/* 
	 * Run method override for threads
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while(true) {
			selectIngredient();
		}

	}

	/**
	 * Randomly selects 2 ingredients to put on the table.
	 * @param none
	 * @return none
	 */
	public void selectIngredient() {
		synchronized(this) {
			while(table.size() != 0) {
				try {
					System.out.println("Agent has to wait for table to be empty.");
					wait();
				}catch(InterruptedException e) {
					System.err.println("Error in agent thread: ");
					e.printStackTrace();
					return;
				}
			}
			int caseChosen = randomSelection(minimum, maximum);
			switch(caseChosen) {
			case 1: table.add(ingredient1);
			table.add(ingredient2);
			break;

			case 2:table.add(ingredient3);
			table.add(ingredient1);
			break;

			case 3: table.add(ingredient2);
			table.add(ingredient3);
			break;

			default: System.err.println("Failed"); 
			break;
			}
			System.out.println(name + " has choosen 2 random ingredients: " + table.get(0) + " and " + table.get(1));
			notifyAll();
		}
	}	

	/**
	 *Randomly chooses a number between a range.
	 * @param min	Minimum of the range
	 * @param max 	Maximum of the range
	 * @return int	random number within this range.
	 */
	public int randomSelection(int min, int max) {
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
}
