import java.util.*;
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
                System.out.println("Enter rating of the hotel from 1-5");
                hotelObj.setRating(sc.nextInt());
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
    public void findCheapestHotel() {

        int cheapestTotalRate = Integer.MAX_VALUE;
        int totalRate;
        String[] array;
        int hotelRating = 0;
        String[] hotelNamesArray = new String[hotelReservation.size()];
        Integer[] ratesArray = new Integer[hotelReservation.size()];
        Integer[] hotelRatings = new Integer[hotelReservation.size()];
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

        System.out.println("Enter the number of weekend days (Saturdays and Sundays) : ");
        int weekEnds = sc.nextInt();

        if (weekEnds == 0) {
            for (Map.Entry<String, Hotel> entry : hotelReservation.entrySet()) {
                totalRate = entry.getValue().getWeekdayRate() * array.length;
                if (totalRate < cheapestTotalRate) {
                    cheapestTotalRate = totalRate;
                    cheapestHotelName = entry.getKey();
                    hotelRating = entry.getValue().getRating();
                }
            }
            System.out.println(" The cheapest hotel price is " + cheapestHotelName + " Rating : " + hotelRating + " Total Rates = $" + cheapestTotalRate);
        }
        if (weekEnds == 2) {
            for (Map.Entry<String, Hotel> entry : hotelReservation.entrySet()) {
                totalRate = entry.getValue().getWeekendRate() * array.length;
                if (totalRate < cheapestTotalRate) {
                    cheapestTotalRate = totalRate;
                    cheapestHotelName = entry.getKey();
                    hotelRating = entry.getValue().getRating();
                }
            }
            System.out.println(" The cheapest hotel price is " + cheapestHotelName + " Rating : " + hotelRating + " Total Rates = $" + cheapestTotalRate);
        }
        if (weekEnds == 1) {
            int z = 0;
            for (Map.Entry<String, Hotel> entry : hotelReservation.entrySet()) {
                totalRate = entry.getValue().getWeekendRate() + entry.getValue().getWeekdayRate();
                ratesArray[z] = totalRate;
                hotelNamesArray[z] = entry.getKey();
                hotelRatings[z] = entry.getValue().getRating();
                z++;
                if (totalRate < cheapestTotalRate) {
                    cheapestTotalRate = totalRate;
                    cheapestHotelName = entry.getKey();
                    hotelRating = entry.getValue().getRating();
                }
            }
            if (ratesArray[0].equals(ratesArray[1])) {
                if (hotelRatings[0] > hotelRatings[1]) {
                    System.out.println(" The cheapest hotel price is " + hotelNamesArray[0] + " Rating : " + hotelRatings[0] + "  Total Rates = $" + cheapestTotalRate);
                } else
                    System.out.println(" The cheapest hotel price is " + hotelNamesArray[1] + " Rating : " + hotelRatings[1] + "  Total Rates = $" + cheapestTotalRate);
            } else if (ratesArray[0].equals(ratesArray[2])) {
                if (hotelRatings[0] > hotelRatings[2]) {
                    System.out.println(" The cheapest hotel price is " + hotelNamesArray[0] + " Rating : " + hotelRatings[0] + "  Total Rates = $" + cheapestTotalRate);
                } else
                    System.out.println(" The cheapest hotel price is " + hotelNamesArray[2] + " Rating : " + hotelRatings[2] + "  Total Rates = $" + cheapestTotalRate);
            } else if (ratesArray[1].equals(ratesArray[2])) {
                if (hotelRatings[1] > hotelRatings[2]) {
                    System.out.println(" The cheapest hotel price is " + hotelNamesArray[1] + " Rating : " + hotelRatings[1] + "  Total Rates = $" + cheapestTotalRate);
                } else
                    System.out.println(" The cheapest hotel price is " + hotelNamesArray[2] + " Rating : " + hotelRatings[2] + "  Total Rates = $" + cheapestTotalRate);
            } else {
                System.out.println("The cheapest hotel price is " + cheapestHotelName + " Rating : " + hotelRating + "  Total Rates = $" + cheapestTotalRate);
            }
        }
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