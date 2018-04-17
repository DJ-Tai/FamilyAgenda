package example.com.familyagenda;

/**
 * Created by Evan on 4/5/18.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventList
{
    public static List<Event> eventList = new ArrayList<>();
    public static Map<String, Event> eventMap = new HashMap<>();

    static
    {
        //        addEvent("Do Laundry", "Evan", false);
    }

    private static void addEvent(String eventTitle, String desc, boolean repeats, int startTimeHour,
                                 int startTimeMinute,
                                 int endTimeHour, int endTimeMinute)
    {
        // TODO
    }

    public static List<String> getProductNames()
    {
        List<String> list = new ArrayList<>();
        for (Event product : eventList)
        {
            list.add(product.getTitle());
        }
        return list;
    }

    public static List<Event> getFilteredList(String searchString)
    {

        List<Event> filteredList = new ArrayList<>();
        for (Event product : eventList)
        {
            if (product.getTitle().contains(searchString))
            {
                filteredList.add(product);
            }
        }

        return filteredList;

    }

}

