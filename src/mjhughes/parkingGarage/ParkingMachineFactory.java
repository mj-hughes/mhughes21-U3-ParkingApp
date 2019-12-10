package mjhughes.parkingGarage;

/**
 * ParkingMachineFactory
 */
public class ParkingMachineFactory implements MachineFactory {
    private String garageName="";

    /**
     * getMachine
     * @param machineType string
     * @return Machine
     */
    @Override
    public MachineScreen getMachine(String machineType) {
        // NOTE: Breaks are not required in this switch-case statement because they're unreachable after the return statement.
        // return a machine of the type requested
        switch (machineType) {
            case "in":
                return new InMachineScreen(garageName);
            case "out":
                return new OutMachineScreen(garageName);
            case "receipt":
                return new ReceiptMachineScreen(garageName);
            default:
                return null;
        }
    }

    /**
     * getGarageName
     * @return string
     */
    public String getGarageName() {
        return garageName;
    }

    /**
     * setGarageName
     * @param garageName string
     */
    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
}
