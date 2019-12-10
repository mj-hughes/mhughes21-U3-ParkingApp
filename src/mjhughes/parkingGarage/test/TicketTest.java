package mjhughes.parkingGarage.test;

import mjhughes.parkingGarage.DateUtilitiesMhughes21;
import mjhughes.parkingGarage.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {
    private Ticket t=null;

    @Before
    public void setUp() throws Exception {
        t = new Ticket(DateUtilitiesMhughes21.getCheckinTime(),
                DateUtilitiesMhughes21.getCheckoutTime(), 1, "M");

    }

    @Test
    public void testGetTimeIn() {
        assertNotNull(t.getTimeIn());
    }

    @Test
    public void testGetTimeOut() {
        assertNotNull(t.getTimeOut());
    }

    @Test
    public void testGetTicketNum() {
        assertNotNull(t.getTicketNum());
    }

    @Test
    public void testGetFeeType() {
        assertNotNull(t.getFeeType());
    }

}