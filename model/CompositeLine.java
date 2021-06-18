package model;

public class CompositeLine {

	private int quantity;
	private Product product;
	private Copy copy;

	public CompositeLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public CompositeLine(SpecificProduct product) {
		quantity = 1;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}

	public void addCopy() {

		if (product instanceof SpecificProduct) {

			SpecificProduct specificProduct = (SpecificProduct) product;

			copy = specificProduct.getCopy();
		}
		
		System.out.println(copy.getSerialNo() + "has been added to a compositeLine");
	}

}
