/**
 * Hotel class for creating template for the hotel object
 */
class Hotel {

    String hotelName;
    int rating;
    int weekdayRate;
    int weekendRate;
    int specialWeekdayRate;
    int specialWeekendRate;
    int avgRate;
    int specialAvgRate;

    public Hotel(String hotelName, int rating, int weekdayRate, int weekendRate, int specialWeekdayRate, int specialWeekendRate) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.specialWeekdayRate = specialWeekdayRate;
        this.specialWeekendRate = specialWeekendRate;
        this.avgRate = weekdayRate + weekendRate;
        this.specialAvgRate = specialWeekdayRate + specialWeekendRate;
    }

    public int getSpecialAvgRate() {
        return specialAvgRate;
    }

    public void setSpecialAvgRate(int specialAvgRate) {
        this.specialAvgRate = specialAvgRate;
    }

    public int getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

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

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getSpecialWeekdayRate() {
        return specialWeekdayRate;
    }

    public void setSpecialWeekdayRate(int specialWeekdayRate) {
        this.specialWeekdayRate = specialWeekdayRate;
    }

    public int getSpecialWeekendRate() {
        return specialWeekendRate;
    }

    public void setSpecialWeekendRate(int specialWeekendRate) {
        this.specialWeekendRate = specialWeekendRate;
    }
}