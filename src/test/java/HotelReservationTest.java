import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class HotelReservationTest extends TestCase {

    Map<String, Hotel> hotelReservation = new HashMap<>();


    public void testAddHotel() {

        HotelReservation obj = new HotelReservation();
        Hotel obj1 = new Hotel();
        Hotel obj2 = new Hotel();
        hotelReservation.put("Lakewood",obj1);
        hotelReservation.put("Bridgewood",obj2);
        obj1.setHotelName("Lakewood");
        obj1.setRate(100);
        obj2.setHotelName("Bridgewood");
        obj2.setRate(40);
        int cheapestRate = obj2.getRate()*2;
        Assert.assertEquals(80,cheapestRate);
    }

}