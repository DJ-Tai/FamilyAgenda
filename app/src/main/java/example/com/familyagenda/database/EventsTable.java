package example.com.familyagenda.database;

public class EventsTable
{
    public static final int NUM_OF_COLUMNS = 8; // Change as more columns are added

    public static final String TABLE_NAME = "events";
    public static final String COLUMN_ID = "eventId";  // Unsure if we'll need this
    public static final String COLUMN_TITLE = "eventTitle";
    public static final String COLUMN_DESC = "desc";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_START_TIME = "startTime";
    public static final String COLUMN_END_TIME = "endTime";

    public static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_TITLE, COLUMN_DESC,
                                                COLUMN_MONTH, COLUMN_DAY, COLUMN_YEAR,
                                                COLUMN_START_TIME, COLUMN_END_TIME };


    public static final String SQL_CREATE_EVENTS =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_TITLE + " TEXT," +
                    COLUMN_DESC + " TEXT," +
                    COLUMN_MONTH + " INTEGER," +
                    COLUMN_DAY + " INTEGER," +
                    COLUMN_YEAR + " INTEGER," +
                    COLUMN_START_TIME + " TEXT," +
                    COLUMN_END_TIME + " TEXT" + ");";

    public static final String SQL_DELETE_EVENTS =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
