package mjhughes.parkingGarage;

import java.util.Scanner;

/**
 * OutMachineScreen
 */
public class OutMachineScreen extends MachineScreen {
    private String resp;
    Scanner kb = new Scanner(System.in);
    private String greeting="";
    private String[] menu = {"1 - Check-Out", "2 - Lost Ticket"};

    /**
     * OutMachineScreen constructor
     * @param greeting string greeting or business name
     */
    OutMachineScreen(String greeting){
        this.greeting=greeting;
    }

    /**
     * runmachine
     * @param ticket Ticket
     * @return boolean
     */
    @Override
    public boolean runMachine(Ticket ticket) {
        // Bypass if this is a special event.
        if (ticket.getFeeType().equals("S")) {
            return false;
        }
        boolean done=false;
        // Loop until valid user input
        while (!done) {
            // Display greeting and menu
            displayGreeting(greeting);
            displayMenu(menu);
            // Get and process response
            switch (getResponse()){
                case "1":
                    // Check out with MinMax or Special Event
                    ticket.setTimeOut(DateUtilitiesMhughes21.getCheckoutTime());
                    done=true;
                    break;
                case "2":
                    // Check out with Lost Ticket
                    ticket.setFeeType("L");
                    done=true;
                    break;
                default:
                    // Invalid response
                    System.out.println("Please enter 1 or 2.");
                    break;
            }

        }
        return false;
    }

    /**
     * getResponse
     * @return string
     */
    public  String getResponse() {
        return kb.nextLine();
    }
}
