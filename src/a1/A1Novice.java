package a1;

import java.util.HashMap;
import java.util.Scanner;

public class A1Novice {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		var scan = new Scanner(System.in);

		var numCustomers = scan.nextInt();
		
		HashMap<String, Double> customers = new HashMap<>();
		
		for(int i = 0; i <= numCustomers - 1; i++){
			var firstName = scan.next();
			var lastName = scan.next();
			
			var name = firstName.charAt(0) + ". " + lastName;
			
			customers.put(name, 0.0);
			
			var numItems = scan.nextInt();
			
			for(int j = 0; j <= numItems - 1; j++){
				var numOfItem = scan.nextInt();
				scan.next(); //The name of the item isn't important
				var price = scan.nextDouble();
				
				customers.put(name, customers.get(name) + (numOfItem * price));
			}
		}
		
		customers.forEach((name, cost) -> {
			System.out.println(name + ": " + cost);
		});
	}
}
