import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest extends TestCase {

    @Test
    public void whenGivenHotel1NameTheHotelObjShouldBeAddedToHashMap() {
        Hotel obj = new Hotel();
        obj.setHotelName("Lakewood");
        Assert.assertEquals("Lakewood", obj.getHotelName());
    }

    @Test
    public void whenGivenHotel2NameTheHotelObjShouldBeAddedToHashMap() {
        Hotel obj = new Hotel();
        obj.setHotelName("Bridgewood");
        Assert.assertEquals("Bridgewood", obj.getHotelName());
    }

    @Test
    public void whenGivenHotel3NameTheHotelObjShouldBeAddedToHashMap() {
        Hotel obj = new Hotel();
        obj.setHotelName("Ridgewood");
        Assert.assertEquals("Ridgewood", obj.getHotelName());
    }

}