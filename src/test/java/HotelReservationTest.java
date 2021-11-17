import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void givenDateRangeShouldReturnTheCheapestBestRatedHotelforRewardCustomer() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(140, obj.findCheapestHotelForRewardCustomer("2020-09-11", "2020-09-12"));
    }

}