import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void givenDateRangeShouldReturnTheCheapestBestRatedHotelforRewardCustomer() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(200, obj.findCheapestHotel("2020-09-11", "2020-09-12"));
    }

    @Test
    public void givenDateShouldReturnTrueIfDateIsValid() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertTrue(obj.isDateValid("2020-09-11", "2020-09-12"));
    }
}