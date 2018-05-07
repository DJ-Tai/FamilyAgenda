package example.com.familyagenda.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import example.com.familyagenda.Event;

public class SampleDataProvider
{
    public static List<Event> eventList;
    public static Map<String, Event> eventMap;

    static {
        eventList = new ArrayList<>();
        eventMap = new HashMap<>();

        addEvent(new Event(null, "Birthday Party", "Description of Evan's Birthday Party",
                             20, 4, 2018, true,
                             10, 00, 18, 00));

        addEvent(new Event(null,"Soccer Game", "Description of CSULB vs CSUF Soccer Game",
                             22, 4, 2018, false,
                             10, 30, 13, 00));
        addEvent(new Event(null,"Basketball Game", "Description of CSULB vs CSUF Basketball Game",
                             10, 6, 2018, false,
                             10, 30, 13, 30));
        addEvent(new Event(null,"Coding Session", "Something about Coding and What Not and Coffee",
                             4, 5, 2018, false,
                             7, 30, 9, 00));
        addEvent(new Event(null,"Morning Run", "Go out for a morning run",
                             4, 4, 2018, false, 7,
                             00, 8, 00));
    }

    private static void addEvent(Event event)
    {
        eventList.add(event);
        eventMap.put(event.getEventId(), event);
    }


}
