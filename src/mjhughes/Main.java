package mjhughes;

import mjhughes.parkingGarage.GarageBusiness;

public class Main {

    /**
     * main - driver class
     * @param args - string array
     */
    public static void main(String[] args) {
        // Get the garage. While it's open, process a single vehicle at a time.
        GarageBusiness garage = GarageBusiness.getInstance();
        while (garage.isOpen()) {
            garage.processVehicle();
        }

    }
}
