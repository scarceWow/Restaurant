package people;
import java.util.*;

public class Chef {
	private String name;
	private List<String> histories = new ArrayList<>();
	
	public Chef (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addCook(String name, int quantity) {
		histories.add("- " + name + " (" +  quantity + ")");
	}
	
	public void showCookHistory() {
		System.out.println();
		System.out.println("Chef name: " + name);
		for (String str: histories) {
			System.out.println(str);
		}
	}
}
