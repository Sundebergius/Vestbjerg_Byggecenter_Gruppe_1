package model;
import java.util.HashMap;


/**
 * Write a description of class ProductContainer here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
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
     * Get method of individual instance of product container.
     * @return instance of the product container. 
     */
    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }
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
