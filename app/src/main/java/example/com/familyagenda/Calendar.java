package example.com.familyagenda;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import example.com.familyagenda.database.EventDataSource;
import example.com.familyagenda.test.SampleDataProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment
{
    public static final String TAG = "CalendarDebug";

    List<Event> eventList = SampleDataProvider.eventList;
    List<Event> listFromDB;

    /* For DB communication */
    EventDataSource mEventDataSource;

    public Calendar()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        /* View to be returned and referenced, i.e., DON'T DELETE ME */
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        /* Database reference */
        mEventDataSource = new EventDataSource(this.getContext());
        mEventDataSource.open();
        mEventDataSource.seedDatabase(eventList);

        listFromDB = mEventDataSource.getAllItems();

        /* Custom Adapter for Event class */
        EventAdapter adapter;

        /* References the ListView in the UI */
        ListView listView;

        /* References the CalendarView in the UI */
        CalendarView calendarView;

        /* Holds date of the user's device (char[] req'd for setting text in TextView) */
        char[] deviceDate;

        /* TextView where date is displayed above listed Events */
        TextView tvDate;

        deviceDate = getDate();
        tvDate = view.findViewById(R.id.tv_date_sel);
        tvDate.setText(deviceDate, 0, deviceDate.length);

        calendarView = view.findViewById(R.id.calendar_view);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calView, int year, int month,
                                            int dayOfMonth)
            {
                String date = (month + 1) + "/" + dayOfMonth + "/" + year;
                char[] charDate = date.toCharArray();

                View outerView = calView.getRootView();
                TextView tv = outerView.findViewById(R.id.tv_date_sel);
                tv.setText(charDate, 0, charDate.length);

                // TODO: Use date change to grab events associated with the date selected
                // TODO: Incorporate DB access
            }
        });

        // TODO: Add click-to-edit events
        adapter = new EventAdapter((this.getContext()), listFromDB);
        listView = view.findViewById(R.id.list_events);
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mEventDataSource.close();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mEventDataSource.open();
    }

    /**
     * Get the date as a char[] for setting the TextView
     *
     * @return - Date as a char[]
     */
    public char[] getDate()
    {
        /* Placeholders for month, day, year, and combined date separated by backslashes */
        String month, day, year, formattedDate;

        /* Used to grab only the necessary parts of the java.util.Date */
        String[] splitDeviceDate;

        /* Date req'd to be char[] for inserting into a TextView */
        char[] forTextView;

        /* References the device's date */
        java.util.Date deviceDate;

        deviceDate = java.util.Calendar.getInstance().getTime();
        splitDeviceDate = deviceDate.toString().split(" ");

        month = getMonthNum(splitDeviceDate[1]);
        day = splitDeviceDate[2];
        if (day.charAt(0) == '0')
        {
            day = day.substring(1, 2);
        }
        year = splitDeviceDate[5];

        formattedDate = month + "/" + day + "/" + year;

        forTextView = formattedDate.toCharArray();

        return forTextView;
    }

    /**
     * Gets the month as a number
     *
     * @param month - Name of month
     * @return - Month number, starting at 1
     */
    public String getMonthNum(String month)
    {
        String num;

        switch (month)
        {
            case "January":
                num = "1";
                break;
            case "February":
                num = "2";
                break;
            case "March":
                num = "3";
                break;
            case "April":
                num = "4";
                break;
            case "May":
                num = "5";
                break;
            case "June":
                num = "6";
                break;
            case "July":
                num = "7";
                break;
            case "August":
                num = "8";
                break;
            case "September":
                num = "9";
                break;
            case "October":
                num = "10";
                break;
            case "November":
                num = "11";
                break;
            default:
                num = "12";
                break;
        }

        return new String(num);
    }

}
