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
     * Constructor for objects of class SalesLineItem
     */
    public SaleLineItem(Product product, int quantity)
    {
        // initialise instance variables
        this.product = product;
        this.quantity = quantity;
    }
    
    public double calculateLinePrice()
    {
        return product.getPrice() * quantity;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
}
