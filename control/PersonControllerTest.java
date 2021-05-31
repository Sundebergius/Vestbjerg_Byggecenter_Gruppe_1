package control;
import model.PersonContainer;
import model.ProductContainer;
import model.Customer;
import model.Employee;
import model.Product;
import model.ColiProduct;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonControllerTest
{
    /**
     * Default constructor for test class PersonControllerTest
     */
    public PersonControllerTest()
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
        PersonContainer personContainer = PersonContainer.getInstance();
        
        Customer jensPetersen = new Customer("Privat001", 0.05, "Jens Petersen", "Sankt Peter vej 5", 9000, "Aalborg", "+4542069420");
        
        personContainer.addCustomer(jensPetersen); 
        
        Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent", "Kurt Kristensen", "Jernbanegade 5", 9000, "Aalborg", "+4500000001");
        
        personContainer.addEmployee(kurtKristensen);
       
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
