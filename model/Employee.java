package model;


/**
 * The employee class is for giving the created person a employeeID and a employee type
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
    
    /**
     * Method showing employeeID
     * @return showing employeeID
     */
    //Not implemented
    public String getEmployeeID()
    {
        return employeeID;
    }
    
    /**
     * Method showing employee type
     * @return showing the type of the employee
     */
    //Not implemented
    public String getEmployeeType()
    {
        return type;
    }

 }
