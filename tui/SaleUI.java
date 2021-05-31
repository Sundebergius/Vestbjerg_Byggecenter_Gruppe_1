package tui;
import control.SaleController; 
import model.Sale;
import model.SaleLineItem;
import model.Product;
import model.Employee;

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
    private Employee currentEmployee;

    /**
     * Constructor for objects of class SaleUI
     */
    public SaleUI(Employee currentEmployee)
    {
        this.currentEmployee = currentEmployee;
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

        while(saleController.getCurrentSale() != null){

            printCurrentSaleOverview();

            boolean makeChoice = false;

            while(!makeChoice){

                System.out.println("Er informationen korrekt?");
                System.out.println(" (1) Tilføj flere varer");
                System.out.println(" (2) Fjern varer");
                System.out.println(" (3) Ændre kundenummer");
                System.out.println(" (4) Ændre leveringsadresse");
                System.out.println(" (5) Start betalingstransaktion");
                System.out.println(" (0) Annuller salg");

                int choice = getNextInt();

                switch(choice)
                {
                    case 1:
                    makeChoice = true;
                    addProductsLoop();
                    break;

                    case 2:
                    makeChoice = false;
                    System.out.println("not Implemented");
                    // needs to be implemented
                    break;
                    
                    case 3:
                    makeChoice = true;
                    addCustomerToSale();
                    break;
                    
                    case 4:
                    makeChoice = true;
                    addDeliveryAddressToSale();
                    break;
                    
                    case 5:
                    makeChoice = true;
                    startPaymentTransaction();

                    case 0:
                    makeChoice = true;                    
                    saleController.cancelSale();
                    break;

                    default:
                    System.out.println("Ukendt kommando prøv igen");
                    makeChoice = false;
                    break;

                }
            }
        }
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
        saleController.createSale(currentEmployee);   
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
        double remainingPayment;        
        boolean canceledTransaction = false;

        //while loop is made as do-while loop to make sure at least 1 transaction happens
        //remainingPayment starts as 0 and would therefor not satisfy the while loops conditions
        do{
               
            System.out.println("Hvor meget betales der med?");
            double money = getNextDouble();
            remainingPayment = saleController.pay(money); 

            boolean makeChoice = false;      
            while(!makeChoice){

                System.out.println("Skal transaktionen annulleres?");
                System.out.println(" (1) Ja");
                System.out.println(" (0) Nej");

                int choice = getNextInt();

                switch(choice)
                {
                    case 1:
                    makeChoice = true;
                    canceledTransaction = true;
                    break;

                    case 0:
                    makeChoice = true;
                    canceledTransaction = false;

                    break;

                    default:
                    System.out.println("Ukendt kommando prøv igen");
                    makeChoice = false;
                    break;

                }
            }
            
            if(remainingPayment > 0 && !canceledTransaction){
                System.out.println("Du mangler at betale: " + remainingPayment + " DKK");   
            }

            
        }while(remainingPayment > 0 && !canceledTransaction);

        if(remainingPayment <= 0){
            saleController.setCurrentSaleID();
            printReceipt();
            logFinishedSale();
        }
    }

    private void logFinishedSale(){
        saleController.logSale();
    }

    private void printReceipt(){
        System.out.println(" \f");
        printCurrentSaleOverview();
        Sale currentSale = saleController.getCurrentSale();
        System.out.println("Beløb modtaget: " + currentSale.getMoneyReceived());
        System.out.println("Retur beløb: " + (-currentSale.getRemainingPayment()));
        System.out.println("SalgsID: " + currentSale.getSaleID());
        System.out.println();

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
        if(!currentSale.getDeliveryAddress().isBlank()){
            System.out.println("Leveres til: " + currentSale.getDeliveryAddress());
            System.out.println("--------------------");
        }

        System.out.println("Betjent af: " + currentSale.getEmployee().getName());
        System.out.println("--------------------");
    }

}
