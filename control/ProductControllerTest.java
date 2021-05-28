package control;
import model.Product;
import model.ProductContainer;
import model.ColiProduct;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ProductControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductControllerTest
{
    /**
     * Default constructor for test class ProductControllerTest
     */
    public ProductControllerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        ProductContainer productContainer = ProductContainer.getInstance();

        Product screws = new ColiProduct("Skrue001", "Phillips skruer", "En æske med 200 phillips skruer", 60);
        productContainer.addProduct(screws);

        Product screws1 = new ColiProduct("Skrue002", "Torx skruer", "En æske med 60 torx skruer", 30);
        productContainer.addProduct(screws1);    
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
