package mjhughes.parkingGarage;

/**
 * part of the FACTORY PATTERN
 * MachineFactory
 */
public interface MachineFactory {

    /**
     * getMachine
     * @param machineType string
     * @return
     */
    MachineScreen getMachine(String machineType);

    /**
     * getGarageName
     * @return string
     */
    public String getGarageName();

    /**
     * setGarageName
     * @param garageName string
     */
    public void setGarageName(String garageName);

}
