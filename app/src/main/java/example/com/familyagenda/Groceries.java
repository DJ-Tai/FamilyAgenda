package example.com.familyagenda;


import android.content.ContentValues;
import android.content.Context;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public List<String> suggestions;
    public ArrayAdapter<String> arrayAdapterSuggestions;
    FamilyAgendaDbHelper dbHelper;

    private ArrayList<String> fetchGroceriesList(String isDone) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] selectionArgs = {isDone};
        Cursor cursor = db.query(
                FamilyAgendaContract.FamilyAgendaGroceries.TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_IS_DONE + " = ?",              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        ArrayList<String> list = new ArrayList<String>();
        while(cursor.moveToNext()) {
            String item = cursor.getString(
                    cursor.getColumnIndexOrThrow(FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_ITEM));
            list.add(item);
        }
        cursor.close();
        Set<String> tmp = new HashSet<>();
        tmp.addAll(list);
        list.clear();
        list.addAll(tmp);
        return list;
    }


    //Todo: not add if already there
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

    private void SetDone(String item, String value) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_IS_DONE, value);

        // Which row to update, based on the title
        String selection = FamilyAgendaContract.FamilyAgendaGroceries.COLUMN_NAME_ITEM + " LIKE ?";
        String[] selectionArgs = { item };

        db.update(FamilyAgendaContract.FamilyAgendaGroceries.TABLE_NAME, values, selection, selectionArgs);
    }

    private void getSuggestions()
    {
        suggestions = fetchGroceriesList("TRUE");
        Set<String> tmp = new HashSet<>();
        for (String item : suggestions)
            if (groceries.indexOf(item) == -1)
                tmp.add(item);
        suggestions.clear();
        suggestions.addAll(tmp);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_groceries, container, false);
        dbHelper = new FamilyAgendaDbHelper(getContext());
        ListView lv = view.findViewById(R.id.groceries_list);
        ListView lv_suggestions = view.findViewById(R.id.groceries_suggestions);
        groceries = fetchGroceriesList("FALSE");
        getSuggestions();
        arrayAdapter = new GroceriesItemList(view.getContext(), R.layout.groceries_items_list, groceries);
        arrayAdapterSuggestions = new GroceriesSuggestedItemsList(view.getContext(), R.layout.groceries_suggested_items_list, suggestions);
        lv.setAdapter(arrayAdapter);
        lv_suggestions.setAdapter(arrayAdapterSuggestions);

        Button b = view.findViewById(R.id.btnAddItem);
        b.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    private void addItem(String newItem) {
        if (groceries.indexOf(newItem) != -1) //item already in list
        {
            Toast.makeText(getContext(), "Item already in the groceries list", Toast.LENGTH_SHORT).show();
        }
        else {
            arrayAdapter.add(newItem);
            addItemInDb(newItem);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnAddItem:
                EditText etNewItem = view.findViewById(R.id.etNewItem);
                if (etNewItem.getText().toString().isEmpty())
                    break;
                addItem(etNewItem.getText().toString());
                etNewItem.setText("");
                break;
            default:
                break;
        }
    }

    private class GroceriesItemList extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private GroceriesItemList(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.checkBox = convertView.findViewById(R.id.list_item_checkBox);
                viewHolder.title = convertView.findViewById(R.id.list_item_text);
                //viewHolder.button = (Button) convertView.findViewById(R.id.list_item_remove);
                convertView.setTag(viewHolder);
            }
            mainViewholder = (ViewHolder) convertView.getTag();
            /*mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();

                }
            }); */
            final ViewHolder finalMainViewholder = mainViewholder;
            mainViewholder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(), "CheckBox was clicked for list item " + position, Toast.LENGTH_SHORT).show();
                    if (finalMainViewholder.checkBox.isChecked())
                        SetDone(groceries.get(position), "TRUE");
                    else
                        SetDone(groceries.get(position), "FALSE");
                }
            });
            mainViewholder.title.setText(getItem(position));

            return convertView;
        }
    }

    private class GroceriesSuggestedItemsList extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private GroceriesSuggestedItemsList(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.button = convertView.findViewById(R.id.list_suggested_item);
                convertView.setTag(viewHolder);
            }
            mainViewholder = (ViewHolder) convertView.getTag();
            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem(suggestions.get(position));
                    arrayAdapterSuggestions.remove(suggestions.get(position));
                }
            });
            mainViewholder.button.setText(getItem(position));

            return convertView;
        }
    }
    public class ViewHolder {
        TextView title;
        CheckBox checkBox;
        Button button;
    }
}
