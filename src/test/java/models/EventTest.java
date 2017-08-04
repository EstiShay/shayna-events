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
    public void calculateCost_generatesCorrectEventCost_total() throws Exception {
        Event testEvent = new Event("Salmon BBQ", "Alcohol Service", "DJ", 75);
        assertEquals(2225, testEvent.calculateCost());
    }

}