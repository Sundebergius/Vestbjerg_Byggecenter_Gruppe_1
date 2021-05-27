package model;

/**
 * A class used for later implementation of the system. 
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public abstract class SimpleProduct extends Product
{
    
    /**
     * Constructor for objects of class SimpleProduct.
     * @param a String of the name, a String of the description,
     * a double of the price, a String of the barcode.
     */
    public SimpleProduct(String name, String description, double price){
        super(name, description, price);
    }
}
