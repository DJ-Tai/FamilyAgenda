package example.com.familyagenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class EventAdapter extends ArrayAdapter<Event>
{
    /**
     * Default constructor
     *
     * @param context
     * @param events
     */
    public EventAdapter(Context context, ArrayList<Event> events)
    {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Event event = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater
                            .from(getContext())
                            .inflate(R.layout.list_events, parent, false);
        }

        // Lookup TextView's for data population
        TextView tvTitle = convertView.findViewById(R.id.event_title);
        TextView tvDesc = convertView.findViewById(R.id.event_desc);
        TextView tvStartHr = convertView.findViewById(R.id.event_start_hour);
        TextView tvStartMin = convertView.findViewById(R.id.event_start_mins);
        TextView tvEndHr = convertView.findViewById(R.id.event_end_hour);
        TextView tvEndMin = convertView.findViewById(R.id.event_end_mins);

        tvTitle.setText(event.getTitle());
        tvDesc.setText(event.getDesc());

        setTwoDigitTime(event, tvStartHr, tvStartMin, tvEndHr, tvEndMin);

        return convertView;
    }

    /**
     * Converts the integer times to two-digit Strings
     *
     * @param mEvent    - Event object
     * @param startHr   - Start time's hour
     * @param startMin  - Start time's minute
     * @param endHr     - End time's hour
     * @param endMin    - End time's minute
     */
    public void setTwoDigitTime(Event mEvent, TextView startHr, TextView startMin,
                                TextView endHr, TextView endMin)
    {
        /* For setting the TextView text */
        String strTime;
        /* Time stored in Event object */
        int time;

        time = mEvent.getStartTimeHour();
        strTime = (time < 10 && time >= 0) ? ("0" + Integer.toString(time)) : Integer.toString(time);
        startHr.setText(strTime);

        time = mEvent.getStartTimeMinute();
        strTime = (time < 10 && time >= 0) ? ("0" + Integer.toString(time)) : Integer.toString(time);
        startMin.setText(strTime);

        time = mEvent.getEndTimeHour();
        strTime = (time < 10 && time >= 0) ? ("0" + Integer.toString(time)) : Integer.toString(time);
        endHr.setText(strTime);

        time = mEvent.getEndTimeMinute();
        strTime = (time < 10 && time >= 0) ? ("0" + Integer.toString(time)) : Integer.toString(time);
        endMin.setText(strTime);
    }
}
