package example.com.familyagenda;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Evan on 4/26/18.
 */

public class AddEventDialog extends DialogFragment {

    Spinner hour;
    ArrayAdapter<CharSequence> adapter;
    Spinner min;
    ArrayAdapter<CharSequence> adapter2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_event_custom_dialog_box,
                container, false);
        //hour = (Spinner)findByViewId(R.id.end_time_spinner_hour);
        //adapter = ArrayAdapter.createFromResource(this,R.array.hour_times, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hour.setAdapter(adapter);
        hour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO - set the event hour here. Then do this step for the other spinners
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button btnOK = rootView.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ArrayList<Event> events = new ArrayList<>();
                events.add(new Event(null,"Birthday Party", "Description of Evan's Birthday Party",
                        20, 4, 2018, true,
                        10,00,18,00));
                if(R.id.am_radio_button > 0) {
                    //events.add(new Event(R.id.event_name, R.id.event_description, R.id.));

                }
            }
        });
        return rootView;
    }
}
