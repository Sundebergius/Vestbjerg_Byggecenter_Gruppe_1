package model;


/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String customerID;
    private double customerDiscount;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String newCustomerID, double newCustomerDiscount)
    {
        // Initialise instance variables
        this.customerID = newCustomerID;
        this.customerDiscount = newCustomerDiscount;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getCustomerID()
    {
        // Returns customerID
        return customerID;
    }
}
