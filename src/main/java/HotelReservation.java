import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelReservation {

    Map<String, Hotel> hotelReservation = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        obj.findCheapestHotel();

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
                System.out.println("Enter the regular rate");
                int rate = sc.nextInt();
                hotelObj.setRate(rate);
                hotelReservation.put(name,hotelObj);
            }
            if (option==2){
                break;
            }
        }
    }

    /**
     * Method for finding the cheapest hotel rate
     */
    public void findCheapestHotel(){

        int cheapestRate = 1000;
        String cheapestHotelName = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dates ");
        String[] array = sc.next().split(",");
        for (Map.Entry<String,Hotel> hotelEntry: hotelReservation.entrySet()){
            if (hotelEntry.getValue().getRate()<cheapestRate){
                cheapestRate=hotelEntry.getValue().getRate();
                cheapestHotelName = hotelEntry.getValue().getHotelName();
            }
        }
        int totalRate = cheapestRate* array.length;
        System.out.println("The cheapest rate is = "+cheapestHotelName+"  "+totalRate+" Rs");

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