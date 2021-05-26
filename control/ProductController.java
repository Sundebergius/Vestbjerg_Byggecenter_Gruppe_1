package control;
import model.ProductContainer;
import model.Product;


/**
 * Write a description of class ProductController here.
 *
 * @author (your name)
 * @version (a version number or a date)
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

    public Product findProductByBarcode(String barcode)
    {
        return productContainer.findProductByBarcode(barcode);
    }
}
