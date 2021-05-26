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
    private String deliveryAddress;

    /**
     * Constructor for objects of class Sale
     */
    public Sale(Employee employee)
    {
        // initialise instance variables
        this.saleLines = new ArrayList<>();
        this.employee = employee;
        dateTime = new Date();
    }
    
    public void addSalesLineItem(SalesLineItem salesLineItem)
    {
        saleLines.add(salesLineItem);
    }
    
    public void addCustomerToSale(Customer customer)
    {
       this.customer = customer;
    }
    
    private void addDeliveryAddressToSale(String deliveryAddress){
        this.deliveryAddress = deliveryAddress;
    }
    
    /**
     * 
     */
    private String getSaleID(){
        return saleID;
    }
}
