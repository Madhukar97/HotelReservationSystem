import java.util.HashMap;
import java.util.Map;

public class HotelReservation {

    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Reservation System");

        Map<String, Hotel> hotelReservation = new HashMap<>();
        Hotel Lakewood = new Hotel();
        Hotel Bridgewood = new Hotel();
        Hotel Ridgewood = new Hotel();

        hotelReservation.put("Lakewood", Lakewood);
        hotelReservation.put("Bridgewood", Bridgewood);
        hotelReservation.put("Ridgewood", Ridgewood);

    }
}

class Hotel {

    String hotelName;
    int rating;
    String dayType;
    int rate;
    String customer_type;


}