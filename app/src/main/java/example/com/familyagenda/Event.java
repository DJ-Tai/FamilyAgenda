package example.com.familyagenda;

/*
    Edited by: David Taitingfong and Evan Pascual
 */

import android.content.ContentValues;

import java.util.UUID;

import example.com.familyagenda.database.EventsTable;

/**
 * Event objects for the Calendar
 */
public class Event
{
    /* Item ID for Database */
    private String eventId;

    /* Event Title */
    private String eventTitle;

    /* Event Description */
    private String desc;

    /* Event Date */
    private int year;
    private int month;
    private int dayOfMonth;

    /* Event Start and End times */
    private int startHour;
    private int startMinute;
    private String startTime;
    private int endHour;
    private int endMinute;
    private String endTime;

    /* If the Event repeats or not */
    private boolean repeats;

    /**
     * Default (empty) constructor
     */
    public Event() { }

    /**
     * Custom constructor
     *
     * @param id              - Unique ID
     * @param title           - Title of event
     * @param desc            - Description of event
     * @param repeats         - Event is repeatable
     * @param startHour   - Hour(in military time) that the event starts
     * @param startMinute - Minute that the event starts
     * @param endHour     - Hour(in military time) that the event ends
     * @param endMinute   - Minute that the event ends
     */
    public Event(String id, String title, String desc, int dayOfMonth, int month,
                 int year, boolean repeats, int startHour,
                 int startMinute, int endHour, int endMinute)
    {
        if (id == null)
        {
            id = UUID.randomUUID().toString();
        }

        this.eventId = id;
        this.eventTitle = title;
        this.desc = desc;
        this.repeats = repeats;
        this.dayOfMonth = dayOfMonth;
        this.month = month;
        this.year = year;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;

        this.formatStartAndEndTimes();
    }

    /**
     * Formats the Event time to a readable format
     */
    private void formatStartAndEndTimes()
    {
        String start_h = (startHour >= 0 && startHour < 10) ?
                            "0" + String.valueOf(startHour) : String.valueOf(startHour);

        String start_m = (startMinute >= 0 && startMinute < 10) ?
                        "0" + String.valueOf(startMinute) : String.valueOf(startMinute);

        String end_h = (endHour >= 0 && endHour < 10) ?
                        "0" + String.valueOf(endHour) : String.valueOf(endHour);

        String end_m = (endMinute >= 0 && endMinute < 10) ?
                        "0" + String.valueOf(endMinute) : String.valueOf(endMinute);

        this.startTime = start_h + ":" + start_m;
        this.endTime = end_h + ":" + end_m;
    }

    /* -------------- */
    /* GETTER METHODS */
    /*                */
    /* ============== */
    public String getEventId() { return eventId; }

    public String getEventTitle()
    {
        return eventTitle;
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

    public int getStartHour()
    {
        return startHour;
    }

    public int getStartMinute()
    {
        return startMinute;
    }

    public String getStartTime() { return startTime; }

    public int getEndHour()
    {
        return endHour;
    }

    public int getEndMinute()
    {
        return endMinute;
    }

    public String getEndTime() { return endTime; }

    /* -------------- */
    /* SETTER METHODS */
    /*                */
    /* ============== */
    public void setEventId(String newId) { eventId = newId; }

    public void setEventTitle(String newTitle)
    {
        eventTitle = newTitle;
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

    public void setStartHour(int newStartTimeHour)
    {
        startHour = newStartTimeHour;
    }

    public void setStartMinute(int newStartTimeMinute)
    {
        startMinute = newStartTimeMinute;
    }

    public void setEndHour(int newEndTimeHour)
    {
        endHour = newEndTimeHour;
    }

    public void setEndMinute(int newEndTimeMinute)
    {
        endMinute = newEndTimeMinute;
    }

    public void setStartTime(int s_h, int s_m)
    {
        this.startHour = s_h;
        this.startMinute = s_m;
        this.formatStartAndEndTimes();
    }

    public void setEndTime(int e_h, int e_m)
    {
        this.endHour = e_h;
        this.endMinute = e_m;
        this.formatStartAndEndTimes();
    }

    /**
     * Creates an Event as a ContentValues object to use with SQLiteDatabase
     *
     * @return values - Event as a ContentValues object
     */
    public ContentValues toValues()
    {
        ContentValues values = new ContentValues(5);    // 5 = number of columns in Calendar Table

        values.put(EventsTable.COLUMN_ID, eventId);
        values.put(EventsTable.COLUMN_TITLE, eventTitle);
        values.put(EventsTable.COLUMN_DESC, desc);
        values.put(EventsTable.COLUMN_START_TIME, getStartTime());
        values.put(EventsTable.COLUMN_END_TIME, getEndTime());

        return values;
    }

}
