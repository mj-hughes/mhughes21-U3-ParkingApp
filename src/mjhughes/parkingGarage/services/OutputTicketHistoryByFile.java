package mjhughes.parkingGarage.services;

import mjhughes.parkingGarage.Ticket;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class OutputTicketHistoryByFile implements OutputTicketHistory {
    private static String fileName="ticketFile.txt";

    /**
     * putTicketHistory
     * on close, write out the ticket history to a file
     */
    public void putTicketHistory(List<Ticket> tickets) {
        try {
            ObjectOutputStream objectOut= new ObjectOutputStream( new FileOutputStream(fileName));
            //Loop through ticket list and write out each one
            for (Ticket t: tickets) {
                objectOut.writeObject(t);
            }
            objectOut.close();
            System.out.println("Tickets successfully written");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
