package example.com.familyagenda;

import android.app.DatePickerDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.Calendar;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

/**
 * Handles the activity in the AddEventDialog dialog box
 * */
public class DialogActivity extends AppCompatActivity
        implements View.OnClickListener {

    private final String TAG = "AUC_DLG_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_custom_dialog_box);

        //set up button handlers
        findViewById(R.id.btnOK).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);
        findViewById(R.id.start_date_button).setOnClickListener(this);
        findViewById(R.id.end_date_button).setOnClickListener(this);

        //create the spinner for start time hour
        final Spinner hour = (Spinner) findViewById(R.id.start_time_spinner_hour);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hour_times, android.R.layout.simple_spinner_item);
        hour.setAdapter(adapter);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hour.setAdapter(adapter);

        //Create end time hour Spinner
        final Spinner hour2 = (Spinner) findViewById(R.id.end_time_spinner_hour);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.hour_times, android.R.layout.simple_spinner_item);
        hour2.setAdapter(adapter);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hour2.setAdapter(adapter2);

        //Create start time minute Spinner
        final Spinner minute = (Spinner) findViewById(R.id.start_time_spinner_minute);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.min_times, android.R.layout.simple_spinner_item);
        minute.setAdapter(adapter);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        minute.setAdapter(adapter3);

        //Create end time minute Spinner
        final Spinner minute2 = (Spinner) findViewById(R.id.end_time_spinner_minute);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.min_times, android.R.layout.simple_spinner_item);
        minute2.setAdapter(adapter);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        minute.setAdapter(adapter3);
        Button addEventDialog = findViewById(R.id.add_event_button);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.start_date_button:
                // Get a calendar instance
                Calendar cal = Calendar.getInstance();

                // Create a DatePickerDialog
                DatePickerDialog datePicker = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(
                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth)
                            {
                                Log.i(TAG, String.format(
                                        "Date Chosen -- day: %d, month: %d, year: %d",
                                        dayOfMonth,
                                        monthOfYear,
                                        year));
                            }
                        }, cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH));

                // Set the title and show the dialog
                datePicker.setTitle("Choose a Date");
                datePicker.show();
                break;
            case R.id.end_date_button:
                // Get a calendar instance
                Calendar cal2 = Calendar.getInstance();

                // Create a DatePickerDialog
                DatePickerDialog datePicker2 = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(
                                    DatePicker view,
                                    int year,
                                    int monthOfYear,
                                    int dayOfMonth)
                            {
                                Log.i(TAG,
                                        String.format(
                                                "Date Chosen -- day: %d, month: %d, year: %d",
                                                dayOfMonth,
                                                monthOfYear,
                                                year));
                            }
                        }, cal2.get(Calendar.YEAR),
                        cal2.get(Calendar.MONTH),
                        cal2.get(Calendar.DAY_OF_MONTH));

                // Set the title and show the dialog
                datePicker2.setTitle("Choose a Date");
                datePicker2.show();
                break;
            case R.id.btnOK:
                //TODO: implement all the data into the Event database
                Snackbar.make(v, "Event Added", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            case R.id.btnCancel:
                //TODO: setup closing the dialog if the "cancel" button is selected
        }


            }

    }



