package model;

/**
 * Write a description of class ColiProduct here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public abstract class SimpleProduct extends Product
{
    
    /**
     * Constructor for objects of class SimpleProduct
     */
    public SimpleProduct(String name, String description, double price){
        super(name, description, price);
    }
}
