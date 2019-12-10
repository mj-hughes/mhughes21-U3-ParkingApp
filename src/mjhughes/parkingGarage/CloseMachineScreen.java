package mjhughes.parkingGarage;

/**
 * CloseMachineScreen - implements porking lot Machine interface with a computer screen output
 */
public class CloseMachineScreen {
    private String greeting="";
    private String[] menu = null;

    /**
     * CloseMachineScreen constructor
     * @param greeting String with greeting or business name
     */
    CloseMachineScreen(String greeting){
        this.greeting=greeting;
    }

    /**
     * displayMenu -- display menu to computer screen
     * @param menu
     */
    public void displayMenu(String[] menu) {
        for (int i=0; i<menu.length; i++)
        {
            System.out.println(menu[i]);
        }
        System.out.println("");
    }

    /**
     * runSummary - produce garage summary information
     * @param sumFees integer array of fee sums per fee type
     * @param sumNums integer array of # of tickets per fee type
     * @param feeTypes string array of ticket fee types
     */
    public void runSummary(int[] sumFees, int[] sumNums, String[] feeTypes) {
        menu=new String[sumFees.length+6];
        menu[0]=greeting;
        menu[1]=new String(new char[(greeting.length())]). replace("\0", "=");
        menu[2]="Activity to Date";
        menu[3]="";
        int totalDollars=0;
        for (int i=0; i<sumFees.length; i++) {
            menu[i+4]= String.format("$%d was collected from %d %s",sumFees[i], sumNums[i], feeTypes[i]);
            totalDollars+=sumFees[i];
        }
        menu[7]="";
        menu[8]=String.format("$%d was collected overall", totalDollars);
        displayMenu(menu);
    }

}
