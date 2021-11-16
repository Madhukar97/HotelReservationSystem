import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void addHotel() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to enter a hotel and 2 to exit");
            int option = sc.nextInt();
            if (option == 1) {
                Hotel hotelObj = new Hotel();
                System.out.println("Enter the name of hotel");
                String name = sc.next();
                hotelObj.setHotelName(name);
                System.out.println("Enter the weekday and weekend rate");
                hotelObj.setWeekdayRate(sc.nextInt());
                hotelObj.setWeekendRate(sc.nextInt());
                hotelReservation.put(name, hotelObj);
            }
            if (option == 2) {
                break;
            }
        }
    }

    /**
     * Method for finding the cheapest hotel rate
     */
    public int findCheapestHotel() {

        int cheapestRate = 9999999;
        String[] array;
        String cheapestHotelName = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the dates in ddmmmyyyy format: ");
            String dateFormat = sc.next();
            array = dateFormat.split(",");
            if (isDateValid(dateFormat)) {
                break;
            } else System.out.println("Incorrect Date format");
        }

        for (Map.Entry<String, Hotel> hotelEntry : hotelReservation.entrySet()) {
            if (hotelEntry.getValue().getWeekdayRate() < cheapestRate) {
                cheapestRate = hotelEntry.getValue().getWeekdayRate();
                cheapestHotelName = hotelEntry.getValue().getHotelName();
            }
        }
        int totalRate = cheapestRate * array.length;
        System.out.println("The cheapest rate is = " + cheapestHotelName + "  " + totalRate + " Rs");

        return cheapestRate;
    }

    /**
     * Method for validating the date input
     *
     * @param dateFormat takes in the String parameter of entered date format
     * @return returns true if date format is valid
     */
    public boolean isDateValid(String dateFormat) {
        String regex = "^[0-9]{2}[a-zA-Z]{3}[0-9]{4}.[0-9]{2}[a-zA-Z]{3}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateFormat);
        return matcher.matches() && matcher.matches();
    }
}

