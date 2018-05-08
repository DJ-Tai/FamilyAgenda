package example.com.familyagenda;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class ToDo extends Fragment {

    FamilyAgendaDbHelper db;
    ArrayAdapter<String> som;
    ListView tasks;

    public ToDo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        db = new FamilyAgendaDbHelper(this.getContext());
        tasks = (ListView)container.findViewById(R.id.lstTask);
        return inflater.inflate(R.layout.fragment_to_do, container, false);
    }

    private void loadList()
    {
        ArrayList<String>list=db.gettodolist();
        if(som==null)
        {
            som = new ArrayAdapter<String>(this.getContext(),R.layout.row,R.id.eventtitle,list);
            tasks.setAdapter(som);
        }
        else
        {
            som.clear();
            som.addAll(list);
            som.notifyDataSetChanged();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem x) {
        switch (x.getItemId()){
            case R.id.Add:
                final EditText edit = new EditText(this.getContext());
                AlertDialog dialog = new AlertDialog.Builder(this.getContext())
                        .setTitle("Add to your to-do list.")
                        .setMessage("Done")
                        .setView(edit)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int y) {
                                String task = String.valueOf(edit.getText());
                                db.newTask(task);
                                loadList();
                            }
                        })
                        .setNegativeButton("Cancel",null)
                        .create();
                dialog.show();
                return true;
        }
        return super.onOptionsItemSelected(x);
    }
    public void delete(View x)
    {
        View parent = (View)x.getParent();
        TextView task = (TextView)parent.findViewById(R.id.eventtitle);
        Log.e("String",(String) task.getText());
        String event = String.valueOf(task.getText());
        db.delete(event);
        loadList();
    }

}
