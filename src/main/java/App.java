import models.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {

        Integer totalEventCost = 0;
        boolean runProgram = true;

        while(runProgram) {

            try {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Welcome to the Shayna Events ordering system. Let's get your order started! \nWhich food service package would you like? \nAppetizers: Fruit plate, mini quiches, and bruschetta. $10/attendee \nMediterranean Lunch: Greek salad, lamb & vegetable kebabs, and baklava. $15/attendee \nShabbat Dinner: Chicken breasts encrusted with breadcrumbs and parmesan, mix greens salad with raspberry vinaigrette, sweet noodle kugel, roast red potatoes, seasonal mixed veggies, challah, and cheesecake. (Not kosher; contact us to arrange for our kosher Shabbat dinners.) $25/attendee \nSalmon BBQ: Grilled salmon with lemon, Caesar salad, pasta salad, lime corn and black bean salad, and sorbet. $20/attendee (Please enter the name given.)");
                String foodInput = bufferedReader.readLine();
                //Form: radio button

                if (!(foodInput.equals("Salmon BBQ") || foodInput.equals("Appetizers") || foodInput.equals("Mediterranean Lunch") || foodInput.equals("Shabbat Dinner"))) {
                    System.out.println("Sorry, that wasn't one of our options.  Let's start over.");
                    break;
                }

                System.out.println("Which beverage service would you like? \nPunch Service: Non-alcoholic beverages: Shayna's Punch and lemonade. $3/attendee \nAlcohol Service: Beer and wine. $7/attendee \nFull Bar: All of the above plus a cocktail created specially for your event. $15/attendee");
                String beverageInput = bufferedReader.readLine();
                //Form: radio button

                if (!(beverageInput.equals("Punch Service") || beverageInput.equals("Alcohol Service") || beverageInput.equals("Full Bar"))) {
                    System.out.println("Sorry, that wasn't one of our options.  Let's start over.");
                    break;
                }

                System.out.println("Which type of entertainment would you like? \nDJ: 2 hours, $200 \nLive Band: 2 hours with a half hour break in the middle, $2000 \nString Quartet: 3 hours, with three 15 minute breaks, $1000 \nNone");
                String entertainmentInput = bufferedReader.readLine();
                //Form: radio button

                if (!(entertainmentInput.equals("DJ") || entertainmentInput.equals("Live Band") || entertainmentInput.equals("String Quartet") || entertainmentInput.equals("None"))) {
                    System.out.println("Sorry, that wasn't one of our options.  Let's start over.");
                    break;
                }

                System.out.println("How many guests will attend?");
                String stringGuestInput = bufferedReader.readLine();
                Integer guestInput = Integer.parseInt(stringGuestInput);
                //Form: intake field

                Event newEvent = new Event(foodInput, beverageInput, entertainmentInput, guestInput);

                String theFood = newEvent.getFood();
                String theBevs = newEvent.getBeverages();
                String theFun = newEvent.getEntertainment();
                Integer theGuests = newEvent.getGuests();



                System.out.println(String.format("************************************ \nYour order is: \nFood: %s \nBeverage: %s \nEntertainment: %s \nFor %d people.", theFood, theBevs, theFun, theGuests));

                System.out.println("Would you like to: \nCalculate cost or \nStart over?");
                //Form: buttons - calculate and display or reload page
                String nextStep = bufferedReader.readLine();
                if (nextStep.equals("Calculate cost")) {
                    totalEventCost = newEvent.calculateCost();
                } else {
                    System.out.println("Let's try again.");
                    break;
                }

                System.out.println(String.format("So far your event cost is $%d.", totalEventCost));

                System.out.println("Do you have a coupon? yes or no");
                String couponYN = bufferedReader.readLine();
                if (couponYN.equals("yes")) {
                    System.out.println("Please enter your coupon code:");
                    String couponCode = bufferedReader.readLine();
                    if (couponCode.equals("BIGPARTY") && theGuests > 149) {
                        if (theFun.equals("DJ")) {
                            totalEventCost -= 200;
                            System.out.println(("The DJ is free!"));
                            newEvent.perk = "Free DJ with 150+ attendees.";
                        } else if (theFun.equals("None")){
                            System.out.println("That coupon is for a DJ. Would you like to change your entertainment selection from None to DJ? yes or no");
                            String addDJYN = bufferedReader.readLine();
                            if (addDJYN.equals("yes")) {
                                newEvent.entertainment = "DJ";
                                System.out.println(("The DJ is free!"));
                                newEvent.perk = "Free DJ with 150+ attendees.";
                            } else if (addDJYN.equals("no")){
                                System.out.println(("Ok, let's move on"));
                            } else {
                                System.out.println(("That wasn't one of the options. Let's start over."));
                                break;
                            }
                        } else if (theFun.equals("Live Band")) {
                            System.out.println("That coupon is for a DJ and you chose a live band. Would you like to switch to a DJ? yes or no");
                            String addDJYN = bufferedReader.readLine();
                            if (addDJYN.equals("yes")) {
                                newEvent.entertainment = "DJ";
                                totalEventCost -= 2000;
                            }
                        } else if (theFun.equals("String Quartet")) {
                            System.out.println("That coupon is for a DJ and you chose a string quartet. Would you like to switch to a DJ? yes or no");
                            String addDJYN = bufferedReader.readLine();
                            if (addDJYN.equals("yes")) {
                                newEvent.entertainment = "DJ";
                                totalEventCost -= 1000;
                            }
                        } else {
                            System.out.println("Coupon error");
                        }
                    } else if (couponCode.equals("MITZVAH")) {
                        System.out.println(("Mazel tov! We'll throw in up to 10 bottles of sparkling cider to help toast your event. Please contact us to let us know how many you would like."));
                        newEvent.perk = "Sparkling cider for Bas Mitzvah toasts.";
                    } else if (couponCode.equals("BIGPARTY") && newEvent.guests < 150) {
                        System.out.println(("I'm sorry, that coupon requires 150+ guests."));
                    } else {
                        System.out.println("Sorry, that is not one of our coupon codes.");
                    }
                }

                String theCoupon = newEvent.getPerk();

                System.out.println(String.format("******************************************** \nThank you for choosing Shayna Events!  \nYour order of Food: %s, Beverages: %s, and Entertainment: %s for %d people comes to $%d.", theFood, theBevs, theFun, theGuests, totalEventCost));
                if (!theCoupon.equals("")) {
                    System.out.println(String.format("Coupon: %s", theCoupon));
                }
                runProgram = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
