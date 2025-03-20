package restaurant;
import java.text.NumberFormat;
import java.util.*;

import main.Food;
import people.Chef;
import people.Visitor;

public class Restaurant {
	private String name;
	private List<Menu> menus = new ArrayList<>();
	private List<Chef> chefs = new ArrayList<>();
	private int totalCost;
	
	public Restaurant (String name) {
		this.name = name;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public String getName() {
		return name;
	}
	
	public List<Chef> getChefs() {
		return chefs;
	}

	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	
	public void addChef(Chef chef) {
		chefs.add(chef);
	}
	
	public void showMenu() {
		System.out.println("Menus: ");
		for (Menu menu: menus) {
			System.out.println(menu.getName() + ":");
			for (Food food : menu.getFoods()) {
				System.out.println("Food Name: " +food.getName() + ", Food Price: " + food.getPrice());
			}
			System.out.println("==================================");
		}
	}
	
	public void showChef() {
		System.out.println("Chefs: ");
		for (Chef chef: chefs) {
			System.out.println("- Name: " + chef.getName());
		}
		System.out.println("==================================");
	}
	
	public void order(Chef chef, Visitor visitor, String name, int quantity) {
		for(Menu menu : menus) {
			for (Food food: menu.getFoods()) {
				if (food.getName().equals(name)) {
					int cost = food.getPrice()*quantity;
					visitor.addPrice(cost);
					chef.addCook(name, quantity);
					totalCost += cost;
				}
			}
		}
		System.out.println(visitor.getName() + " ordered " + name + " (" + quantity + "pcs)");
	}
	
	public static String formatIDR(int amount) { 
		@SuppressWarnings("deprecation")
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID")); 
	    return formatter.format(amount);
	}

	
	public void showTotalIncome() {
		System.out.println("\nRestaurant's total income: " + formatIDR(totalCost));
	}
}
