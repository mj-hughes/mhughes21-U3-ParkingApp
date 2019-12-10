package mjhughes.parkingGarage;

import java.util.Scanner;

/**
 * InMachineScreen
 */
public class InMachineScreen extends MachineScreen {
    private String resp;
    Scanner kb = new Scanner(System.in);
    private String greeting="";
    private String[] menu= {"1 - Check-In", "2 - Special Event", "3 - Close Garage"};

    /**
     * InMachineScreen constructor
     * @param greeting String greeting or business name
     */
    InMachineScreen(String greeting){
        this.greeting=greeting;
    }

    /**
     * runMachine
     * @param ticket Ticket
     * @return boolean
     */
    @Override
    public boolean runMachine(Ticket ticket) {
        boolean close=false;
        boolean done=false;
        while (!done) {
            // Loop until user gives proper input
            // Display greeting and menu
            displayGreeting(greeting);
            displayMenu(menu);
            // Get and process response
            switch (getResponse()){
                case "1":
                    // Check in with MinMax
                    ticket.setTimeIn(DateUtilitiesMhughes21.getCheckinTime());
                    ticket.setFeeType("M");
                    done=true;
                    break;
                case "2":
                    // Check in with Special Event
                    ticket.setFeeType("S");
                    done=true;
                    break;
                case "3":
                    // Close garage
                    close=true;
                    done=true;
                    break;
                default:
                    // Invalid response
                    System.out.println("Please enter 1, 2, or 3.");
                    break;
            }

        }
        return close;
    }

    /**
     * getResponse
     * @return String
     */
    public String getResponse() {
        return kb.nextLine();
    }
}
