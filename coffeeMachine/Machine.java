package coffeeMachine;

import java.util.Scanner;

public class Machine {

	
	private static int water; // in mL
	private static int milk; // in mL
	private static int coffeeBeans; // in grams
	private static int disposableCups;
	private static double money;
	
	
	public Machine() {
		Machine.water = 400;
		Machine.milk = 540;
		Machine.coffeeBeans = 120;
		Machine.disposableCups = 9;
		Machine.money = 550;
	}	

	public static double getMoney() {
		return money;
	}
	
	public static void setMoney(double money) {
		Machine.money = money;
	} 
	
	public static int getWater() {
		return water;
	}
	
	public static void setWater(int water) {
		Machine.water = water;
	}
	
	public static int getMilk() {
		return milk;
	}
	
	public static void setMilk(int milk) {
		Machine.milk = milk;
	}
	
	public static int getCoffeeBeans() {
		return coffeeBeans;
	}
	
	public static void setCoffeeBeans(int coffeeBeans) {
		Machine.coffeeBeans = coffeeBeans;
	}
	
	public static int getDisposableCups() {
		return disposableCups;
	}
	
	public static void setDisposableCups(int disposableCups) {
		Machine.disposableCups = disposableCups;
	}
	
	
	// Beverages available :
	Beverage espresso   = new Beverage(250, 0, 16, 4);
	Beverage latte      = new Beverage(350, 75, 20, 7);
	Beverage cappuccino = new Beverage(200, 100, 12, 6);
	
	
	private String enoughResources(String drink) {
		
		boolean enoughWater  = true;
		boolean enoughMilk   = true;
		boolean enoughCoffee = true;
		
		if (drink.equalsIgnoreCase("espresso")) {
			
			enoughWater  = Machine.water       >= espresso.getWaterNeeded();
			enoughMilk   = Machine.milk        >= espresso.getMilkNeeded();
			enoughCoffee = Machine.coffeeBeans >= espresso.getCoffeeBeans();
			
			
		} else if ("latte".equalsIgnoreCase(drink)) {
			
			enoughWater  = Machine.water       >= latte.getWaterNeeded();
			enoughMilk   = Machine.milk        >= latte.getMilkNeeded();
			enoughCoffee = Machine.coffeeBeans >= latte.getCoffeeBeans();
			
		} else if ("cappuccino".equalsIgnoreCase(drink)) {
			
			enoughWater  = Machine.water       >= cappuccino.getWaterNeeded();
			enoughMilk   = Machine.milk        >= cappuccino.getMilkNeeded();
			enoughCoffee = Machine.coffeeBeans >= cappuccino.getCoffeeBeans();
			
		}
		
		if (!enoughWater) {

			System.out.println("Sorry, not enough water!");
			return "water";
			
		} else if (!enoughMilk) {
			
			System.out.println("Sorry, not enough milk!");
			return "milk";
		
		} else if (!enoughCoffee) {
		
			System.out.println("Sorry, not enough coffee beans!");
			return "coffee";
			
		} else {
			
			System.out.println("I have enough resources, making you a coffee!");
			return "enough";
			
		}
		
	}
	
	private void buy(String drink) {
		
		if (drink.equalsIgnoreCase("espresso")) {
			
			Machine.water          -= espresso.getWaterNeeded();
			Machine.milk           -= espresso.getMilkNeeded();
			Machine.coffeeBeans    -= espresso.getCoffeeBeans();
			Machine.disposableCups -= 1;
			Machine.money          += espresso.getPrice();
			
		} else if (drink.equalsIgnoreCase("latte")) {
			
			Machine.water          -= latte.getWaterNeeded();
			Machine.milk           -= latte.getMilkNeeded();
			Machine.coffeeBeans    -= latte.getCoffeeBeans();
			Machine.disposableCups -= 1;
			Machine.money          += latte.getPrice();
			
		} else if (drink.equalsIgnoreCase("cappuccino")) {
			
			Machine.water          -= cappuccino.getWaterNeeded();
			Machine.milk           -= cappuccino.getMilkNeeded();
			Machine.coffeeBeans    -= cappuccino.getCoffeeBeans();
			Machine.disposableCups -= 1;
			Machine.money          += cappuccino.getPrice();
			
		}
		
	}
	
	
	
	private void messageOfMachineContent() {
		
		System.out.println("The coffee machine has: \n");
		System.out.println(Machine.water + " ml of water");
		System.out.println(Machine.milk + " ml of milk");
		System.out.println(Machine.coffeeBeans + " coffee beans");
		System.out.println(Machine.disposableCups + " disposable cups");
		System.out.println("$" + (int)Machine.money + " of money");
	
	}
	
	
	
	
	public void interactWithMainScreen() {
		
		final Scanner scan = new Scanner(System.in);
				
		boolean isActive = true;
		
		while (isActive) {
			
			System.out.println("\n\nWrite action (buy, fill, take, remaining, exit): ");
			
			String choice = scan.next();
			
			if (choice.equalsIgnoreCase("buy") || choice.equalsIgnoreCase("1")) {
				
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
				String drink = scan.next();
								
					
				if (drink.equalsIgnoreCase("espresso") || drink.equalsIgnoreCase("1")) {
					
					if (enoughResources("espresso").equalsIgnoreCase("enough")) {
					
						buy("espresso");
					
					}
					
				} else if (drink.equalsIgnoreCase("latte") || drink.equalsIgnoreCase("2")) {
					
					if (enoughResources("latte").equalsIgnoreCase("enough")) {
						
						buy("latte");
					
					}
					
				} else if (drink.equalsIgnoreCase("cappuccino") || drink.equalsIgnoreCase("3")) {
					
					if (enoughResources("cappuccino").equalsIgnoreCase("enough")) {
						
						buy("cappuccino");
					
					}
					
				} else if (drink.equalsIgnoreCase("back") || drink.equalsIgnoreCase("to main menu") || drink.equalsIgnoreCase("4")) {
					
					continue;
					
				} else {
					
					System.out.println("not a valid drink!");
					
				}
				
								
			} else if (choice.equalsIgnoreCase("fill") || choice.equalsIgnoreCase("2")) {
				
				Operatoer.fill();
				
			} else if (choice.equalsIgnoreCase("take") || choice.equalsIgnoreCase("3")) {
				
				Operatoer.takeMoney();
				
			} else if (choice.equalsIgnoreCase("remaining") || choice.equalsIgnoreCase("4")) {
				
				messageOfMachineContent();
				
			} else if (choice.equalsIgnoreCase("exit") || choice.equalsIgnoreCase("5")) {
				
				break;
				
			} else {
				
				System.out.println("not a valid choice!");
				
			}
		
		}
			
	}
		
}
	

