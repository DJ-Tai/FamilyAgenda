package example.com.familyagenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.util.ArrayList;

import example.com.familyagenda.database.EventsTable;

/**
 * Created by Helidia on 4/16/2018.
 */

public class FamilyAgendaDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "FamilyAgenda.db";
    private static final int DB_VERSION = 1;
    public static final String DB_Table = "Task";
    public static final String DB_COLUM = "TaskName";

    public FamilyAgendaDbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(FamilyAgendaContract.SQL_CREATE_GROCERIES);
        db.execSQL(EventsTable.SQL_CREATE_EVENTS);
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL",DB_Table,DB_COLUM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(FamilyAgendaContract.SQL_DELETE_GROCERIES);
        db.execSQL(EventsTable.SQL_DELETE_EVENTS);
        onCreate(db);
        String query = String.format("DELETE TABLE IF EXISTS %s",DB_Table);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void newTask(String task){
        SQLiteDatabase x = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COLUM,task);
        x.insertWithOnConflict(DB_Table,null,values,SQLiteDatabase.CONFLICT_REPLACE);
        x.close();
    }
    public void delete(String task)
    {
        SQLiteDatabase x = this.getWritableDatabase();
        x.delete(DB_Table,DB_COLUM+" - ?",new String[]{task});
        x.close();
    }
    public ArrayList<String> gettodolist()
    {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase x = this.getReadableDatabase();
        Cursor cur=x.query(DB_Table,new String[]{DB_COLUM},null,null,null,null,null);
        while(cur.moveToNext())
        {
            int index = cur.getColumnIndex(DB_COLUM);
            list.add(cur.getString(index));
        }
        cur.close();
        x.close();
        return list;
    }
}