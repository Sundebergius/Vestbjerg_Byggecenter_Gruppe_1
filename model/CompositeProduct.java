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

	public ArrayList<CompositeLine> getProductComposition() {
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
	
	public void giveSpecificProductCopies(CompositeProduct composite) {
				
		for (CompositeLine compositeLine : composite.getProductComposition()) {
						
			Product product = compositeLine.getProduct();
			
			if(product instanceof CompositeProduct) {
				giveSpecificProductCopies((CompositeProduct)product);
								
			}else if(product instanceof SpecificProduct) {
				compositeLine.addCopy();
			}
			
		}
		
	}

	public SaleLineItem createSaleLine(int quantity) {
		
		giveSpecificProductCopies(this);

		return new SaleLineItem(this);
	}

}
