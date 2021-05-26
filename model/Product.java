package model;

/**
 * Write a description of class Product here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public abstract class Product
{
    private String name;
    private String description;
    private double price;
    private String barcode;

    
    /**
     * Constructor for objects of class Product
     */
    public Product(String name, String description, double price, String barcode){
        this.description = description;
        this.price = price;
        this.barcode = barcode;
    }
    
    public String getBarcode(){
        return barcode;
    }
    
    public double getPrice(){
        return price;
    }
}
