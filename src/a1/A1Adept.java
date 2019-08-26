package a1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class A1Adept {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		var scan = new Scanner(System.in);

		var items = new HashMap<String, Double>();
		
		var numItems = scan.nextInt();
		
		for(var i = 0; i < numItems; i++){
			var itemName = scan.next();
			var itemPrice = scan.nextDouble();
			
			items.put(itemName, itemPrice);
		}
		
		// So I looked it up and LinkedHashMap preserves the iteration order.
		// I'm an idiot and didn't use this in A1Novice but I will use it now.
		var customers = new LinkedHashMap<String, Double>();
		
		var numCustomers = scan.nextInt();
		
		for(var i = 0; i < numCustomers; i++){
			var name = scan.next();
			customers.put(name, 0.0);
			
			var numItemsPCustomer = scan.nextInt();
			
			for(var j = 0; j < numItemsPCustomer; j++){
				var numOfItem = scan.nextInt();
				var item = scan.next();
				
				customers.put(name, customers.get(name) + (numOfItem * items.get(item)));
			}
		}
		
		
		// Variables are defined at the class level because lambdas are a HUGE fucking pain in
		// the ass (cannot change local variables) and I'm too lazy to not use them. see below the method.
		
		customers.forEach((name, cost) -> {
			if(biggest.isEmpty() || smallest.isEmpty()){
				biggest = name;
				smallest = name;
			}else{
				if(customers.get(biggest) < cost)
					biggest = name;
				
				if(customers.get(smallest) > cost)
					smallest = name;
			}
			
			total += cost;
		});
		
		System.out.println("Biggest: " + biggest + "(" + String.format("%.2f", customers.get(biggest)) + ")");
		System.out.println("Smallest: " + smallest + "(" + String.format("%.2f", customers.get(smallest)) + ")");
		System.out.println("Average: " + String.format("%.2f", total / customers.size()));
	}
	
	private static String biggest = "";
	private static String smallest = "";
	private static double total = 0.0;
}
