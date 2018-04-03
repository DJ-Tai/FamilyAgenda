package example.com.familyagenda;

/*
    Edited by: David Taitingfong and Evan Pascual
 */

/**
 * Event objects for the Calendar
 */
public class Event
{
    /** Title of event */
    private String title;

    /** Description of event */
    private String desc;

    /** Date of Event */
    /*
    TODO: Figure out getter and setter for these variables
     */
    private int year;
    private int month;
    private int dayOfMonth;

    /** Members who are associated with the Event */
    //private Members[] members;

    /** Boolean for when the event is repeatable (e.g., birthdays, anniversaries) */
    private boolean repeats;

    /**
     * Default constructor
     *
     * @param title - Title of event
     * @param desc - Description of event
     * @param repeats - Event is repeatable
     */
    public Event(String title, String desc, boolean repeats)
    {
        this.title = title;
        this.desc = desc;
        this.repeats = repeats;
    }

    /**
     * Getter for Event title
     *
     * @return - Title of event
     */
    public String getTitle() { return title; }

    /**
     * Getter for Event description
     *
     * @return - Description for event
     */
    public String getDesc() { return desc; }

    /**
     * Getter for Event's repeatable option
     *
     * @return - True, if Event repeats
     */
    public boolean isRepetitive() { return repeats; }



}
