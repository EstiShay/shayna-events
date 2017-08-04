package models;

public class Event {

    public String food;
    public String beverages;
    public String entertainment;
    public Integer guests;
    public String perk;

    public Event(String food, String beverages, String entertainment, Integer guests) {
        this.food = food;
        this.beverages = beverages;
        this.entertainment = entertainment;
        this.guests = guests;
        this.perk = "";
    }

    public String getFood() {
        return food;
    }

    public String getBeverages() {
        return beverages;
    }

    public String getEntertainment() {
        return entertainment;
    }

    public Integer getGuests() {
        return guests;
    }

    public String getPerk() {
        return perk;
    }

    public int calculateCost() {
        Integer foodTotal = 0;
        Integer bevTotal = 0;
        Integer entTotal = 0;
        if (food.equals("Salmon BBQ")){
            foodTotal += (20 * guests);
        } else if (food.equals("Appetizers")){
            foodTotal += (10 * guests);
        } else if (food.equals("Mediterranean Lunch")){
            foodTotal += (15 * guests);
        } else if (food.equals("Shabbat Dinner")){
            foodTotal += (25 * guests);
        } else {
            System.out.println("Cost calculation error - food input");
        }
//        System.out.println(String.format("Your selection %s will cost $%d.", food, foodTotal));

        if (beverages.equals("Punch Service")) {
            bevTotal += (3 * guests);
        } else if (beverages.equals("Alcohol Service")) {
            bevTotal += (7 * guests);
        } else if (beverages.equals("Full Bar")){
            bevTotal += (15 * guests);
        } else {
            System.out.println("Cost calculation error - beverage input");
        }
//        System.out.println(String.format("Your selection %s will cost $%d.", beverages, bevTotal));

        if (entertainment.equals("DJ")) {
            entTotal += 200;
        } else if (entertainment.equals("Live Band")) {
            entTotal += 2000;
        } else if (entertainment.equals("String Quartet")) {
            entTotal += 1000;
        } else if (entertainment.equals("None")) {
            entTotal += 0;
        } else {
            System.out.println("Cost calculation error - entertainment input");
        }
//        System.out.println(String.format("Your selection %s will cost $%d.", entertainment, entTotal));

        int total = foodTotal + bevTotal + entTotal;
        return total;
    }
}
