package Rent;

import Util.Date;

import java.util.List;

public class Kart {

    private int id;
    private Client client;
    private List<DVD> products;
    private Date dueDate;

    public Kart(int id, Client client, List<DVD> products, Date dueDate) {
        this.id = id;
        this.client = client;
        this.products = products;
        this.dueDate = dueDate;
    }

    public Kart() {

    }

    public Kart(int id) {

        this.id = id;

    }

    public double getValue() {

        double value = 0;

        for (DVD dvd : products) {

            value += dvd.getPrice();

        }


        return value;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DVD> getProducts() {
        return products;
    }

    public void setProducts(List<DVD> products) {
        this.products = products;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
