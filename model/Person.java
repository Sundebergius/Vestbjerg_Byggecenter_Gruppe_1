package model;


/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    public String getName(){
        return name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public int getPostalCode(){
        return postalCode;        
    }
    
    public String getCity(){
        return city;   
    }
    
    public String getMobileNo(){
        return mobileNo;
    }
}
