package tui;
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
        
        
        
        
    }

}
