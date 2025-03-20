package people;

import restaurant.Restaurant;

public class Visitor {
	private String name;
	private int totalPrice;
	
	public Visitor (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getTotal() {
		return totalPrice;
	}
	
	public void addPrice(int cost) {
		totalPrice += cost;
	}
	
	public void showTotalPrice() {
		System.out.println();
		System.out.println(name + " total bill: " + Restaurant.formatIDR(totalPrice));
	}
}
