package tui;
import control.PersonController;
import model.Employee;

/**
 * Write a description of class MainMenuUI here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public class MainMenuUI extends Menu
{
    private SaleUI saleUI;
    private Employee currentEmployee;
    private PersonController personController;

    /**
     * Constructor for objects of class MainMenuUI
     */
    public MainMenuUI(){
        personController = new PersonController();
    }

    public void doUI(){
        loginMenu();
    }

    private void mainMenu(){
        boolean running = true;

        while(running){
            printMainMenu();
            int choice = getNextInt();

            switch(choice){
                case 1:
                saleUI.doUI();
                break;

                case 0:
                running = false;
                break;

                default:
                System.out.println("Ukendt kommando : " + choice + ".");
                break;
            }
        }

        System.out.println("Du er nu logget ud.");

    }

    private void loginMenu(){

        boolean running = true;

        while(running){
            printLoginMenu();
            int choice = getNextInt();

            switch(choice){
                case 1:
                login();
                saleUI = new SaleUI(currentEmployee);
                mainMenu();
                break;

                case 0:
                running = false;
                break;

                case 9:
                new TryMe();
                System.out.println("Test data genereret");
                break;

                default:
                System.out.println("Ukendt kommando : " + choice + ".");
                break;
            }
        }

        System.out.println("Farvel.");

    }

    private void login(){

        System.out.println("Velkommen til Vestbjerg Byggecenters System");

        while(currentEmployee == null) {
            System.out.println("Indtast dit Medarbejdernummer");
            String employeeID = getNextWord();
            try{
                currentEmployee = personController.getEmployeeByEmployeeID(employeeID);
            }catch(NullPointerException e){
                System.out.println("fejl medarbejder blev ikke fundet prøv igen");
            }
        }
    }

    private void printMainMenu(){
        //System.out.print("\f");
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Salgs menu");
        System.out.println(" (0) Log ud");
        System.out.println(" Vælg:");
    }

    private void printLoginMenu(){
        //System.out.print("\f");
        System.out.println("****** Loginmenu ******");
        System.out.println(" (1) Login");
        System.out.println(" (9) Generer testdata");
        System.out.println(" (0) Afslut Program");
        System.out.println(" Vælg:");
    }

}
