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

        tvTitle.setText(event.getTitle());
        tvDesc.setText(event.getDesc());
        tvStartHr.setText(Integer.toString(event.getStartTimeHour()));
        tvStartMin.setText(Integer.toString(event.getStartTimeMinute()));
        tvEndHr.setText(Integer.toString(event.getEndTimeHour()));
        tvEndMin.setText(Integer.toString(event.getEndTimeMinute()));


        return convertView;
    }
}
