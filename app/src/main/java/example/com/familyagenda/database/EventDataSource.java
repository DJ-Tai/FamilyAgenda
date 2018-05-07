package example.com.familyagenda.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import example.com.familyagenda.Event;
import example.com.familyagenda.FamilyAgendaDbHelper;


/**
 * EventDataSource is the only class that talks to the SQLiteOpenHelper class
 */
public class EventDataSource
{
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    /**
     * Constructor
     *
     * @param context
     */
    public EventDataSource(Context context)
    {
        this.mContext = context;
        mDbHelper = new FamilyAgendaDbHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open()
    {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close()
    {
        mDbHelper.close();
    }

    /**
     * Inserts Events into the SQLiteDatabase
     *
     * @param event - Event to be inserted
     * @return event
     */
    public Event createEvent(Event event)
    {
        ContentValues values = event.toValues();

        mDatabase.insert(EventsTable.TABLE_NAME, null, values);

        return event;
    }

    /**
     * Gets number of items (i.e., rows) in the SQLiteDatabase
     *
     * @return number of items/rows
     */
    public long getDataItemsCount()
    {
        return DatabaseUtils.queryNumEntries(mDatabase, EventsTable.TABLE_NAME);
    }

    /**
     * Creates the Database from the supplied List
     *
     * @param eventList - List of Events to create Database from
     */
    public void seedDatabase(List<Event> eventList)
    {
        long numItems = getDataItemsCount();
        if (numItems == 0)
        {
            for (Event event : eventList)
            {
                try
                {
                    createEvent(event);
                } catch (SQLiteException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Retrieves all Events from the Database
     *
     * @return eventItems - Events from the Database as a List
     */
    public List<Event> getAllItems(int month, int day, int year)
    {
        List<Event> eventItems = new ArrayList<>();
        Cursor cursor = null;
        String[] date = { String.valueOf(month),
                          String.valueOf(day),
                          String.valueOf(year) };

        cursor = mDatabase.query(EventsTable.TABLE_NAME,
                                 EventsTable.ALL_COLUMNS,
                                 EventsTable.COLUMN_MONTH + " = ? AND "
                                    + EventsTable.COLUMN_DAY + " = ? AND "
                                    + EventsTable.COLUMN_YEAR + " = ?",
                                    date,
                                 null,
                                 null,
                                 EventsTable.COLUMN_START_TIME + " DESC");

        // TODO: Verify why the COLUMN_START_TIME needs to be in DESCending order
        while (cursor.moveToNext())
        {
            Event event = new Event();
            event.setEventId(cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_ID)));
            event.setEventTitle(cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_TITLE)));
            event.setDesc(cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_DESC)));
            event.setDayOfMonth(cursor.getInt(cursor.getColumnIndex(EventsTable.COLUMN_DAY)));
            event.setMonth(cursor.getInt(cursor.getColumnIndex(EventsTable.COLUMN_MONTH)));
            event.setYear(cursor.getInt(cursor.getColumnIndex(EventsTable.COLUMN_YEAR)));

            String time = cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_START_TIME));
            String[] h_m = time.split(":");
            int hr = Integer.valueOf(h_m[0]);
            int min = Integer.valueOf(h_m[1]);
            event.setStartHour(hr);
            event.setStartMinute(min);
            event.setStartTime(hr, min);

            time = cursor.getString(cursor.getColumnIndex(EventsTable.COLUMN_END_TIME));
            h_m = time.split(":");
            hr = Integer.valueOf(h_m[0]);
            min = Integer.valueOf(h_m[1]);
            event.setEndHour(hr);
            event.setEndMinute(min);
            event.setEndTime(hr, min);

            eventItems.add(event);
        }

        cursor.close();

        return eventItems;
    }

}
