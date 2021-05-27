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
    private ArrayList<SaleLineItem> saleLines;
    private Customer customer;
    private Employee employee;
    private String saleID;
    private double moneyReceived;
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
    
    public void addSaleLineItem(SaleLineItem saleLineItem)
    {
        saleLines.add(saleLineItem);
    }
    
    public void addCustomerToSale(Customer customer)
    {
       this.customer = customer;
    }
    
    public void addDeliveryAddressToSale(String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }
    
    public String getSaleID()
    {
        return saleID;
    }
    
    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public Employee getEmployee()
    {
        return employee;
    }
    
    public SaleLineItem[] getSaleLineItems()
    {
        return (SaleLineItem[])saleLines.toArray();
    }
    
    /**
     * Calculates the total price of the customer's products. 
     * @return totalPrice. 
     */
    public double calculateTotalPrice()
    {
        double totalPrice = 0;
        
        for(SaleLineItem saleLine : saleLines){
            totalPrice += saleLine.calculateLinePrice();
        }
        
        return totalPrice;
    }
    
    public double getRemainingPayment(){
        
        double remainingPayment = 0;
        remainingPayment = calculateTotalPrice() - moneyReceived;
        return remainingPayment;
    }
    
    public double pay(double money)
    {
        moneyReceived += money;
        
        double remainingPayment = calculateTotalPrice()-moneyReceived;
        
        return remainingPayment;
    }
}
