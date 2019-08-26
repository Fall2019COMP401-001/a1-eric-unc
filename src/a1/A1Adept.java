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
		
		String biggest;
		String smallest;
		var total = 0.0d;
		
		customers.forEach((name, cost) -> {
			
		});
	}
}
