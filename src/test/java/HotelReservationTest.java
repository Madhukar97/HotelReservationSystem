import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRate() {
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        Assert.assertEquals(370, obj.findBestRatedHotel("2020-09-11", "2020-09-12"));
    }
}