package example.com.familyagenda;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


/**
 * Created by Evan on 4/26/18.
 */

/**
 * Creates and Dialog Fragment for adding a new Event
 * */
public class AddEventDialog extends AppCompatDialogFragment {
    //initializes the input options from user on the fragment
    private EditText eventName;
    private Button pickDate1;
    private Button pickDate2;
    private EditText description;
    private Spinner startTimeHour;
    private Spinner startTimeMin;
    private Spinner endTimeHour;
    private Spinner endTimeMin;
    private RadioButton startTimeAM;
    private RadioButton getStartTimePM;
    private RadioButton endTimeAM;
    private RadioButton endTimePM;
    private Button cancelDialogBox;
    private Button okDialogBox;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_event_custom_dialog_box, null);

        builder.setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //does nothing when the "Cancel" button is selected
                    }
                })
                .setPositiveButton("Add Event", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //TODO: pull the user input and set to variables
                        String name_of_event = eventName.getText().toString();
                        String description_of_event = description.getText().toString();

                    }
                });

        eventName = view.findViewById(R.id.eventName);
        pickDate1 = view.findViewById(R.id.start_date_button);
        pickDate2 = view.findViewById(R.id.end_date_button);
        description = view.findViewById(R.id.editText2);
        startTimeHour = view.findViewById(R.id.start_time_spinner_hour);
        startTimeMin = view.findViewById(R.id.start_time_spinner_minute);
        endTimeHour = view.findViewById(R.id.end_time_spinner_hour);
        endTimeMin = view.findViewById(R.id.end_time_spinner_minute);
        startTimeAM = view.findViewById(R.id.am_radio_button);
        getStartTimePM = view.findViewById(R.id.pm_radio_button);
        endTimeAM = view.findViewById(R.id.am_radio_button2);
        endTimePM = view.findViewById(R.id.pm_radio_button2);
        cancelDialogBox = view.findViewById(R.id.btnCancel);
        okDialogBox = view.findViewById(R.id.btnOK);

        return builder.create();

    }



}
