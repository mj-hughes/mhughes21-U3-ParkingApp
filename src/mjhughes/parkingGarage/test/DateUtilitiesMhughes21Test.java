package mjhughes.parkingGarage.test;

import org.junit.Before;
import org.junit.Test;

import mjhughes.parkingGarage.DateUtilitiesMhughes21;
import static org.junit.Assert.*;

import java.time.LocalDateTime;


public class DateUtilitiesMhughes21Test {
    private LocalDateTime testDate;
    private LocalDateTime testEndDate;

    @Before
    public void setUp() {
        // Set test date/time to Dec 10, 2019 3:20:01 pm
        testDate = LocalDateTime.of(2019,12,10,15,20,01);
        // Set end date to 2 hours later
        testEndDate = LocalDateTime.of(2019, 12, 10, 17, 20, 01);
    }

    @Test
    public void testFormatDate() {
        assertEquals(DateUtilitiesMhughes21.formatDate(testDate), "03 PM");
    }

    @Test
    public void testCalcStay() {
        assertEquals(DateUtilitiesMhughes21.calcStay(testDate, testEndDate), 2);
    }

    @Test
    public void testGetStart() {
        DateUtilitiesMhughes21.setStart(testDate);
        assertEquals(DateUtilitiesMhughes21.getStart(), testDate);
    }

    @Test
    public void testGetEnd() {
        assertEquals(DateUtilitiesMhughes21.getEnd(), testEndDate);
    }

}