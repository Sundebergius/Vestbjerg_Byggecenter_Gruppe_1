package model;


/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends Person
{
    // instance variables - replace the example below with your own
    private String customerID;
    private double customerDiscount;

    /**
     * Constructor for objects of class Customer
     */

    public Customer(String customerID, double customerDiscount, String name, String address, int postalCode, String city, String mobileNo)

    {
        // Initialise instance variables

        super(name,address,postalCode,city,mobileNo);
        this.customerID = customerID;
        this.customerDiscount = customerDiscount;
    }

    /**
     * Method to show customerID
     * @return showing customerID
     */
    //Not implemented
    public String getCustomerID()
    {
        // Returns customerID
        return customerID;
    }
    
    /**
     * Method making a discount for the customer
     * @return Showing customer discount
     */
    //not implemented
    public double getCustomerDiscount()
    {
        return customerDiscount;
    }
}
