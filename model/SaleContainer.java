package model;
import java.util.HashMap;


/**
 * Storing sales that has been made
 */
public class SaleContainer
{
    // instance variables - replace the example below with your own
    private static SaleContainer instance;
    private HashMap<String, Sale> saleContainer;

    /**
     * Constructor for objects of class SaleContainer
     */
    public SaleContainer()
    {
         saleContainer = new HashMap<>(); 
    }
    
    /**
     * Get the current instance of sale container
     * if not, create one
     * @return instance
     */
    public static SaleContainer getInstance()
    {
        // Singleton
        if(instance == null) {
            instance = new SaleContainer();
        }
        return instance;
    }
    
    /**
     * Method adding a sale the to sale container using the sales ID as the key
     * @param sale the sale to be added to the container
     */
    public void addSale(Sale sale)
    { 
        // adds a sale to HashMap
        saleContainer.put(sale.getSaleID(), sale);
    }
    
    /**
     * Method for getting a new unique saleID
     * @return saleID
     */
    public String getNewSaleID(){
        String saleID;
        
        saleID = "" + saleContainer.size();
        
        return saleID;
    }
    
    public int getSize(){
        
        return saleContainer.size();
    }
}
