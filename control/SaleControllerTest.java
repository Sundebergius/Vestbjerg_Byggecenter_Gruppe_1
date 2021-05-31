package control;
import model.PersonContainer;
import model.ProductContainer;
import model.Customer;
import model.Employee;
import model.Product;
import model.ColiProduct;
import model.Sale;
import model.SaleContainer;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SaleControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SaleControllerTest
{
    
    SaleController saleController;
    
    /**
     * Default constructor for test class SaleControllerTest
     */
    public SaleControllerTest()
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
        saleController = new SaleController();
        
        PersonContainer personContainer = PersonContainer.getInstance();
        
        Customer jensPetersen = new Customer("Privat001", 0.05, "Jens Petersen", "Sankt Peter vej 5", 9000, "Aalborg", "+4542069420");
        
        personContainer.addCustomer(jensPetersen); 
        
        
        ProductContainer productContainer = ProductContainer.getInstance();

        Product screws = new ColiProduct("Skrue001", "Phillips skruer", "En æske med 200 phillips skruer", 60);
        productContainer.addProduct(screws);

        Product screws1 = new ColiProduct("Skrue002", "Torx skruer", "En æske med 60 torx skruer", 30);
        productContainer.addProduct(screws1);    
        
        SaleContainer saleContainer = SaleContainer.getInstance();
        saleContainer.clearContainer();
        
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
    public void completeSaleTest()
    {
        Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent",
        "Kurt Kristensen", "Jernbanegade 5", 9000, "Aalborg", "+4500000001");
                
        saleController.createSale(kurtKristensen); 
        
        saleController.addProductToSale("Skrue001", 5);
        
        saleController.addProductToSale("Skrue002", 3);
        
        saleController.addCustomerToSale("Privat001");
        
        saleController.addDeliveryAddressToSale("Some address");
        
        saleController.setCurrentSaleID();
        
        Sale currentSale = saleController.getCurrentSale();
        
        saleController.pay(currentSale.calculateTotalPrice());
        
        assertEquals(currentSale.getSaleLineItems().length,2);  
        assertEquals(currentSale.getCustomer().getCustomerID(), "Privat001");
        assertEquals(currentSale.getEmployee().getEmployeeID(), "SalgsAss001");
        assertEquals(currentSale.getDeliveryAddress(), "Some address");
        assertNotEquals(currentSale.getSaleID(), "");                   
        assertEquals(currentSale.getMoneyReceived(), currentSale.calculateTotalPrice());
        assertEquals(currentSale.getRemainingPayment(),0);
        
        SaleContainer saleContainer = SaleContainer.getInstance();
        
        int size = saleContainer.getSize();
        
        saleController.logSale();
        
        assertEquals(saleController.getCurrentSale(), null);
        assertEquals(size+1,saleContainer.getSize());
        
    }
    
    @Test
    public void addEmptySaleTest(){
        
        Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent", "Kurt Kristensen", "Jernbanegade 5", 9000, "Aalborg", "+4500000001");
        
        saleController.createSale(kurtKristensen);
        
        SaleContainer saleContainer = SaleContainer.getInstance();
        
        int size = saleContainer.getSize();
        
        saleController.logSale();
        
        assertNotEquals(saleContainer.getSize(), size+1);
        assertNotEquals(saleController.getCurrentSale(), null);
        
        
    }
    
    @Test
    public void addUnpaidSaleTest()
    {
        Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent", "Kurt Kristensen", "Jernbanegade 5", 9000, "Aalborg", "+4500000001");
                
        saleController.createSale(kurtKristensen); 
        
        saleController.addProductToSale("Skrue001", 5);
        
        saleController.addProductToSale("Skrue002", 3);
        
        saleController.addCustomerToSale("Privat001");
        
        saleController.addDeliveryAddressToSale("Some address");
        
        saleController.setCurrentSaleID();
        
        Sale currentSale = saleController.getCurrentSale();
    
        
        SaleContainer saleContainer = SaleContainer.getInstance();
        
        int size = saleContainer.getSize();
        
        saleController.logSale();
        
        assertNotEquals(saleContainer.getSize(), size+1);
        assertNotEquals(saleController.getCurrentSale(), null);
        
        
    }
}

