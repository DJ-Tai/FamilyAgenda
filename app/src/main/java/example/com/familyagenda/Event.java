package example.com.familyagenda;

/*
    Edited by: David Taitingfong and Evan Pascual
 */

import android.content.ContentValues;

/**
 * Event objects for the Calendar
 */
public class Event
{
    /* Event Title */
    private String title;

    /* Event Description */
    private String desc;

    /* Event Date */
    // TODO: Figure out getter and setter for these variables
    private int year;
    private int month;
    private int dayOfMonth;

    /* Start time */
    private int startTimeHour;
    private int startTimeMinute;

    /* End time */
    private int endTimeHour;
    private int endTimeMinute;

    /* If the Event repeats or not */
    private boolean repeats;

    /**
     * Default (empty) constructor
     */
    public Event()
    {
    }

    /**
     * Custom constructor
     *
     * @param title           - Title of event
     * @param desc            - Description of event
     * @param repeats         - Event is repeatable
     * @param startTimeHour   - Hour(in military time) that the event starts
     * @param startTimeMinute - Minute that the event starts
     * @param endTimeHour     - Hour(in military time) that the event ends
     * @param endTimeMinute   - Minute that the event ends
     */
    public Event(String title, String desc, int dayOfMonth, int month,
                 int year, boolean repeats, int startTimeHour,
                 int startTimeMinute, int endTimeHour, int endTimeMinute)
    {
        this.title = title;
        this.desc = desc;
        this.repeats = repeats;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
        this.startTimeHour = startTimeHour;
        this.startTimeMinute = startTimeMinute;
        this.endTimeHour = endTimeHour;
        this.endTimeMinute = endTimeMinute;
    }

    /* -------------- */
    /* GETTER METHODS */
    /*                */
    /* ============== */
    public String getTitle()
    {
        return title;
    }

    public String getDesc()
    {
        return desc;
    }

    public boolean isRepetitive()
    {
        return repeats;
    }

    public int getDayOfMonth()
    {
        return dayOfMonth;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public int getStartTimeHour()
    {
        return startTimeHour;
    }

    public int getStartTimeMinute()
    {
        return startTimeMinute;
    }

    public int getEndTimeHour()
    {
        return endTimeHour;
    }

    public int getEndTimeMinute()
    {
        return endTimeMinute;
    }

    /* -------------- */
    /* SETTER METHODS */
    /*                */
    /* ============== */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public void setDesc(String newDesc)
    {
        desc = newDesc;
    }

    public void changeRepetitive()
    {
        repeats = (repeats) ? false : true;
    }

    public void setDayOfMonth(int newDay)
    {
        dayOfMonth = newDay;
    }

    public void setMonth(int newMonth)
    {
        if (newMonth <= 12 && newMonth > 0)
        {
            month = newMonth;
        }
    }

    public void setYear(int newYear)
    {
        year = newYear;
    }

    public void setStartTimeHour(int newStartTimeHour)
    {
        startTimeHour = newStartTimeHour;
    }

    public void setStartTimeMinute(int newStartTimeMinute)
    {
        startTimeMinute = newStartTimeMinute;
    }

    public void setEndTimeHour(int newEndTimeHour)
    {
        endTimeHour = newEndTimeHour;
    }

    public void setEndTimeMinute(int newEndTimeMinute)
    {
        endTimeMinute = newEndTimeMinute;
    }


    // TODO: Not finished
    public ContentValues toValues()
    {
        ContentValues values = new ContentValues(); // Parameter = Number of columns in DB


        return values;
    }
}
