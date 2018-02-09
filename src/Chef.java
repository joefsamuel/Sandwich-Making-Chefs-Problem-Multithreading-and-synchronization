import java.util.ArrayList;
import java.util.List;

public class Chef extends Thread {

	private List<String> table;
	
	private String ingredient;
	private String name;
	
	
	public Chef(String name, List<String> table, String ingredient) {
		super(name);
		this.name = name;
		this.table = table;
		this.ingredient = ingredient;
	}
	
	public void run() {
		while(Kitchen.count < 20) {
			makeSandwich();
		}
	}
	
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
