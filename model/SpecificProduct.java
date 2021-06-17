package model;

import java.util.HashMap;

public class SpecificProduct extends SimpleProduct {
	
	private HashMap<String, Copy> copies;

	public SpecificProduct(String barcode, String name, String description, double price) {
		super(barcode, name, description, price);
		copies = new HashMap<>();
		
	}
	
	public void addCopy(String serialNo) {
		
		Copy copy = new Copy(serialNo);
		
		copies.put(serialNo, copy);
	}
	
	public Copy getCopy(String serialNo) {
		
		return copies.get(serialNo);
	}

}
