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

        // Lookup View for data population
        TextView tvTitle = convertView.findViewById(R.id.event_title);
        TextView tvDesc = convertView.findViewById(R.id.event_desc);
        TextView tvStartHr = convertView.findViewById(R.id.event_start_hour);
        TextView tvStartMin = convertView.findViewById(R.id.event_start_mins);
        TextView tvEndHr = convertView.findViewById(R.id.event_end_hour);
        TextView tvEndMin = convertView.findViewById(R.id.event_end_mins);

        // TODO: Ensure time is shown with 4 numbers, e.g., 10:00 or 07:00
        setTwoDigitTime(event, tvTitle, tvDesc, tvStartHr, tvStartMin, tvEndHr, tvEndMin);

        return convertView;
    }

    public void setTwoDigitTime(Event mEvent, TextView title, TextView desc, TextView startHr,
                                TextView startMin, TextView endHr, TextView endMin)
    {
        String strTime;
        int time;

        title.setText(mEvent.getTitle());
        desc.setText(mEvent.getDesc());

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
