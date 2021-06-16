package model;

import java.util.ArrayList;

public class CompositeProduct extends Product {
	
	private ArrayList<CompositeLine> compositeLines;

	public CompositeProduct(String barcode, String name, String description) {
		super(barcode, name, description, 0);
		
		compositeLines = new ArrayList<>();
		
	}
	
	public void addProductToComposite(int quantity, Product product) {
		
		CompositeLine line = new CompositeLine(quantity, product);
		
		compositeLines.add(line);
	}
	
	public ArrayList<CompositeLine> getProductComposition(){
		return compositeLines;
	}
	
	@Override
	public double getPrice() {
		
		return calculatePrice();
	}
	
	private double calculatePrice() {
		double total = 0;
		
		for (CompositeLine compositeLine : compositeLines) {
			total += compositeLine.getTotalPrice();
		}		
		
		return total;
	}
	
	

}
