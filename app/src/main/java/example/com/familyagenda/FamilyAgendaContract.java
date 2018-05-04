package example.com.familyagenda;

import android.provider.BaseColumns;

/**
 * Created by Helidia on 4/17/2018.
 */

public final class FamilyAgendaContract
{
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FamilyAgendaContract()
    {
    }

    /* Inner class that defines the table contents */
    public static class FamilyAgendaGroceries implements BaseColumns
    {
        static final String TABLE_NAME = "groceries";
        static final String COLUMN_NAME_ITEM = "item";
        static final String COLUMN_NAME_IS_DONE = "is_done";
    }

    static final String SQL_CREATE_GROCERIES =
            "CREATE TABLE " + FamilyAgendaGroceries.TABLE_NAME + " (" +
                    FamilyAgendaGroceries._ID + " INTEGER PRIMARY KEY," +
                    FamilyAgendaGroceries.COLUMN_NAME_ITEM + " TEXT," +
                    FamilyAgendaGroceries.COLUMN_NAME_IS_DONE + " BOOLEAN)";

    static final String SQL_DELETE_GROCERIES =
            "DROP TABLE IF EXISTS " + FamilyAgendaGroceries.TABLE_NAME;


    /* SQL Strings for Calendar objects */
    public static class FamilyAgendaEvents implements BaseColumns
    {
        static final String TABLE_NAME = "events";
        static final String COLUMN_ID = "eventId";  // Unsure if we'll need this
        static final String COLUMN_TITLE = "eventTitle";
        static final String COLUMN_DESC = "description";
        static final String COLUMN_START = "startTime";
        static final String COLUMN_END = "endTime";

        public static final String SQL_CREATE  =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        COLUMN_ID + " TEXT PRIMRARY KEY," +
                        COLUMN_TITLE + " TEXT," +
                        COLUMN_DESC + " TEXT," +
                        COLUMN_START + " TEXT," +
                        COLUMN_END + " TEXT" + ");";

        public static final String SQL_DELETE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
