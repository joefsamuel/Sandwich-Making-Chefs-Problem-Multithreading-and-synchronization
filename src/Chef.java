import java.util.List;

/**
 * Chef class represents chef with one final ingredient to make sandwich along with two ingredients on the table.
 * @author joefs
 *
 */
public class Chef extends Thread {

	private List<String> table;
	
	private String ingredient;
	private String name;
	
	
	/**
	 * Constructor
	 * @param name	Name of the thread
	 * @param table	the table on to which ingredients will be put/taken to make sandwich
	 * @param ingredient	the item necessary to form a complete sandwich
	 */
	public Chef(String name, List<String> table, String ingredient) {
		super(name);
		this.name = name;
		this.table = table;
		this.ingredient = ingredient;
	}
	
	/* 
	 * Run method override for threads
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		while(Kitchen.count < 20) {
			makeSandwich();
		}
	}
	
	/**
	 * Makes the sandwich with all ingredients on the table and eats it.
	 * @param none
	 * @return none
	 */
	public void makeSandwich() {
		synchronized(this) {
		for(String foodItem: table) {
			while(table.size() == 0 || foodItem.equals(ingredient)) {
				try {
					System.out.println("Chef has to wait for ingredients.");
					wait();
				} catch (InterruptedException e) {
					System.err.println("Error in Chef thread:");
					e.printStackTrace();
					return;
				}
			}
		}
		table.clear();	//Make and eat sandwich
		Kitchen.count++;
		System.out.println(name + " had made and ate a sandwich by adding " + ingredient + " to the table.");
		System.out.println("Total number of sandwiches made: " + Kitchen.count);
		notifyAll();
		}
	}

}
