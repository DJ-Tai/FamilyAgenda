package example.com.familyagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Helidia on 4/16/2018.
 */

public class FamilyAgendaDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "FamilyAgenda.db";
    private static final int DB_VERSION = 1;

    public FamilyAgendaDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FamilyAgendaContract.SQL_CREATE_GROCERIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(FamilyAgendaContract.SQL_DELETE_GROCERIES);
        onCreate(db);
    }
}