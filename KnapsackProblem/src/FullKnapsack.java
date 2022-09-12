import java.util.ArrayList;
import java.util.Scanner;

public class FullKnapsack {
	
	static double knapWeight;
	static double knapSize;
	static int numItems;
	static ArrayList<Double> weights = new ArrayList<>();
	static ArrayList<Double> sizes = new ArrayList<>();
	static ArrayList<Double> values = new ArrayList<>();

	Item item; //arr []?

	public static void main (String [] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter the knapsack weight and size capacity (separate by space): ");
		knapWeight = scnr.nextDouble();
		knapSize = scnr.nextDouble();
		
		System.out.println("How many items? ");
		numItems = scnr.nextInt();
		
		System.out.println("Enter weights (separate by spaces): ");
		for (int i = 0; i < numItems; i++) {
			weights.add(scnr.nextDouble());
		}
		System.out.println("Enter sizes (separate by spaces): ");
		for (int i = 0; i < numItems; i++) {
			sizes.add(scnr.nextDouble());
		}
		System.out.println("Enter values (separate by spaces): ");
		for (int i = 0; i < numItems; i++) {
			values.add(scnr.nextDouble());
		}

		
		createItems();
		
		
		scnr.close();
		
	}//end main
	
	public void createItems() {
		
		for (int i = 0; i < numItems; i++) {
			
			
			
		}
		
		
	}
	
}//end FullKnapsack
