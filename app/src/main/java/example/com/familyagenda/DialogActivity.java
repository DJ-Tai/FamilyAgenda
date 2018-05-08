package example.com.familyagenda;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class DialogActivity extends AppCompatActivity
        implements View.OnClickListener{

    private final String TAG = "AUC_DLG_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_custom_dialog_box);

//        //create the spinner for start time hour
//        final Spinner hour = (Spinner)rootView.findViewById(R.id.start_time_spinner_hour);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
//                R.array.hour_times, android.R.layout.simple_spinner_item);
//        hour.setAdapter(adapter);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        hour.setAdapter(adapter);
//
//        final Spinner hour2 = (Spinner)rootView.findViewById(R.id.end_time_spinner_hour);
//        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
//                R.array.hour_times, android.R.layout.simple_spinner_item);
//        hour2.setAdapter(adapter);
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        hour2.setAdapter(adapter2);
//
//        final Spinner minute = (Spinner)rootView.findViewById(R.id.start_time_spinner_minute);
//        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
//                R.array.min_times, android.R.layout.simple_spinner_item);
//        minute.setAdapter(adapter);
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        minute.setAdapter(adapter3);
//
//
//        final Spinner minute2 = (Spinner)rootView.findViewById(R.id.end_time_spinner_minute);
//        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(),
//                R.array.min_times, android.R.layout.simple_spinner_item);
//        minute2.setAdapter(adapter);
//        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        minute.setAdapter(adapter3);
//
        // set up button click handlers
        findViewById(R.id.start_date_button).setOnClickListener(this);
        findViewById(R.id.end_date_button).setOnClickListener(this);
        Button addEventDialog = findViewById(R.id.add_event_button);
        addEventDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bBuilder = new AlertDialog.Builder(DialogActivity.this);
                View bView = getLayoutInflater().inflate(R.layout.add_event_custom_dialog_box, null);
                Button btOK = (Button) findViewById(R.id.btnOK);
                final EditText event_name = (EditText) bView.findViewById(R.id.event_name);
                if(!event_name.getText().toString().isEmpty()){
                    Toast.makeText(DialogActivity.this, "No Name Given", Toast.LENGTH_SHORT).show();

                }
                bBuilder.setView(bView);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_date_button:
                // Get a calendar instance
                Calendar cal = Calendar.getInstance();

                // Create a DatePickerDialog
                DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Log.i(TAG, String.format("Date Chosen -- day: %d, month: %d, year: %d", dayOfMonth, monthOfYear, year));
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

                // Set the title and show the dialog
                datePicker.setTitle("Choose a Date");
                datePicker.show();
                break;
            case R.id.end_date_button:
                // Get a calendar instance
                Calendar cal2 = Calendar.getInstance();

                // Create a DatePickerDialog
                DatePickerDialog datePicker2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Log.i(TAG, String.format("Date Chosen -- day: %d, month: %d, year: %d", dayOfMonth, monthOfYear, year));
                    }
                }, cal2.get(Calendar.YEAR), cal2.get(Calendar.MONTH), cal2.get(Calendar.DAY_OF_MONTH));

                // Set the title and show the dialog
                datePicker2.setTitle("Choose a Date");
                datePicker2.show();
                break;
        }
    }

}


