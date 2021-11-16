import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelReservation {

    Map<String, Hotel> hotelReservation = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservation obj = new HotelReservation();
        obj.addHotel();

    }

    /**
     * Method for adding Hotel to the HotelReservationSystem
     */
    public void addHotel(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to enter a hotel and 2 to exit");
            int option = sc.nextInt();
            if (option==1){
                Hotel hotelObj = new Hotel();
                System.out.println("Enter the name of hotel");
                String name = sc.next();
                hotelObj.setHotelName(name);
                hotelReservation.put(name,hotelObj);
            }
            if (option==2){
                break;
            }
        }
    }
}

/**
 * Hotel class for creating template for the hotel object
 */
class Hotel {

    String hotelName;
    int rating;
    String dayType;
    int rate;
    String customer_type;


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }
}