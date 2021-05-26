package tui;


import java.util.Scanner;

/**
 * Abstract class SubMenu - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Menu
{
    
    public abstract void doUI();
    
    public int getNextInt(){
        int inputInt = 0;
        Scanner input = new Scanner(System.in);
        
        while(!input.hasNextInt()){
            System.out.print("\f");
            System.out.println("Input skal være et tal");
            input.nextLine();
        }
        
        System.out.print("\f");
        
        inputInt = input.nextInt();
        
        System.out.println(inputInt);
        
        return inputInt;
    }
    
    public String getNextWord(){
        String inputString = null;
        Scanner input = new Scanner(System.in);
        
        Scanner tokenizer = new Scanner(input.nextLine());
        
        if(tokenizer.hasNext()) {
            inputString = tokenizer.next();
        }        
        
        System.out.print("\f");
        
        System.out.println(inputString);
               
        return inputString;
    }
    
    
}
