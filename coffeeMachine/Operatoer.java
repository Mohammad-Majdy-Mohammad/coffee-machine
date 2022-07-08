package coffeeMachine;

import java.util.Scanner;

public class Operatoer {


	
	protected static void takeMoney() {
		System.out.println("I gave you I gave you $" + Machine.getMoney() + "\n\n");
		Machine.setMoney(0);
	}
	
	protected static void fill() {

		final Scanner scan = new Scanner(System.in);
		
		System.out.println("Write how many ml of water you want to add:");
        int water = scan.nextInt();
		System.out.println("Write how many ml of milk you want to add:");
		int milk = scan.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add:");
		int coffeeBeans = scan.nextInt();
		System.out.println("Write how many disposable cups of coffee you want to add:");
		int disposalCups = scan.nextInt();
		
		Machine.setWater(water + Machine.getWater());
		Machine.setMilk(milk + Machine.getMilk());
		Machine.setCoffeeBeans(coffeeBeans + Machine.getCoffeeBeans());
		Machine.setDisposableCups(disposalCups + Machine.getDisposableCups());
		
	}
	
	
			
}
