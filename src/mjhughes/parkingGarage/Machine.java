package mjhughes.parkingGarage;

public interface Machine {

    /**
     * runMachine
     * @param ticket Ticket
     * @return boolean
     */
    boolean runMachine(Ticket ticket);

    /**
     * display Greeting
     * @param greeting String greeting or business name
     */
    void displayGreeting(String greeting);

    /**
     * displayMenu
     * @param menu string array
     */
    void displayMenu(String[] menu);

}
