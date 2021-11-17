
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

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

    @Test
    public void givenWeekDayWeekEndRatesShouldReturnThoseRates() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(90, obj.hotelReservation.get("Lakewood").getWeekendRate());
        Assert.assertEquals(50, obj.hotelReservation.get("Bridgewood").getWeekendRate());
        Assert.assertEquals(150, obj.hotelReservation.get("Ridgewood").getWeekendRate());
    }
}