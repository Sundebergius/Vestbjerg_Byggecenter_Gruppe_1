package tui;
import control.SaleController; 
import model.Sale;
import model.SaleLineItem;
import model.Product;

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

    /**
     * Constructor for objects of class SaleUI
     */
    public SaleUI()
    {
        saleController = new SaleController();

    }

    public void doUI()
    {
        saleMenu();
    }

    public void saleMenu(){
        boolean running = true;

        while(running){
            printSaleMenu();
            int choice = getNextInt();

            switch(choice){
                case 1:
                startSale();
                break;

                case 0:
                running = false;
                break;

                default:
                System.out.println("Ukendt kommando : " + choice + ".");
                break;
            }
        }
    }   

    private void startSale(){
        createSale();

        addProductsLoop();

        addCustomerToSale();

        addDeliveryAddressToSale();

        printCurrentSaleOverview();
        
        startPaymentTransaction();

    }

    private void printSaleMenu(){
        //System.out.print("\f");
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Opret Salg");
        System.out.println(" (0) Tilbage til hovedmenu");
        System.out.println(" Vælg:");
    }

    private void createSale()
    {
        saleController.createSale();   
    }

    private void addProductsLoop()
    {

        boolean addingProducts = true;

        while(addingProducts){

            addProductToSale();

            boolean makeChoice = false;

            while(!makeChoice){

                System.out.println("Vil du tilføje flere produkter?");
                System.out.println(" (1) Ja");
                System.out.println(" (0) Nej");

                int choice = getNextInt();

                switch(choice)
                {
                    case 1:
                    makeChoice = true;
                    break;

                    case 0:
                    makeChoice = true;
                    addingProducts = false;
                    break;

                    default:
                    System.out.println("Ukendt kommando prøv igen");
                    makeChoice = false;
                    break;

                }
            }

        }      

    }

    /**
     * Stars the process of adding a product to the current sale
     */
    private void addProductToSale()
    {
        System.out.println("Hvad er stregkoden?");
        String barcode = getNextWord();
        System.out.println("Hvor stort antal?");
        int quantity = getNextInt();
        saleController.addProductToSale(barcode, quantity);

        printCurrentSaleTotalPrice();
    }

    private void addCustomerToSale()
    {
        boolean addingCustomer = false;

        boolean makeChoice = false;      
        while(!makeChoice){

            System.out.println("Vil du tilføje en kunde til salget?");
            System.out.println(" (1) Ja");
            System.out.println(" (0) Nej");

            int choice = getNextInt();

            switch(choice)
            {
                case 1:
                makeChoice = true;
                addingCustomer = true;
                break;

                case 0:
                makeChoice = true;
                addingCustomer = false;
                break;

                default:
                System.out.println("Ukendt kommando prøv igen");
                makeChoice = false;
                break;

            }
        }

        if(addingCustomer){
            System.out.println("Hvad er kundenummeret?");
            String customerID = getNextWord();
            saleController.addCustomerToSale(customerID);    
        }
    }

    private void addDeliveryAddressToSale()
    {

        boolean addingDeliveryAddress = false;

        boolean makeChoice = false;      
        while(!makeChoice){

            System.out.println("Skal varene leveres?");
            System.out.println(" (1) Ja");
            System.out.println(" (0) Nej");

            int choice = getNextInt();

            switch(choice)
            {
                case 1:
                makeChoice = true;
                addingDeliveryAddress = true;
                break;

                case 0:
                makeChoice = true;
                addingDeliveryAddress = false;
                break;

                default:
                System.out.println("Ukendt kommando prøv igen");
                makeChoice = false;
                break;

            }
        }

        if(addingDeliveryAddress){
            System.out.println("Hvad er leverings adressen?");
            String address = getNextWord();
            saleController.addDeliveryAddressToSale(address);
        }
    }

    private void startPaymentTransaction()
    {
        
        System.out.println("Hvor meget betales der med?");
        double money = getNextDouble();
        saleController.pay(money);  
        
        
        
    }

    private void printCurrentSaleTotalPrice()
    {
        Sale currentSale = saleController.getCurrentSale();
        System.out.println("Pris: " + currentSale.calculateTotalPrice() + "DKK");
    }

    private void printCurrentSaleOverview()
    {
        Sale currentSale = saleController.getCurrentSale();
        
        //Prints all the products added to the sale
        SaleLineItem[] saleLineItems = currentSale.getSaleLineItems();

        for(SaleLineItem saleLine : saleLineItems){

            // Print Format
            // Skruer x 25
            //               50 Dkk
            // --------------------

            System.out.println(saleLine.getProduct().getName() + " x " + saleLine.getQuantity());
            System.out.println("               " + saleLine.calculateLinePrice() + " DKK");
            System.out.println("--------------------");

        }

        //prints the total price for the sale
        System.out.println("        Total: " + currentSale.calculateTotalPrice() + " DKK");
        System.out.println("--------------------");

        
        //prints the customer added to the sale if a customer has been added
        if(currentSale.getCustomer() != null){
            System.out.println("Tilknyttet kundenummer: " + currentSale.getCustomer().getCustomerID());
            System.out.println("Kunde navn: " + currentSale.getCustomer().getName());
            System.out.println("--------------------");
        }

        //prints the delivery address for the sale if its being delivered
        if(currentSale.getDeliveryAddress().isBlank()){
            System.out.println("Leveres til: " + currentSale.getDeliveryAddress());
        }
    }

}
