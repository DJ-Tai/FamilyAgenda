package example.com.familyagenda;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment
{
    public static final String TAG = "CalendarDebug";

    public Calendar()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        /* View to be returned and referenced, i.e., DON'T DELETE ME */
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        /* Custom Adapter for Event class */
        EventAdapter adapter;

        /* References the ListView in the UI */
        ListView listView;

        /* References the CalendarView in the UI */
        CalendarView calendarView;

        // TODO: DEBUGGING CALENDAR VIEW
        calendarView = view.findViewById(R.id.calendar_view);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calView, int year, int month,
                                            int dayOfMonth)
            {
                String date = month + "/" + dayOfMonth + "/" + year;
                char[] charDate = date.toCharArray();

                View outerView = calView.getRootView();
                TextView tv = outerView.findViewById(R.id.tv_date_sel);
                tv.setText(charDate, 0, charDate.length);

                // TODO: Use date change to grab events associated with the date selected
            }
        });

        // TODO: DEBUGGINGs Construct data source
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("Birthday Party", "Description of Evan's Birthday Party",
                                20, 4, 2018, true,
                                10,00,18,00));

        events.add(new Event("Soccer Game", "Description of CSULB vs CSUF Soccer Game",
                                22, 4, 2018, false,
                                10,30,13,0));

        // TODO: Add click-to-edit events
        // Grab list of events and display them
        adapter = new EventAdapter((this.getContext()), events);
        listView = view.findViewById(R.id.list_events);
        listView.setAdapter(adapter);

        return view;
    }



}
