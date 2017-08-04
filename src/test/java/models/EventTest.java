package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    @Test
    public void Event_instantiatesCorrectly() throws Exception {
        Event testEvent = new Event("appetizers", "simple", "dj");
        assertEquals(true, testEvent instanceof Event);
    }



}