package model;
import java.util.HashMap;


/**
 * A container class to store the data of the created products. 
 *
 * @author Andreas Clement Holmgaard
 */
public class ProductContainer
{
    // instance variables
    private static ProductContainer instance;
    private HashMap<String, Product> productContainer;

    /**
     * Constructor for objects of class ProductContainer.
     */
    private ProductContainer()
    {
        productContainer = new HashMap<>();
    }
    
    /**
     * Get the current instance of product container - if none exists, create one.
     * @return instance of the product container. 
     */
    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }
    
    /**
     * A boolean to check if the barcode for a specific product is not 
     * currently being used by another product. 
     * @param the current barcode that the user wants to check. 
     * @return boolean of the availability of the barcode. 
     */
    public boolean checkBarcodeAvailability(String barcode)
    {
        boolean isAvailable = false;
        if (productContainer.containsKey(barcode))
        {
            isAvailable = false;
        }
        else
        {
            isAvailable = true;
        }
        return isAvailable;
    }
    
    /**
     * Add method for the individual proudct into the instance of a product container. 
     * @param a unique product. 
     */
    public void addProduct(Product product){
        productContainer.put(product.getBarcode(), product);
    }
    
    /**
     * A method to find a specific product through the barcode associated to the product. 
     * @param a String of the barcode. 
     * @return the unique product associated with the barcode. 
     */
    public Product findProductByBarcode(String barcode){
        return productContainer.get(barcode);
    }
    

}
