package model;
import control.*;




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SaleContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SaleContainerTest
{
    private SaleContainer saleContainer;
    private PersonContainer personContainer;
    private ProductContainer productContainer;
    /**
     * Default constructor for test class SaleContainerTest
     */
    public SaleContainerTest()
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

    
     @Test
    public void testAddSalePositive()
    {
        
        SaleContainer saleContainer = SaleContainer.getInstance();
        PersonContainer personContainer = PersonContainer.getInstance();
        ProductContainer productContainer = ProductContainer.getInstance();
        
        Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent", "Kurt Kristensen", "Jernbanegade 5", 9000, "Aalborg", "+4500000001");
        personContainer.addEmployee(kurtKristensen);
   
        String saleID1 = saleContainer.getNewSaleID();
        Sale sale1 = new Sale(kurtKristensen);

        int size = saleContainer.getSize();
        saleContainer.addSale(saleID1, sale1);
        assertEquals(size+1, saleContainer.getSize());
        
    }
    
}
