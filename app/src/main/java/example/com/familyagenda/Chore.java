package example.com.familyagenda;

import android.content.ContentValues;

import java.util.UUID;

import example.com.familyagenda.database.ChoresTable;

/**
 * Created by Alex on 4/17/2018.
 */

public class Chore
{
    private String choreId;

    private String name;


    Chore(String name)
    {
        this.choreId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() { return this.choreId; }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public ContentValues toValues()
    {
        ContentValues values = new ContentValues(ChoresTable.NUM_OF_COLUMNS);

        values.put(ChoresTable.COLUMN_ID, choreId);
        values.put(ChoresTable.COLUMN_CHORE, name);

        return values;
    }
}
