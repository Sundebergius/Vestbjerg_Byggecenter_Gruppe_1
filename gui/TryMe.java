package gui;

import control.*;
import model.*;

/**
 * Write a description of class TryMe here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public class TryMe {
	// instance variables
	private SaleContainer saleContainer;
	private PersonContainer personContainer;
	private ProductContainer productContainer;

	/**
	 * Constructor for objects of class TryMe
	 */
	public TryMe() {
		saleContainer = SaleContainer.getInstance();
		personContainer = PersonContainer.getInstance();
		productContainer = ProductContainer.getInstance();

		addCustomers();
		addEmployee();
		addProducts();
	}

	private void addProducts() {
		
		//ColiProducts
		
		Product screws = new ColiProduct("skruepakke001", "Phillips skruer", "En æske med 200 phillips skruer", 60);
		productContainer.addProduct(screws);

		Product screws1 = new ColiProduct("skruepakke002", "Torx skruer", "En æske med 60 torx skruer", 30);
		productContainer.addProduct(screws1);
		
		Product screwProduct = new ColiProduct("skrue001", "Phillips skrue", "En enkelt phillips skrue", 0.3);
		productContainer.addProduct(screwProduct);

		Product cabinetDoorProduct = new ColiProduct("skabslåge001", "Køkkenlåge", "En solid mahogni køkken låge", 100);
		productContainer.addProduct(cabinetDoorProduct);

		Product cabinetHingeProduct = new ColiProduct("skabshængsel001", "Skabshængsel", "Et guldbelagt skabshængsel", 30);
		productContainer.addProduct(cabinetHingeProduct);

		Product cabinetSidePanelProduct = new ColiProduct("skabspanel001", "Skabspanel", "Et skabspanel af mahogni ", 50);
		productContainer.addProduct(cabinetSidePanelProduct);

		Product cabinetShelfProduct = new ColiProduct("skabshylde001", "Skabshylde", "En skabshylde af mahogni", 40);
		productContainer.addProduct(cabinetShelfProduct);

		Product cabinetHandleProduct = new ColiProduct("skabshåndtag001", "Skabshåndtag", "Et guldbelagt skabshåndtag", 50);
		productContainer.addProduct(cabinetHandleProduct);
		
		//SpecificProduct
		
		SpecificProduct wife = new SpecificProduct("opvaskemaskine001", "Opvaskemaskine", "En helt ny opvaskemaskine", 599.95);
		productContainer.addProduct(wife);
		wife.addCopy("1");
		wife.addCopy("2");
		wife.addCopy("3");
		
		
		//wife.addCopy("1");
		
		
		//CompositeProducts
		
		CompositeProduct cabinetSetProduct = new CompositeProduct("skabssæt001", "Køkkenskabssæt", "Et lækkert samle selv køkkenskab af mahogni træ");
		productContainer.addProduct(cabinetSetProduct);
		
		CompositeProduct cabinetShelfSetProduct = new CompositeProduct("skabshyldesæt001", "Skabshyldesæt", "En skabshylde af mahogni med 4 skruer");
		productContainer.addProduct(cabinetShelfSetProduct);
		
		CompositeProduct cabinetPanelSetProduct = new CompositeProduct("skabspanelsæt001", "Skabspanelsæt", "Et skabspanel af mahogni med 4 skruer");
		productContainer.addProduct(cabinetPanelSetProduct);
		
		CompositeProduct cabinetDoorSetProduct = new CompositeProduct("skabslågesæt001", "Skabslågesæt", "En skabslåge med 2 hængsler og tilhørende skruer");
		productContainer.addProduct(cabinetDoorSetProduct);
		
		CompositeProduct cabinetHingeSetProduct = new CompositeProduct("skabshængselset001", "Skabshængselsæt", "Et hængsel med 2 skruer");
		productContainer.addProduct(cabinetHingeSetProduct);
		
		CompositeProduct cabinetHandleSetProduct = new CompositeProduct("skabshåndtagsæt001", "Skabshåndtagsæt", "et håndtag med 2 skruer");
		productContainer.addProduct(cabinetHandleSetProduct);
		
		cabinetHandleSetProduct.addProductToComposite(1, cabinetHandleProduct);
		cabinetHandleSetProduct.addProductToComposite(2, screwProduct);
		
		cabinetHingeSetProduct.addProductToComposite(1, cabinetHingeProduct);
		cabinetHingeSetProduct.addProductToComposite(2, screwProduct);
		
		cabinetDoorSetProduct.addProductToComposite(1, cabinetDoorProduct);
		cabinetDoorSetProduct.addProductToComposite(1, cabinetHandleProduct);
		cabinetDoorSetProduct.addProductToComposite(2, cabinetHingeProduct);
		
		cabinetPanelSetProduct.addProductToComposite(1, cabinetSidePanelProduct);
		cabinetPanelSetProduct.addProductToComposite(4, screwProduct);
		
		cabinetShelfSetProduct.addProductToComposite(1, cabinetShelfProduct);
		cabinetShelfSetProduct.addProductToComposite(4, screwProduct);
		
		cabinetSetProduct.addProductToComposite(1, cabinetDoorSetProduct);
		cabinetSetProduct.addProductToComposite(3, cabinetPanelSetProduct);
		cabinetSetProduct.addProductToComposite(3, cabinetShelfSetProduct);
		

	}

	

	private void addCustomers() {
		Customer jensPetersen = new Customer("Privat001", 0.05, "Jens Petersen", "Sankt Peter vej 5", 9000, "Aalborg",
				"+4542069420");

		personContainer.addCustomer(jensPetersen);
	}

	private void addEmployee() {
		Employee kurtKristensen = new Employee("SalgsAss001", "Salgsassistent", "Kurt Kristensen", "Jernbanegade 5",
				9000, "Aalborg", "+4500000001");

		personContainer.addEmployee(kurtKristensen);
	}


}
