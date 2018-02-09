import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Kitchen {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		List<String> table = Collections.synchronizedList(new ArrayList<String>());
		
		Thread chef1 = new Chef("Chef 1", table, "bread");
		Thread chef2 = new Chef("Chef 2", table, "peanut butter");
		Thread chef3 = new Chef("Chef 3", table, "jam");
		
		Thread agent = new Agent("Agent", table, "bread", "jam", "peanut butter");
		System.out.println("Entering the kitchen...");
		agent.start();
		chef1.start();
		chef2.start();
		chef3.start();
		
	}
	
}
