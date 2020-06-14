package Rent;

import java.util.Date;

public class DVD {

    private String name;
    private double price;
    private Date releaseDate;
    private String serial;

    public DVD(String name, double price, Date releaseDate, String serial) {

        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.serial = serial;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
