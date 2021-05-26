package model;
import java.util.Date;
import java.util.ArrayList;

/**
 * Write a description of class Sale here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sale
{
    // instance variables - replace the example below with your own
    private String store;
    private Date dateTime;
    private double discount;
    private String state;
    private ArrayList<SalesLineItem> saleLines;
    private Customer customer;
    private Employee employee;
    private String saleID;
    private String address;

    /**
     * Constructor for objects of class Sale
     */
    private Sale(Employee employee)
    {
        // initialise instance variables
        this.saleLines = new ArrayList<>();
        this.employee = employee;
        dateTime = new Date();
    }
    
    private void addSalesLineItem(SalesLineItem salesLineItem)
    {
        saleLines.add(salesLineItem);
    }
    
    private void addCustomerToSale(Customer customer)
    {
       this.customer = customer;
    }
    
    private void addAddressToSale(String address){
        this.address = address;
    }
    
    /**
     * 
     */
    private String getSaleID(){
        return saleID;
    }
}
