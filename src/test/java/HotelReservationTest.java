import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest extends TestCase {

    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(3, obj.hotelReservation.size());
    }

    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRate() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(220, obj.findCheapestHotel("2020-09-10", "2020-09-11"));
    }
}