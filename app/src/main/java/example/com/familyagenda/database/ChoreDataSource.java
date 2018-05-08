package example.com.familyagenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import example.com.familyagenda.Chore;
import example.com.familyagenda.FamilyAgendaDbHelper;

public class ChoreDataSource
{
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public ChoreDataSource(Context context)
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

    public Chore createChore(Chore chore)
    {
        ContentValues values = chore.toValues();
        mDatabase.insert(ChoresTable.TABLE_NAME, null, values);

        return chore;
    }

    public long getDataItemsCount()
    {
        return DatabaseUtils.queryNumEntries(mDatabase, ChoresTable.TABLE_NAME);
    }

    public void seedDatabase(ArrayList<Chore> choreList)
    {
        long numItems = getDataItemsCount();
        if (numItems == 0)
        {
            for (Chore chore : choreList)
            {
                try
                {
                    createChore(chore);
                } catch(SQLiteException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    // TODO: getAllItems()
}
