package mjhughes.parkingGarage;

import java.util.Scanner;

/**
 * part of the FACTORY PATTERN
 * Machine class
 */
public abstract class MachineScreen implements Machine {
    String resp = null;
    Scanner kb=null;
    String [] menu=null;

    /**
     * runMachine
     * @param ticket Ticket
     * @return boolean
     */
    public abstract boolean runMachine(Ticket ticket);

    /**
     * display Greeting
     * @param greeting String greeting or business name
     */
    public void displayGreeting(String greeting) {
        System.out.println(greeting);
        System.out.println(new String(new char[(greeting.length())]). replace("\0", "=") );
    }

    /**
     * displayMenu
     * @param menu string array
     */
    public void displayMenu(String[] menu) {
        for (int i=0; i<menu.length; i++)
        {
            System.out.println();
            System.out.println(menu[i]);
        }
        System.out.println("");
        System.out.print("=> ");
    }

}
