package models;

public class Event {

    public String food;
    public String beverages;
    public String entertainment;
    public Integer guests;

    public Event(String food, String beverages, String entertainment, Integer guests) {
        this.food = food;
        this.beverages = beverages;
        this.entertainment = entertainment;
        this.guests = guests;
    }
}
