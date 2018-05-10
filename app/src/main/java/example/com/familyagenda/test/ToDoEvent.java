package example.com.familyagenda.test;

/**
 * Created by DREW on 5/9/2018.
 */

public class ToDoEvent {
    private String event;
    private boolean done= false;

    public ToDoEvent(String event)
    {
        this.event=event;
    }
    public void setEvent(String event)
    {
        this.event = event;
    }
    public String getEvent()
    {
        return event;
    }
    public boolean getDone()
    {
        return done;
    }
    public void setDone()
    {
        done = true;
    }
}
