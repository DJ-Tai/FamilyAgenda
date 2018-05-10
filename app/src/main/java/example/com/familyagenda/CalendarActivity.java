package example.com.familyagenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Evan on 5/9/18.
 */

/**
 * Handles the Actions taken under Calendar fragment
 * */
public class CalendarActivity extends AppCompatActivity {
    //initialize the add event button in fragment
    private Button addEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calendar);

        //sets the casted button to a variable so an onClickListener can be applied
        addEventButton = (Button) findViewById(R.id.add_event_button);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //performs this function, defined outside of class
                openDialog();
            }
        });
    }
    /**
     * Creates an instance of a new AddEventDialog and opens it
     * */
    public void openDialog(){
        AddEventDialog newAddEventDialog = new AddEventDialog();
        newAddEventDialog.show(getSupportFragmentManager(), "Add event");
    }
}
