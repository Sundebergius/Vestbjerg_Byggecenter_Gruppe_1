package model;

import java.util.ArrayList;

public class CompositeProduct extends Product {
	
	private ArrayList<CompositeLine> compositeLines;

	public CompositeProduct(String barcode, String name, String description, double price) {
		super(barcode, name, description, price);
		
		compositeLines = new ArrayList<>();
		
	}
	
	public void addProductToComposite(int quantity, Product product) {
		
		CompositeLine line = new CompositeLine(quantity, product);
		
		compositeLines.add(line);
	}
	
	public ArrayList<CompositeLine> getProductComposition(){
		return compositeLines;
	}
	
	

}
