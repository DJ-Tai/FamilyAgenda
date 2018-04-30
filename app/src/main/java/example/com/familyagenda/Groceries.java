package example.com.familyagenda;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Groceries extends Fragment implements View.OnClickListener {


    public Groceries() {
        // Required empty public constructor
    }

    public View view;
    public List<String> groceries;
    public ArrayAdapter<String> arrayAdapter;
    FamilyAgendaDbHelper dbHelper;

    private void fetchGroceriesList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] selectionArgs = {"FALSE"};
        Cursor cursor = db.query(
                FamilyAgendaContract.FamilyAgendaGroceries.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_IS_DONE + " = ?",              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        groceries = new ArrayList<String>();
        while(cursor.moveToNext()) {
            String item = cursor.getString(
                    cursor.getColumnIndexOrThrow(FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_ITEM));
            groceries.add(item);
        }
        cursor.close();
    }

    private void addItemInDb(String itemText) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_ITEM, itemText);
        values.put(FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_IS_DONE, "FALSE");

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FamilyAgendaContract.FamilyAgendaGroceries.TABLE_NAME, null, values);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_groceries, container, false);
        dbHelper = new FamilyAgendaDbHelper(getContext());
        ListView lv = (ListView) view.findViewById(R.id.groceries_list);
        fetchGroceriesList();
        arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, groceries);
        lv.setAdapter(arrayAdapter);

        Button b = (Button) view.findViewById(R.id.btnAddItem);
        b.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnAddItem:
                EditText etNewItem = (EditText) view.findViewById(R.id.etNewItem);
                String itemText = etNewItem.getText().toString();
                arrayAdapter.add(itemText);
                addItemInDb(itemText);
                etNewItem.setText("");
                break;
            default:
                break;
        }
    }
}
