package control;
import model.PersonContainer;
import model.Customer;


/**
 * Write a description of class PersonController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PersonController
{
    // instance variables - replace the example below with your own
    private PersonContainer personContainer;
    /**
     * Constructor for objects of class PersonController
     */
    public PersonController()
    {
        // initialise instance variables
        personContainer = personContainer.getInstance();   
    }
    
    public Customer findCustomerByCustomerID(String customerID)
    {
         return personContainer.findCustomerByCustomerID(customerID);   
    }

    
}
