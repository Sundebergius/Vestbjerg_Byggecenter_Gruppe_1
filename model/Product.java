package model;

/**
 * A class used to add an individual product, with all the required parameters, into the system. 
 *
 * @author Andreas Clement Holmgaard
 */
public abstract class Product
{
    private String name;
    private String description;
    private double price;
    private String barcode;

    /**
     * Constructor for objects of class Product.
     * @param a String of the name, a String of the description, 
     * a double of the price, a String of the barcode.
     */
    public Product(String barcode, String name, String description, double price)
    {
        this.description = description;
        this.price = price;
        this.name = name;
        this.barcode = barcode;
    }

    /**
     * Get method for Barcode. 
     *@return the barcode of product. 
     */

    public String getBarcode()
    {
        return barcode;
    }

    /**
     * Get method for price. 
     * @return the price of product.
     */

    public double getPrice()
    {
        return price;
    }

    /**
     * Get method for name. 
     * @return the name of product. 
     */

    public String getName()
    {
        return name;   
    }

    /**
     * Get method for description. 
     * @return the description of product. 
     */

    public String getDescription()
    {
        return description;
    }

    public void setBarcode(String newBarcode)
    {
        barcode = newBarcode;
    }
}
