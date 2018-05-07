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

    //
    // NOTE:
    //  SQLite info for Calendar is under the database package
    //

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

}
