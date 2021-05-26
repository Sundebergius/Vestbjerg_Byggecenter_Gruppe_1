package tui;
import control.SaleController; 


/**
 * Write a description of class SaleUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaleUI extends Menu
{
    // instance variables - replace the example below with your own
    private SaleController saleController;
    public void doUI()
    {
     printSaleMenu();
     createSale();
     addProductToSale();
     printCurrentSaleTotalPrice();
     
    }

    /**
     * Constructor for objects of class SaleUI
     */
    public SaleUI()
    {
        // initialise instance variables
        
    }

    private void printSaleMenu(){
        //System.out.print("\f");
        System.out.println("****** Salgsmenu ******");
        System.out.println("  (1) ");
        System.out.println(" (9) ");
        System.out.println(" (0) Afslut programmet");
        System.out.println(" Vælg:");
    }
    
    private void createSale()
    {
        saleController.createSale();   
    }
    
    private void addProductToSale()
    {
        System.out.println("Hvad er stregkoden?");
        String barcode = getNextWord();
        System.out.println("Hvor stort antal?");
        int quantity = getNextInt();
        saleController.addProductToSale(barcode, quantity);
    }
    
    private void addCustomerToSale()
    {
        System.out.println("Hvad er kundenummeret?");
        String customerID = getNextWord();
        saleController.addCustomerToSale(customerID);    
    }
    
    private void addDeliveryAddressToSale()
    {
        System.out.println("Hvad er leverings adressen?");
        String address = getNextWord();
        saleController.addDeliveryAddressToSale(address);
    }
    
    private void startPaymentTransaction()
    {
        System.out.println("Hvor meget betales der med?");
        double money = getNextDouble();
        saleController.pay(money);  
    }
    
    private void printCurrentSaleTotalPrice()
    {
        double totalPrice = saleController.getCurrentSaleTotalPrice();
        System.out.println("Pris: " + totalPrice + "DKK");
    }
}
