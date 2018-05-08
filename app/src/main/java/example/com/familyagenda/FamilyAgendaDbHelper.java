package example.com.familyagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import example.com.familyagenda.database.ChoresTable;
import example.com.familyagenda.database.EventsTable;

/**
 * Created by Helidia on 4/16/2018.
 */

public class FamilyAgendaDbHelper extends SQLiteOpenHelper
{
    public static final String DB_NAME = "FamilyAgenda.db";
    public static final int DB_VERSION = 1;

    public FamilyAgendaDbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(FamilyAgendaContract.SQL_CREATE_GROCERIES);
        db.execSQL(EventsTable.SQL_CREATE_EVENTS);
        db.execSQL(ChoresTable.SQL_CREATE_CHORES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(FamilyAgendaContract.SQL_DELETE_GROCERIES);
        db.execSQL(EventsTable.SQL_DELETE_EVENTS);
        db.execSQL(ChoresTable.SQL_DELETE_CHORES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
}