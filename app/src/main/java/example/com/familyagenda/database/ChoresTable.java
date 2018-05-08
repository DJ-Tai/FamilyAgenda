package example.com.familyagenda.database;

public class ChoresTable
{
    public static final int NUM_OF_COLUMNS = 2;

    public static final String TABLE_NAME = "chores";
    public static final String COLUMN_ID = "choreId";
    public static final String COLUMN_CHORE = "choreName";

    public static final String[] ALL_COLUMNS = {
            TABLE_NAME, COLUMN_ID, COLUMN_CHORE
    };

    public static final String SQL_CREATE_CHORES =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_CHORE + " TEXT" + ");";

    public static final String SQL_DELETE_CHORES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
