import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservation {

    Map<String, Hotel> hotelReservation = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        obj.findCheapestHotelForRewardCustomer("2020-09-11", "2020-09-12");
    }

    /**
     * Method for adding Hotel to the HotelReservationSystem
     */
    public void addHotel() {
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        hotelReservation.put(obj1.getHotelName(), obj1);
        hotelReservation.put(obj2.getHotelName(), obj2);
        hotelReservation.put(obj3.getHotelName(), obj3);
    }

    /**
     * Method for inputting the dates from user
     */
    public void enterDates() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 dates in yyyymmdd format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        findCheapestHotel(date1, date2);
    }

    /**
     * Method for finding the cheapest Hotel for given dates
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestHotel(String d1, String d2) {
        int weekEnds = 0;
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
            return hotelObjList.get(0).getWeekdayRate() * 2;
        }
        if (weekEnds == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            return hotelObjList.get(0).getWeekendRate() * 2;
        } else {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getWeekdayRate() + hotelObjList.get(1).getWeekendRate()));
                return hotelObjList.get(1).getAvgRate();
            }
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getAvgRate();
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
            }
        }
    }

    /**
     * Method to find the Best Rated Hotel
     */
    public int findBestRatedHotel(String d1, String d2) {
        int weekEnds = 0;
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
        if (weekEnds == 0) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekdayRate() * 2);
            return hotelObjList.get(2).getWeekdayRate() * 2;
        }
        if (weekEnds == 2) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekendRate() * 2);
            return hotelObjList.get(2).getWeekendRate() * 2;
        } else {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate()));
            return (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate());
        }
    }

    /**
     * Method for finding the cheapest Hotel for given dates for Reward Customer
     *
     * @param d1 day1 is passed as String parameter
     * @param d2 day2 is passed as String parameter
     * @return returns the cheapest total rates
     */
    public int findCheapestHotelForRewardCustomer(String d1, String d2) {
        int weekEnds = 0;
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.specialWeekdayRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getSpecialWeekdayRate() * 2);
            return hotelObjList.get(0).getSpecialWeekdayRate() * 2;
        }
        if (weekEnds == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.specialWeekendRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getSpecialWeekendRate() * 2);
            return hotelObjList.get(0).getSpecialWeekendRate() * 2;
        } else {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.specialAvgRate)).collect(Collectors.toList());
            if (hotelObjList.get(0).getSpecialAvgRate() == hotelObjList.get(1).getSpecialAvgRate() && hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getSpecialWeekdayRate() + hotelObjList.get(1).getSpecialWeekendRate()));
                return hotelObjList.get(1).getSpecialAvgRate();
            }
            if (hotelObjList.get(0).getSpecialAvgRate() == hotelObjList.get(1).getSpecialAvgRate() && hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate()));
                return hotelObjList.get(0).getSpecialAvgRate();
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate()));
                return hotelObjList.get(0).getSpecialWeekdayRate() + hotelObjList.get(0).getSpecialWeekendRate();
            }
        }
    }

    /**
     * Method for validating date format using regex
     *
     * @param d1 takes in the date 1 String
     * @param d2 takes in the date 2 String
     * @return returns true if entered dates are valid
     */
    public boolean isDateValid(String d1, String d2) {
        String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(d1);
        Matcher matcher2 = pattern.matcher(d2);
        return matcher1.matches() && matcher2.matches();
    }
}