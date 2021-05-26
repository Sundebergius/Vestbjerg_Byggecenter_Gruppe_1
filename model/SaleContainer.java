package model;
import java.util.HashMap;


/**
 * Write a description of class SaleContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
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

    public static SaleContainer getInstance()
    {
        // Singleton
        if(instance == null) {
            instance = new SaleContainer();
        }
        return instance;
    }
    
    public void addSale(String saleID, Sale sale)
    { 
        // adds a sale to HashMap
        saleContainer.put(saleID, sale);
    }
}
