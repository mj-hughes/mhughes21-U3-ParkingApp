package mjhughes.parkingGarage.services;

import mjhughes.parkingGarage.Ticket;

import java.util.List;

public interface OutputTicketHistory {

    void putTicketHistory(List<Ticket> tickets);

}
