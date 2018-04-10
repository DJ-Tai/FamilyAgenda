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
    /**
     * Start time
     * */
    private int startTimeHour;
    private int startTimeMinute;
    /**
     * End time
     * */
    private int endTimeHour;
    private int endTimeMinute;

    // Members who are associated with the Event
    //private Members[] members;

    /** Boolean for when the event is repeatable (e.g., birthdays, anniversaries) */
    private boolean repeats;

    /**
     * Default constructor
     *
     * @param title - Title of event
     * @param desc - Description of event
     * @param repeats - Event is repeatable
     * @param startTimeHour - Hour(in military time) that the event starts
     * @param startTimeMinute - Minute that the event starts
     * @param endTimeHour - Hour(in military time) that the event ends
     * @param endTimeMinute - Minute that the event ends
     */
    public Event(String title, String desc, int dayOfMonth, int month, int year,
                 boolean repeats, int startTimeHour,
                 int startTimeMinute,int endTimeHour, int endTimeMinute)
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

    /**
     * Getter for Event title
     *
     * @return - Title of event
     */
    public String getTitle() { return title; }

    /**
     * Setter for the title of the event
     *
     * @param newTitle- new title name
     * */
    public void setTitle(String newTitle){title = newTitle;}

    /**
     * Getter for Event description
     *
     * @return - Description for event
     */
    public String getDesc() { return desc; }

    /**
     * Setter for the description of the event
     *
     * @param newDesc- new description
     * */
    public void setDesc(String newDesc){desc = newDesc;}

    /**
     * Getter for Event's repeatable option
     *
     * @return - True, if Event repeats
     */
    public boolean isRepetitive() { return repeats; }

    /**
     * Changes whether or not the event is repetitive
     * */
    public void changeRepetitive(){
        if(repeats){
            repeats = false;
        }
        else{
            repeats = true;
        }
}
    /**
     * Getter for the day of the month
     *
     * @return - the day of the month
     * */
    public int getDayOfMonth(){return dayOfMonth;}

    /**
     * Setter for the day of the month for the event
     *
     * @param newDay - sets the day of the month
     * */
    public void setDayOfMonth(int newDay){dayOfMonth = newDay;}

    /**
     * Getter for the month
     *
     * @return - the month
     * */
    public int getMonth(){return month;}

    /**
     * Setter for the month of the event
     *
     * @param newMonth- the new month (must be within 1 and 12)
     * */
    public void setMonth(int newMonth){
        if(newMonth <= 12 && newMonth > 0){
            month = newMonth;
        }
    }

    /**
     * Getter for the year of the event
     *
     * @return the year of the event
     * */
    public int getYear(){return year;}

    /**
     * Setter for the year of the event
     *
     * @param newYear- the new year of the event
     * */
    public void setYear(int newYear){
        year = newYear;
    }

    /**
     * Getter for Event start time hour
     *
     * @return - Hour of Start Time(in military time)
     * */
    public int getStartTimeHour(){return startTimeHour;}

    /**
     * Setter for the start time hour of the event
     *
     * @param newStartTimeHour- the new start time hour
     * */
    public void setStartTimeHour(int newStartTimeHour){
        startTimeHour = newStartTimeHour;
    }

    /**
     * Getter for Event start time minute
     *
     * @return startTimeMinute - Minute of Start Time
     * */
    public int getStartTimeMinute(){return startTimeMinute;}

    /**
     * Setter for the start time minute of the event
     *
     * @param newStartTimeMinute- the start time minute of the event
     * */
    public void setStartTimeMinute(int newStartTimeMinute) {
        startTimeMinute = newStartTimeMinute;
    }

    /**
     * Getter for Event end time hour
     *
     * @return - Hour of End Time(in military time)
     * */
    public int getEndTimeHour(){return endTimeHour;}

    /**
     * Setter for the end time hour of the event
     *
     * @param newEndTimeHour - the end time hour for the event
     * */
    public void setEndTimeHour(int newEndTimeHour) {
        endTimeHour = newEndTimeHour;
    }

    /**
     * Getter for Event end time minute
     *
     * @return - Minute of Start Time(in military time)
     * */
    public int getEndTimeMinute(){return endTimeMinute;}

    /**
     * Setter for the end time minute of the event
     *
     * @param newEndTimeMinute - new end time minute for the event
     * */
    public void setEndTimeMinute(int newEndTimeMinute) {
        endTimeMinute = newEndTimeMinute;
    }


}
