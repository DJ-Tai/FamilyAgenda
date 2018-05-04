package example.com.familyagenda.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import example.com.familyagenda.Event;
import example.com.familyagenda.FamilyAgendaDbHelper;


/**
 * EventSource talks to the SQLiteOpenHelper
 */
public class EventSource
{
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    /**
     * Constructor
     *
     * @param context
     */
    public EventSource(Context context)
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

}
