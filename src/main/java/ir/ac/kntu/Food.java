package ir.ac.kntu;

public class Food {
    private Place place;
    private double price;
    private Time.DayOfClass day;
    private Time.HourOfClass hour;

    public Food(Place place, double price) {
        this.place = place;
        this.price = price;
    }

    public Food() {
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Time.DayOfClass getDay() {
        return day;
    }

    public void setDay(Time.DayOfClass day) {
        this.day = day;
    }

    public Time.HourOfClass getHour() {
        return hour;
    }

    public void setHour(Time.HourOfClass hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Food{" +
                "place=" + place +
                ", price=" + price +
                ", day=" + day +
                ", hour=" + hour +
                '}';
    }
}
