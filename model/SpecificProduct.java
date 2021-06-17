package model;

import java.util.HashMap;
import java.util.Stack;

public class SpecificProduct extends SimpleProduct {
	
	private Stack<Copy> copies;

	public SpecificProduct(String barcode, String name, String description, double price) {
		super(barcode, name, description, price);
		copies = new Stack<>();
		
	}
	
	public void addCopy(String serialNo) {
		
		Copy copy = new Copy(serialNo);
		
		copies.push(copy);
	}
	
	public Copy getCopy() {
		
		return copies.pop();
	}

}
