package gui;
import control.*;
import model.*;


/**
 * Write a description of class TryMe here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public class TryMe
{
    // instance variables
    private SaleContainer saleContainer;
    private PersonContainer personContainer;
    private ProductContainer productContainer;
    

    /**
     * Constructor for objects of class TryMe
     */
    public TryMe()
    {
        saleContainer = SaleContainer.getInstance();
        personContainer = PersonContainer.getInstance();
        productContainer = ProductContainer.getInstance();
                
        addCustomers();
        addEmployee();
        addProducts();        
    }
    
    /*
     * Method that adds a product to the product container
     */
    private void addProducts()
    {        
        Product screws = new ColiProduct("Skrue001", "Phillips skruer", "En æske med 200 phillips skruer", 60);
        productContainer.addProduct(screws);
        
        Product screws1 = new ColiProduct("Skrue002", "Torx skruer", "En æske med 60 torx skruer", 30);
        productContainer.addProduct(screws1);                 
    }
    
    private void addCompositeProduct() {
    	
    }
    
    /*
     * Method that adds a customer to the person container
     */
    private void addCustomers()
    {
        Customer jensPetersen = new Customer("Privat001", 0.05, "Jens Petersen", "Sankt Peter vej 5", 9000, "Aalborg", "+4542069420");
        
        personContainer.addCustomer(jensPetersen);              
    }
    /*
     * Method that adds an employee to the person container
     */
    private void addEmployee()
    {
        Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent", "Kurt Kristensen", "Jernbanegade 5", 9000, "Aalborg", "+4500000001");
        
        personContainer.addEmployee(kurtKristensen);
    }

}
