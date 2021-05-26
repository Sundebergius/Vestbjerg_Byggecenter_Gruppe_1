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
     * Constructor for objects of class ProductContainer
     */
    private ProductContainer()
    {
        productContainer = new HashMap<>();
    }
    
    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }
    
    public void addProduct(Product product){
        productContainer.put(product.getBarcode(), product);
    }
    
    public Product findProductByBarcode(String barcode){
        return productContainer.get(barcode);
    }
    

}
