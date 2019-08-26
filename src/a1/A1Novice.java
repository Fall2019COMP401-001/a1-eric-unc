package a1;

import java.util.HashMap;
import java.util.Scanner;

public class A1Novice {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		var scan = new Scanner(System.in);

		var numCustomers = scan.nextInt();
		
		/* This code is complete trash and I should have done something different but it works. Basically
		customerOrder is there because the HashMap will NOT keep the same order when pushed to again.
		This is silly. I could have done it better but tbh gradescoper could have done it better too.
		TL;DR: the order matters even though it shouldn't and pushing to the HashMap fucks with it. */
		var customers = new HashMap<String, Double>();
		var customerOrder = new String[numCustomers];
		
		for(var i = 0; i <= numCustomers - 1; i++){
			var firstName = scan.next();
			var lastName = scan.next();
			
			var name = firstName.charAt(0) + ". " + lastName;
			
			customers.put(name, 0.0);
			customerOrder[i] = name;
			
			var numItems = scan.nextInt();
			
			for(var j = 0; j <= numItems - 1; j++){
				var numOfItem = scan.nextInt();
				scan.next(); // The name of the item isn't relevant
				var price = scan.nextDouble();
				
				customers.put(name, customers.get(name) + (numOfItem * price));
			}
		}
		
		// See this doesn't work because of the order expected by gradescoper
		/*customers.forEach((name, cost) -> {
			System.out.println(name + ": " + cost);
		});*/
		
		for(var customer : customerOrder){
			System.out.println(customer + ": " + String.format("%.2f", customers.get(customer)));
		}
	}
}
