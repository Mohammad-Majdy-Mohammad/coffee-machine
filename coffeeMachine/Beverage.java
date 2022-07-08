package coffeeMachine;

public class Beverage {

	private int waterNeeded;	// in miliLitter
	private int milkNeeded;     // in miliLitter
	private int coffeeBeans;    // in gram
	private double price;
	
	public Beverage() {}
	
	public Beverage (int waterNeeded, int milkNeeded, int coffeeBeans, double price) {
		this.waterNeeded = waterNeeded;
		this.milkNeeded = milkNeeded;
		this.coffeeBeans = coffeeBeans;
		this.price = price;
	}
	
	
	public void setCoffeeBeans(int coffeeBeans) {
		this.coffeeBeans = coffeeBeans;
	}
	
	public int getCoffeeBeans() {
		return coffeeBeans;
	}
	
	public void setMilkNeeded(int milkNeeded) {
		this.milkNeeded = milkNeeded;
	}
	
	public int getMilkNeeded() {
		return milkNeeded;
	}
	
	public void setWaterNeeded(int waterNeeded) {
		this.waterNeeded = waterNeeded;
	}
	
	public int getWaterNeeded() {
		return waterNeeded;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
