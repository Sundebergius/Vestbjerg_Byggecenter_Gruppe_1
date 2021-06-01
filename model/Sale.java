package model;
import java.util.Date;
import java.util.ArrayList;

/**
 * A class to begin and end a specific sale to a specific customer, with the products
 * that the customer wants to buy. 
 *
 * @author Mathias Søndberg-Madsen
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
     * Constructor for objects of class Sale. 
     * @param employee in charge of the sale.
     */
    public Sale(Employee employee)
    {
        // initialise instance variables
        this.saleLines = new ArrayList<>();
        this.employee = employee;
        deliveryAddress = "";
        dateTime = new Date();
    }
    
    /**
     * Add method for each individual linesale of a specific product, including quantity. 
     * @param individual linesale, including quantity of specific product. 
     */
    public void addSaleLineItem(SaleLineItem saleLineItem)
    {
        saleLines.add(saleLineItem);
    }
    
    /**
     * Add method for the unique customer to the current sale. 
     * @param unique customer is added to the field. 
     */
    public void addCustomerToSale(Customer customer)
    {
       this.customer = customer;
    }
    
    /**
     * Add method for the delivery address to the sale - can be skipped if not applicable
     * to the customer. 
     * @param a String delivery address to the customer. 
     */
    public void addDeliveryAddressToSale(String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }
    
    /**
     * Get method for sale ID. 
     * @return ID of sale. 
     */
    public String getSaleID()
    {
        return saleID;
    }
    
    /**
     * Get method for the delivery address of the sale of the customer. 
     * @return delivery address of the customer. 
     */
    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }
    
    /**
     * Get method of the current customer associated to the sale. 
     * @return the customer. 
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    /**
     * Get method of the employee associated to the sale. 
     * @return the current employee. 
     */
    public Employee getEmployee()
    {
        return employee;
    }
    
    /**
     * Get method for all the current products in the line sale. 
     * @return an array containing each saleline added to the sale. 
     */
    public SaleLineItem[] getSaleLineItems()
    {
        SaleLineItem[] saleLinesArray = new SaleLineItem[saleLines.size()];
        saleLinesArray = saleLines.toArray(saleLinesArray);
        
        return saleLinesArray;
    }
    
    /**
     * Calculates the total price of the customer's products. 
     * @return the total price of the customer's products. 
     */
    public double calculateTotalPrice()
    {
        double totalPrice = 0;
        
        for(SaleLineItem saleLine : saleLines){
            totalPrice += saleLine.calculateLinePrice();
        }
        
        return totalPrice;
    }
    
    /**
     * Get method for the remaining amount of current payment. 
     * @return the amount remaining of due payment. 
     */
    public double getRemainingPayment(){
        
        double remainingPayment = 0;
        remainingPayment = calculateTotalPrice() - moneyReceived;
        return remainingPayment;
    }
    
    public double getMoneyReceived(){
         return moneyReceived;  
    }
    
    /**
     * A method to pay for the products in the current sale. 
     * @param money received from the customer to the sales assistant. 
     * @return the amount remaining of a transaction - will be negative 
     * if money should be returned to the customer. 
     */
    public double pay(double money)
    {
        moneyReceived += money;
        
        return getRemainingPayment();
    }
    
    /**
     * sets the saleID on the sale
     * @param saleID The value given to the sales saleID
     */    
    public void setSaleID(String saleID){
        this.saleID = saleID;
    }
}
