package mjhughes.parkingGarage.services;

import mjhughes.parkingGarage.Ticket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class InputTicketHistoryByFile implements InputTicketHistory {
    private static String fileName="ticketFile.txt";
    /**
     * getTicketHistory - reads in the history from file
     */
    public List<Ticket> getTicketHistory() {
        List<Ticket> tickets = new ArrayList<>();
        int lastTicketNumUsed=0;

        // Test if file exists
        File test = new File (fileName);
        if (test.exists())
        {
            // Open the saved tickets file
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }


            Object obj = null;
            try{
                // Read an object. If no input stream, this will error out
                while ((obj=ois.readObject()) != null) {
                    if (obj instanceof Ticket)
                    {
                        // Cast it to the Ticket type
                        Ticket thisTicket = (Ticket) obj;
                        // Add it to the list
                        tickets.add(thisTicket);
                        if (thisTicket.getTicketNum()>lastTicketNumUsed) {
                            lastTicketNumUsed=thisTicket.getTicketNum();
                            thisTicket.setTicketNum(lastTicketNumUsed);
                        }
                    }
                }
            } catch (Exception e) {
                // e.printStackTrace();
                // System.out.println("Problem "+e.getMessage()); this will catch end of file, too.
            } finally {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Tickets successfully read");
                System.out.println("Vehicle ID successfully read");
                System.out.println();

            }
        } else {
            System.out.println("No existing tickets");
            System.out.println("Starting Vehicle ID at 1");
            System.out.println();
        }

        return tickets;
    }


}
