package example.com.familyagenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class EventAdapter extends ArrayAdapter<Event>
{
    /**
     * Default constructor
     *
     * @param context
     * @param events
     */
    public EventAdapter(Context context, List<Event> events)
    {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Event event = getItem(position);
        assert event != null;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater
                            .from(getContext())
                            .inflate(R.layout.list_events, parent, false);
        }

        // Lookup TextView's for data population
        TextView tvTitle = convertView.findViewById(R.id.tv_event_title);
        TextView tvDesc = convertView.findViewById(R.id.tv_event_desc);

        TextView tvStartTime = convertView.findViewById(R.id.event_start_time);
        TextView tvEndTime = convertView.findViewById(R.id.event_end_time);

        tvTitle.setText(event.getEventTitle());
        tvDesc.setText(event.getDesc());
        tvStartTime.setText(event.getStartTime());
        tvEndTime.setText(event.getEndTime());

        return convertView;
    }

}
