package example.com.familyagenda;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Groceries extends Fragment {


    public Groceries() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groceries, container, false);
        ListView lv = (ListView) view.findViewById(R.id.groceries_list);
        //db stuff
        FamilyAgendaDbHelper dbHelper = new FamilyAgendaDbHelper(getContext());
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

        List<String> groceries = new ArrayList<String>();
        while(cursor.moveToNext()) {
            String item = cursor.getString(
                    cursor.getColumnIndexOrThrow(FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_ITEM));
            groceries.add(item);
        }
        cursor.close();

        /*List<String> groceries = new ArrayList<String>();

        groceries.add("Nutella");
        groceries.add("Beer");
        groceries.add("Guacamole"); */

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, groceries);

        lv.setAdapter(arrayAdapter);
        // Inflate the layout for this fragment
        return view;
    }



}
