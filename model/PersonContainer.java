package model;
import java.util.HashMap;


/**
 * Write a description of class PersonContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonContainer
{
    // instance variables - replace the example below with your own
    private static PersonContainer instance;
    private HashMap<String, Customer> customerContainer;
    private HashMap<String, Employee> employeeContainer;

    /**
     * Constructor for objects of class PersonContainer
     */
    private PersonContainer()
    {
        // initialise instance variables
        customerContainer = new HashMap<>();
        employeeContainer = new HashMap<>();
    }
    
    /**
     * 
     */
    public static PersonContainer getInstance()
    {
        // Singleton
        if(instance == null) {
            instance = new PersonContainer();
        }
        return instance;
    }
    /**
     * Method to find customer by customerID
     * @param customerID The customerID
     * @return Showing the finded customer by customerID
     */
    public Customer findCustomerByCustomerID(String customerID)
    {
        // Returns customer value in HashMap stored by key
        return customerContainer.get(customerID);
    }
    
    
}
