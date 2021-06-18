package control;

import model.SaleContainer;
import model.Sale;
import model.SaleLineItem;
import model.SpecificProduct;
import model.Product;
import model.Employee;
import model.CompositeProduct;
import model.Customer;

/**
 * Write a description of class SaleController here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public class SaleController {
	// instance variables
	private SaleContainer saleContainer;
	private Sale currentSale;
	private ProductController productController;
	private PersonController personController;

	public SaleController() {
		productController = new ProductController();
		personController = new PersonController();
		saleContainer = SaleContainer.getInstance();
	}

	public Sale createSale(Employee currentEmployee) {
		currentSale = new Sale(currentEmployee);
		return currentSale;
	}

	public void addProductToSale(String barcode, int quantity) {
		Product product = productController.findProductByBarcode(barcode);

		SaleLineItem saleLineItem = product.createSaleLine(quantity);

		currentSale.addSaleLineItem(saleLineItem);

	}

	public Customer addCustomerToSale(String customerID) {
		Customer customer = personController.findCustomerByCustomerID(customerID);
		currentSale.addCustomerToSale(customer);
		return customer;
	}

	public void removeCustomerFromSale() {
		currentSale.removeCustomer();
	}

	public String addDeliveryAddressToSale(String address) {
		currentSale.addDeliveryAddressToSale(address);
		return address;
	}

	public String addDeliveryNameToSale(String name) {
		currentSale.addDeliveryNameToSale(name);
		return name;
	}

	public int addPostalToSale(int postal) {
		currentSale.addDeliveryPostalToSale(postal);
		return postal;
	}

	public String addPhoneNumberToSale(String phoneNumber) {
		currentSale.addDeliveryPhoneNumber(phoneNumber);
		return phoneNumber;
	}

	public String addDeliveryCityToSale(String city) {
		currentSale.addDeliveryCity(city);
		return city;
	}

	public void removeDelivery() {
		currentSale.removeDeliveryFromSale();
	}

	public double pay(double money) {
		double remainingPayment = currentSale.pay(money);

		return remainingPayment;
	}

	public Sale getCurrentSale() {
		return currentSale;
	}

	public void cancelSale() {
		currentSale = null;
	}

	public void setCurrentSaleID() {
		String saleID = saleContainer.getNewSaleID();
		currentSale.setSaleID(saleID);
	}

	public void logSale() {
		saleContainer.addSale(currentSale);
		currentSale = null;
	}
	
	public void removeSaleLineItemsFromCurrentSale(int[] selectedIndices) {
		
		for (int i = selectedIndices.length - 1; i >= 0; i--) {
			currentSale.removeSaleLineItem(selectedIndices[i]);
		}
	}

}
