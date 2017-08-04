package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void Event_instantiatesCorrectly() throws Exception {
        Event testEvent = new Event("appetizers", "simple", "dj", 20);
        assertEquals(true, testEvent instanceof Event);
    }

    @Test
    public void getFood_retrievesFoodSelection_food() throws Exception {
        Event testEvent = new Event("Salmon BBQ", "Alcohol Service", "DJ", 75);
        assertEquals("Salmon BBQ", testEvent.getFood());
    }

    @Test
    public void getBeverages_retrievesBevSelection_bev() throws Exception {
        Event testEvent = new Event("Salmon BBQ", "Alcohol Service", "DJ", 75);
        assertEquals("Alcohol Service", testEvent.getBeverages());
    }

    @Test
    public void getEntertainment_retrievesEntSelection_Ent() throws Exception {
        Event testEvent = new Event("Salmon BBQ", "Alcohol Service", "DJ", 75);
        assertEquals("DJ", testEvent.getEntertainment());
    }


//    @Test
//    public void calculateCost_generatesCorrectEventCost_total() throws Exception {
//        Event testEvent = new Event("Salmon BBQ", "Alcohol Service", "DJ", 75);
//        assertEquals(2225, testEvent.calculateCost());
//    }

}