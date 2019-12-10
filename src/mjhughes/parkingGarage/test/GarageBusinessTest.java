package mjhughes.parkingGarage.test;

import mjhughes.parkingGarage.DateUtilitiesMhughes21;
import mjhughes.parkingGarage.GarageBusiness;
import mjhughes.parkingGarage.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GarageBusinessTest {
    private GarageBusiness gb = null;
    private Ticket t=null;

    @Before
    public void setUp() throws Exception {
        gb = GarageBusiness.getInstance();
        t = new Ticket(DateUtilitiesMhughes21.getCheckinTime(),
                DateUtilitiesMhughes21.getCheckoutTime(), 1, "M");

    }


    @Test
    public void testIsOpen() {
        assertTrue(gb.isOpen());
    }

    @Test
    public void testSetOpen() {
        gb.setOpen(false);
        assertFalse(gb.isOpen());
    }

    @Test
    public void testGetFeeAmount() {
        assertTrue(gb.getFeeAmount(t)>0);
    }
}