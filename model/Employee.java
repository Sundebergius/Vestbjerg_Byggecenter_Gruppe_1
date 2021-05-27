package model;


/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee extends Person
{
    private String employeeID;
    private String type;
    

    /**
     * Constructor for objects of class Employee
     */

    public Employee(String EmployeeID, String type,String name, String address, int postalCode, String city, String mobileNo)

    {
        // Initializes instance variables

        super(name,address,postalCode,city,mobileNo);
        this.employeeID = EmployeeID;
        this.type = type;        
    }
    
    public String getEmployeeID()
    {
        return employeeID;
    }
    
    public String getEmployeeType()
    {
        return type;
    }

 }
