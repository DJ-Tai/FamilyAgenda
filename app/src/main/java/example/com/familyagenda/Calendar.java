package example.com.familyagenda;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment
{
    public static final String MESSAGE_KEY = "message_key";

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

        // Sample Data
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 20; i++)
        {
            items.add("yoyo" + Integer.toString(i));
        }

        // Pushing data to ListView
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this.getContext(), simple_list_item_1, items);
        ListView listView = view.findViewById(R.id.event_list);
        listView.setAdapter(itemsAdapter);

        return view;
    }

}
