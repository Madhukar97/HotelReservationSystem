import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservation {
    String[] arrayOfDates;
    int weekEnds = 0;
    Map<String, Hotel> hotelReservation = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservation obj = new HotelReservation();
        obj.addHotel();
        obj.customerType();
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
                System.out.println("Enter the special rates for reward customer for weekday and weekend");
                hotelObj.setSpecialWeekdayRate(sc.nextInt());
                hotelObj.setSpecialWeekendRate(sc.nextInt());
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
     * Method for determining the customerType
     */
    public void customerType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 if regular customer and 1 for Reward Customer");
        int type = sc.nextInt();
        if (type == 0) {
            System.out.println("Enter 0 for Cheapest Hotel and 1 for Best Rated Hotel");
            int option = sc.nextInt();
            if (option == 0) {
                findCheapestHotel();
            } else findBestRatedHotel();
        } else findBestRatedHotelRewardCustomer();
    }

    /**
     * Method to find the Best Rated Hotel
     */
    public void findBestRatedHotel() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the dates in yyyy-mm-dd format: ");
            String dateFormat = sc.next();
            arrayOfDates = dateFormat.split(",");
            if (isDateValid(dateFormat)) {
                break;
            } else System.out.println("Incorrect Date format");
        }
        DayOfWeek day1 = LocalDate.parse(arrayOfDates[0]).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(arrayOfDates[1]).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
        if (weekEnds == 0) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekdayRate() * 2);
        }
        if (weekEnds == 2) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekendRate() * 2);
        }
        if (weekEnds == 1) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate()));
        }
    }

    /**
     * Method to find the Best Rated Hotel for Reward Customer
     */
    public void findBestRatedHotelRewardCustomer() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the dates in yyyy-mm-dd format: ");
            String dateFormat = sc.next();
            arrayOfDates = dateFormat.split(",");
            if (isDateValid(dateFormat)) {
                break;
            } else System.out.println("Incorrect Date format");
        }
        DayOfWeek day1 = LocalDate.parse(arrayOfDates[0]).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(arrayOfDates[1]).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
        if (weekEnds == 0) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getSpecialWeekdayRate() * 2);
        }
        if (weekEnds == 2) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getSpecialWeekendRate() * 2);
        }
        if (weekEnds == 1) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + (hotelObjList.get(2).getSpecialWeekdayRate() + hotelObjList.get(2).getSpecialWeekendRate()));
        }
    }

    /**
     * Method for finding the cheapest hotel rate
     */
    public void findCheapestHotel() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the dates in yyyy-mm-dd format: ");
            String dateFormat = sc.next();
            arrayOfDates = dateFormat.split(",");
            if (isDateValid(dateFormat)) {
                break;
            } else System.out.println("Incorrect Date format");
        }
        DayOfWeek day1 = LocalDate.parse(arrayOfDates[0]).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(arrayOfDates[1]).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
        }
        if (weekEnds == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
        }
        if (weekEnds == 1) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getWeekdayRate() + hotelObjList.get(1).getWeekendRate()));
            } else
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
        }
    }

    /**
     * Method for validating the date input
     *
     * @param dateFormat takes in the String parameter of entered date format
     * @return returns true if date format is valid
     */
    public boolean isDateValid(String dateFormat) {
        String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}.[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateFormat);
        return matcher.matches() && matcher.matches();
    }
}