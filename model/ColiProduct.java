package model;

/**
 * A class used for later implementation of the system. 
 *
 * @author Andreas Clement Holmgaard
 */
public class ColiProduct extends SimpleProduct
{
   
    /**
     * Constructor for objects of class ColiProduct
     * @param a String of the description, a double of the price, a String of the barcode
     */
    public ColiProduct(String barcode, String name, String description, double price){
        super(barcode, name, description, price);
    }

}
