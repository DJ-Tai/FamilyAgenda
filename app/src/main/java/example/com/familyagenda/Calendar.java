package example.com.familyagenda;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment
{
    public Calendar()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // View to be returned and referenced, i.e., DON'T DELETE ME
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        EventAdapter adapter;
        ListView listView;

        // Construct data source
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("Birthday Party", "Evan's Birthday Party",
                                20, 4, 2018, true,
                                10,0,18,0));

        events.add(new Event("Soccer Game", "CSULB vs CSUF",
                                22, 4, 2018, false,
                                10,30,13,0));

        // Create adapter
        adapter = new EventAdapter((this.getContext()), events);
        listView = view.findViewById(R.id.list_events);
        listView.setAdapter(adapter);

        return view;
    }

    // TODO: Get CalendarView as a interactable object
}
