package control;
import model.ProductContainer;
import model.ColiProduct;
import model.Product;


/**
 * 
 *
 * @author Mathias Søndberg-Madsen
 */
public class ProductController
{
    // instance variables - replace the example below with your own
    private ProductContainer productContainer;

    /**
     * Constructor for objects of class ProductController
     */
    public ProductController()
    {
        // initialise instance variables
        productContainer = productContainer.getInstance();
    }
    
    /**
     * A method to find a specific product by searching with a barcode as a String. 
     * @param the barcode of a product as a type String. 
     * @return the specific product if associated with an existing barcode. If not, returns null. 
     */
    public Product findProductByBarcode(String barcode)
    {
        return productContainer.findProductByBarcode(barcode);
    }
    
    
     public void createNewProduct(String barcode, String name, String description, double price)
     {
     	ColiProduct newProduct = new ColiProduct(barcode, name, description, price);
     	productContainer.addProduct(newProduct);
     }
     
}
