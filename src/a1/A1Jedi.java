package a1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class A1Jedi {
	/**
	 * Used to represent food items. Encapsulation standards are ignored here :)
	 * @author Eric Schneider
	 *
	 */
	public static class Item {
		String name;
		int customers;
		int bought;
		
		/** This is needed because I have to make sure it isn't a repeat when incrementing 
		 * {@link #customers}.
		 */
		ArrayList<String> customerNames = new ArrayList<>();
		
		public Item(String name, int customers, int bought){
			this.name = name;
			this.customers = customers;
			this.bought = bought;
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args){
		var scan = new Scanner(System.in);

		/**
		 * name, {@link Item} object 
		 * I know this means the name is in the code twice but i ain't changing it
		 * 
		 */
		var items = new LinkedHashMap<String, Item>();
		
		var numItems = scan.nextInt();
		
		for(var i = 0; i < numItems; i++){
			var itemName = scan.next();
			scan.nextDouble(); // The price doesn't matter this time
			
			items.put(itemName, new Item(itemName, 0, 0));
		}
		
		var numCustomers = scan.nextInt();
		
		for(var i = 0; i < numCustomers; i++){
			var first = scan.next();
			var last = scan.next();
			var name = first + " " + last;
			
			var numItemsPCustomer = scan.nextInt();
			
			for(var j = 0; j < numItemsPCustomer; j++){
				var numOfItem = scan.nextInt();
				var item = scan.next();
				
				var oItem = items.get(item);
				
				if(!oItem.customerNames.contains(name)) {
					oItem.customerNames.add(name);
					oItem.customers++;
				}
				
				oItem.bought += numOfItem;
			}
		}
		
		items.forEach((name, item) -> {
			if(item.customers != 0)
				System.out.println(item.customers + " customers bought " + item.bought + " " + name);
			else
				System.out.println("No customers bought " + name);
		});
	}
}
