package tui;
import java.util.Scanner;

/**
 * Write a description of class MainMenuUI here.
 *
 * @author Andreas Clement Holmgaard
 * @version (a version number or a date)
 */
public class MainMenuUI extends Menu
{


    /**
     * Constructor for objects of class MainMenuUI
     */
    public MainUI(){

    }

    public void start(){
        doUI();
    }

    public void doUI(){
        mainMenu();
    }

    private void mainMenu(){
        boolean running = true;

        while(running){
            printMainMenu();
            int choice = getNextInt();

            switch(choice){
                case 1:
                
                break;

                case 0:
                running = false;
                break;

                case 9:
                //new TryMe();
                System.out.println("Test data genereret");
                break;

                default:
                System.out.println("Ukendt kommando : " + choice + ".");
                break;
            }
        }

        System.out.println("Farvel.");

    }

    private void printMainMenu(){
        //System.out.print("\f");
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Sale menu");
        System.out.println(" (9) Generer testdata");// will generate testdata, delete in final version
        System.out.println(" (0) Afslut programmet");
        System.out.println(" Vælg:");
    }

}
