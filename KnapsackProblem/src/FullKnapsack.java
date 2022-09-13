import java.util.ArrayList;
import java.util.Scanner;

public class FullKnapsack {
	
	static double knapWeight;
	static double knapSize;
	static int numItems;
	static double highestValue;
	static double []  weights;
	static double [] sizes;
	static double [] values;

	static ArrayList<Item> itemArray = new ArrayList<Item>(); //arr []?
	
	static ArrayList<ArrayList<Item>> subsets;
	
	static ArrayList<Item> optimalPack = new ArrayList<Item>();
	
	static Item items;

	//main method
	public static void main (String [] args) {
		
		//gets User Input for item variables
		getUserInput();
		
		//starts run time after user inputs data
		final long startTime = System.currentTimeMillis();
		
		//creates ArrayList of Item Objects based on user input 
		createItems();
		
		//algorithm that finds all subsets of Item Objects from the ArrayList
		findAllSubsets();
		
		//tests each subset to check if it is the optimal packing
		findOptimalPackings();
		
		//ends run time after optimal packing found/not found
		final long endTime = System.currentTimeMillis();
		
		//print statements if no optimal packing is found
		if (optimalPack.isEmpty()) {
			
			System.out.println("No packing is found.");
			System.out.println("Total running time: " + (endTime - startTime) + " milliseconds");

		}//end if 
		
		//print statements if optimal packing is found
		else {
			
			int j = 1;
			System.out.println("Item: weight, size, value");
			
			for (Item a : optimalPack) {
			
				System.out.println("Item " + j + ": " + a.getWeight() + ", " + a.getSize() + ", " + a.getValue());
				
				j++;
			}//end for loop
			
			System.out.println("Total weight: " + knapWeight);
			System.out.println("Total size: " + knapSize);
			System.out.println("Total value: " + highestValue);
			System.out.println("Total running time: " + (endTime - startTime) + " milliseconds");			
			
		}//end else
		
		
	}//end main
	
	//retrieves user input for variables and inputs data into variable arrays
	public static void getUserInput() {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter the knapsack weight and size capacity (separate by space): ");
		knapWeight = scnr.nextDouble();
		knapSize = scnr.nextDouble();
		
		System.out.println("How many items? ");
		numItems = scnr.nextInt();
		
		weights = new double [numItems];
		sizes = new double [numItems];
		values = new double [numItems];

		
		System.out.println("Enter weights (separate by spaces): ");
		for (int i = 0; i < numItems; i++) {
			weights[i] = scnr.nextDouble();
		}
		System.out.println("Enter sizes (separate by spaces): ");
		for (int i = 0; i < numItems; i++) {
			sizes[i] = scnr.nextDouble();
		}
		System.out.println("Enter values (separate by spaces): ");
		for (int i = 0; i < numItems; i++) {
			values[i] = scnr.nextDouble();
		}
		
		scnr.close();
		
	}//end getUserInput
	
	//creates Item Objects from the arrays of user entered data and adds the Objects to an ArrayList
	public static void createItems() {
		
		for (int i = 0; i < numItems; i++) {
			
			itemArray.add(new Item(weights[i], sizes[i], values[i]));

		}//end for loop
		
		
	}//end createItems
	
	//finds all subsets of Item Objects by duplicating subsets each time and adding next element
	public static void findAllSubsets() {
		
		subsets = new ArrayList<ArrayList<Item>>();
		
		for(int i = 0; i < itemArray.size(); i++) {
			
			ArrayList<ArrayList<Item>> copy = new ArrayList<ArrayList<Item>>();
			
			for(ArrayList<Item> a : subsets) {
				copy.add(new ArrayList<Item>(a));
			}
			
			for(ArrayList<Item> a : copy) {
				a.add(itemArray.get(i));
			}
			
			ArrayList<Item> s = new ArrayList<Item>();
			s.add(itemArray.get(i));
			copy.add(s);
			
			subsets.addAll(copy);
			
		}//end for loop
		
	}//end findAllSubsets
	
	//finds optimal packing, if exists, by checking each subset against knapsack Weight and Size, as well as greatest value
	public static void findOptimalPackings() {
				
		for (ArrayList<Item> a : subsets) {
			
			double weight = 0;
			double size = 0;
			double value = 0;
			
			for(Item i : a) {
				
				weight += i.getWeight();
				size += i.getSize();
				value += i.getValue();				
				
			}//end for loop
			
			if (weight == knapWeight && size == knapSize && value > highestValue) {
				
				highestValue = value;
				
				optimalPack = a;
				
			}//end if loop
			
		}//end for loop
		
		
	}//end findOptimalPackings
	
	
}//end FullKnapsack
