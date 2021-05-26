package control;
import model.SaleContainer;
import model.Sale;
import model.SaleLineItem;
import model.Product;
import model.Employee;
import model.Customer;

/**
 * Write a description of class SaleController here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public class SaleController
{
    // instance variables
    private SaleContainer saleContainer;
    private Sale currentSale; 
    private ProductController productController;
    private PersonController personController;
    
    public SaleController()
    {
        productController = new ProductController();
        personController = new PersonController(); 
        saleContainer = saleContainer.getInstance();
    }
    
    public Sale createSale()
    {
        Employee employee = personController.getCurrentEmployee();
        currentSale = new Sale(employee);
        return currentSale;
    }
    
    public Product addProductToSale(String barcode, int quantity)
    {
        Product product = productController.findProductByBarcode(barcode);
        SaleLineItem saleLineItem = new SaleLineItem(product, quantity);
        currentSale.addSaleLineItem(saleLineItem);
        return product;
    }
    
    public Customer addCustomerToSale(String customerID)
    {
        Customer customer = personController.findCustomerByCustomerID(customerID);
        currentSale.addCustomerToSale(customer);
        return customer;
    }
    
    public String addDeliveryAddressToSale(String address)
    {
        currentSale.addDeliveryAddressToSale(address);
        return address; 
    }
    
    public boolean pay(double money)
    {
        currentSale.pay(money);
        return true;
    }
}
