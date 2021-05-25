package model;


/**
 * Write a description of class SalesLineItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SalesLineItem
{
    // instance variables - replace the example below with your own
    private int quantity;
    private Product product;

    /**
     * Constructor for objects of class SalesLineItem
     */
    public SalesLineItem(Product product, int quantity)
    {
        // initialise instance variables
        this.product = product;
        this.quantity = quantity;
    }
}
