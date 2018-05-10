package example.com.familyagenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Evan on 5/9/18.
 */

public class CalendarActivity extends AppCompatActivity {
    private Button addEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calendar);

        addEventButton = (Button) findViewById(R.id.add_event_button);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        AddEventDialog newAddEventDialog = new AddEventDialog();
        newAddEventDialog.show(getSupportFragmentManager(), "Add event");
    }
}
