import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRate() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(80, obj.hotelReservation.get("Lakewood").getSpecialWeekdayRate());
    }
}