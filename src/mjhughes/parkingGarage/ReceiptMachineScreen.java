package mjhughes.parkingGarage;

/**
 * ReceiptMachineScreen
 */
public class ReceiptMachineScreen extends MachineScreen {
    private String greeting="";
    private String[] menu= {"Receipt for vehicle id ", "", "$"};

    /**
     * ReceiptMachineScreen constructor
     * @param greeting string greeting or business name
     */
    ReceiptMachineScreen(String greeting){
        this.greeting=greeting;
    }

    /**
     * runMachine
     * @param ticket Ticket
     * @return boolean
     */
    @Override
    public boolean runMachine(Ticket ticket) {
        // No user input required. Display greeting.
        displayGreeting(greeting);
        // Use fee type from ticket to output receipt information
        menu[0]+=ticket.getTicketNum();
        switch (ticket.getFeeType()) {
            case "M":
                menu[1]=Integer.toString(DateUtilitiesMhughes21.calcStay(ticket.getTimeIn(), ticket.getTimeOut())) +
                        " hours parked "+DateUtilitiesMhughes21.formatDate(ticket.getTimeIn())+
                        " - "+
                        DateUtilitiesMhughes21.formatDate(ticket.getTimeOut());
                break;
            case "L":
                menu[1]="Lost Ticket";
                break;
            case "S":
                menu[1]="Special Event";
                break;
        }
        menu[2]+=String.format("%.2f",ticket.getFee());
        displayMenu(menu);

        return false;
    }

}
