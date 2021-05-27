package model;


/**
 * The Person class is for makeing a person with some attributes, such as name,address, postal code, city 
 * and mobile number
 */
public class Person
{
    // instance variables 
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private String mobileNo;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name, String address, int postalCode, String city, String mobileNo)
    {
        // Initializes instance variables
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.mobileNo = mobileNo;
    
    }
    
    /**
     * Method to show the name from the created person
     * @return Showing the name of the person
     */
    public String getName(){
        return name;
    }
    
    /**
     * Method to show the address from the created person
     * @return Showing the address of the person
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Method to show the postal code from the created person
     * @return Showing the postal code of the person
     */
    public int getPostalCode(){
        return postalCode;        
    }
    
    /**
     * Method to show the city from the created person
     * @return Showing the city of the person
     */
    public String getCity(){
        return city;   
    }
    
    /**
     * Method to show the mobile number from the created person
     * @return Showing the mobile number of the person
     */
    public String getMobileNo(){
        return mobileNo;
    }
}
