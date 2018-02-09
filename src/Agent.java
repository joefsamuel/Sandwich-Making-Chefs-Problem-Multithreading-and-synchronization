import java.util.ArrayList;
import java.util.List;

public class Agent extends Thread{

	private List<String> table;
	private String name;
	
	private String ingredient1;
	private String ingredient2;
	private String ingredient3;
	
	private final int minimum = 1;
	private final int maximum = 3;
	
	
	public Agent(String name, List<String> table, String ingredient1, String ingredient2, String ingredient3) {
		super(name);
		this.name = name;
		this.table = table;
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.ingredient3 = ingredient3;
		
	}
	
	public void run() {
			while(true) {
				selectIngredient();
			}
			
	}
	
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
	
	public int randomSelection(int min, int max) {
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
}
