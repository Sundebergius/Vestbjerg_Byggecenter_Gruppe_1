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
    public Person(String newName, String newAddress, int newPostalCode, String newCity, String newMobileNo)
    {
        // Initializes instance variables
        this.name = newName;
        this.address = newAddress;
        this.postalCode = newPostalCode;
        this.city = newCity;
        this.mobileNo = newMobileNo;
    
    }
}
