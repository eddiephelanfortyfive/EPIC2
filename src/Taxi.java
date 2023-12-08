public class Taxi {
    private String registration;
    private String name;
    private int rating;
    private String brand;
    private String size;
    private int seats;


    public Taxi(String registration, String name, int rating, String brand, String size, int seats){
        this.registration=registration;
        this.name=name;
        this.rating=rating;
        this.brand=brand;
        this.size=size;
        this.seats=seats;
    }

    public String getRegistration() {
        return registration;
    }
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
    public String getBrand() {
        return brand;
    }
    public String getSize() {
        return size;
    }
    public int getSeats() {
        return seats;
    }

}
