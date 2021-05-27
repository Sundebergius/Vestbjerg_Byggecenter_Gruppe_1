package model;


/**
 * Write a description of class SalesLineItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaleLineItem
{
    // instance variables - replace the example below with your own
    private int quantity;
    private Product product;

    /**
     * Constructor for objects of class SalesLineItem.
     * @param Product product, int quantity. 
     */
    public SaleLineItem(Product product, int quantity)
    {
        // initialise instance variables
        this.product = product;
        this.quantity = quantity;
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
     * @return product. 
     */
    public Product getProduct()
    {
        return product;
    }
    
    /**
     * Get method of quantity. 
     * @return quantity. 
     */
    public int getQuantity(){
        return quantity;
    }
    
}
