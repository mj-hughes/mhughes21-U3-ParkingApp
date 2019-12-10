package mjhughes.parkingGarage;

import mjhughes.parkingGarage.services.InputTicketHistory;
import mjhughes.parkingGarage.services.InputTicketHistoryByFile;
import mjhughes.parkingGarage.services.OutputTicketHistory;
import mjhughes.parkingGarage.services.OutputTicketHistoryByFile;

import java.util.List;

/**
 * Contains all startup configuration information
 *  Only the configuration info in this Startup class needs modification to change fee strategies –
 *  no other part of the program should need source code changes.
 */
public class GarageBusiness {
    private String garageName="Best Value Parking Garage";
    private String fileName="ticketFile.txt";
    private boolean open=true;
    private final double SPECIAL_FEE=20.00;
    private final double LOST_FEE=25.00;
    private final double HOURLY_FEE=1.00;
    private final double MIN_FEE=5.00;
    private final double MAX_FEE=15.00;
    private final int MIN_HOURS=3;
    private List<Ticket> tickets = null;
    private FeeStrategy feeStrategy=null;
    MachineFactory machineFactory=null;
    InputTicketHistory inputTicketHistory = new InputTicketHistoryByFile();
    OutputTicketHistory outputTicketHistory = new OutputTicketHistoryByFile();

    /**
     * SINGLETON PATTERN
     * GarageBusiness - instance
     */
    private static GarageBusiness instance = new GarageBusiness();

    /**
     * getInstance thread-safe get instance
     * @return GarageBusiness
     */
    public synchronized static GarageBusiness getInstance() {
        if (instance==null)  {
            instance=new GarageBusiness();
        }
        return instance;
    }

    /**
     * GarageBusiness private constructor
     */
    private GarageBusiness() {
        this.garageName = garageName;

        machineFactory=new ParkingMachineFactory();
        machineFactory.setGarageName(garageName);

        // Load tickets from file
        tickets = inputTicketHistory.getTicketHistory();
    }

    /**
     * isOpen
     * @return boolean garage is open or not
     */
    public boolean isOpen(){
        return open;
    }

    /**
     * setOpen
     * @param open boolean
     */
    public void setOpen(boolean open) {
        this.open=open;
    }

    /**
     * processVehicle
     */
    public void processVehicle() {
        // Check car in
        MachineScreen inMachine=machineFactory.getMachine("in");
        Ticket ticket = new Ticket();
        boolean close=inMachine.runMachine(ticket);
        // User has selected close or a parking option
        if (!close) {
            // User selected a parking option

            // Then check the vehicle  out
            MachineScreen outMachine=machineFactory.getMachine("out");
            outMachine.runMachine(ticket);

            // Calculate fee
            ticket.setFee(getFeeAmount(ticket));

            // Add ticket to garage
            tickets.add(ticket);

            // Print receipt
            MachineScreen receiptMachine = machineFactory.getMachine("receipt");
            receiptMachine.runMachine(ticket);

        } else {
            // Close the garage
            this.setOpen(false);
            // Print summary
            CloseMachineScreen closeMachineScreen = new CloseMachineScreen(garageName);
            int[] sumFee={0,0,0};
            int[] sumNum={0,0,0};
            String[] feeTypes={"","",""};
            for (Ticket t:tickets) {
                switch (t.getFeeType()) {
                    case "M":
                        sumFee[0] += t.getFee();
                        sumNum[0]++;
                        feeTypes[0]="Check In(s)";
                        break;
                    case "S":
                        sumFee[1] += t.getFee();
                        sumNum[1]++;
                        feeTypes[1]="Special Event(s)";
                        break;
                    case "L":
                        sumFee[2] += t.getFee();
                        sumNum[2]++;
                        feeTypes[2]="Lost Ticket(s)";
                        break;
                }
            }
            closeMachineScreen.runSummary(sumFee, sumNum, feeTypes);
            // Output tickets
            outputTicketHistory.putTicketHistory(tickets);
        }
    }

    /**
     * setFeeStrategy
     * @param feeStrategy FeeStrategy
     */
    public void setFeeStrategy(FeeStrategy feeStrategy) {this.feeStrategy=feeStrategy; }

    /**
     * getFeeAmount
     * @param ticket Ticket
     * @return double calculated fee based on fee strategy
     */
    public double getFeeAmount(Ticket ticket) {
        double tempFee;
        switch (ticket.getFeeType()) {
            case "M":
                setFeeStrategy(new MinMaxFee(MIN_FEE, MAX_FEE, HOURLY_FEE, MIN_HOURS, DateUtilitiesMhughes21.calcStay(ticket.getTimeIn(), ticket.getTimeOut())));
                break;
            case "S":
                setFeeStrategy(new SpecialEventFee(SPECIAL_FEE));
                break;
            case "L":
                setFeeStrategy(new LostTicketFee(LOST_FEE));
                break;
        }
        tempFee=feeStrategy.calcFeeAmount();
        return tempFee;
    }


}
