package model;


/**
 * Calculates the price for the quantity of an individual product, 
 * and adds it as a sales line item. 
 * 
 * @author Mathias Søndberg-Madsen
 */
public class SaleLineItem
{
    // instance variables - replace the example below with your own
    private int quantity;
    private Product product;
    private Copy productCopy;

    /**
     * Constructor for objects of class SalesLineItem.
     * @param the specific product, the quantity as an int. 
     */
    public SaleLineItem(Product product, int quantity)
    {
        // initialise instance variables
        this.product = product;
        this.quantity = quantity;
    }
    
    public SaleLineItem(Product product, Copy productCopy) {
    	this.product = product;
    	this.productCopy = productCopy;
    	quantity = 1;
    }
    
    
    
    /**
     * Method to calculate the total price of specified quantity of specific product. 
     * @return total price of specified quantity of specific product. 
     */
    public double calculateLinePrice()
    {
        return product.getPrice() * quantity;
    }
    
    /**
     * Get method of product. 
     * @return the product. 
     */
    public Product getProduct()
    {
        return product;
    }
    
    /**
     * Get method of quantity. 
     * @return the quantity of product. 
     */
    public int getQuantity(){
        return quantity;
    }
    
    public Copy getProductCopy() {
		return productCopy;
	}
    
}
