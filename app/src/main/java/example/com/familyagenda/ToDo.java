package example.com.familyagenda;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import example.com.familyagenda.test.ToDoEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToDo extends Fragment {
    //These global variables help with dialog boxes
    private String m_Text = "";
    private int m_num;
    private int amount =1;
    public ToDo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Declarations of textviews, arraylist,etc
        View view = inflater.inflate(R.layout.fragment_to_do, container, false);
        TextView task1, task2, task3, task4, task5, task6;
        Button add, delete;
        final ArrayList<ToDoEvent> list = new ArrayList();
        final ArrayList<TextView> text = new ArrayList();
        task1 = view.findViewById(R.id.textView12);
        task2 = view.findViewById(R.id.textView14);
        task3 = view.findViewById(R.id.textView15);
        task4 = view.findViewById(R.id.textView16);
        task5 = view.findViewById(R.id.textView17);
        task6 = view.findViewById(R.id.textView18);
        text.add(task1);
        text.add(task2);
        text.add(task3);
        text.add(task4);
        text.add(task5);
        text.add(task6);
        add = view.findViewById(R.id.button12);
        delete = view.findViewById(R.id.button11);
        //Shows list
        for (int i = 0; i < list.size(); i++) {
            TextView temp = text.get(i);
            temp.setTextSize(25);
            temp.setText(list.get(i).getEvent());
        }
        add.setOnClickListener(new View.OnClickListener() {//The Add button and its properties
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Adding");
                final EditText input = new EditText(view.getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        String event = m_Text;
                        if (event.length() != 0) {
                            m_Text = "";
                            list.add(new ToDoEvent(event));
                            for (int i = 0; i < list.size(); i++) {
                                int temps = amount;
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override//Cancel button for popup menu
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            //The delete button and its properties
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Select the number to delete.");
                final EditText input = new EditText(view.getContext());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_num = Integer.parseInt(input.getText().toString());
                        if(m_num==1)
                        {
                         list.remove(0);
                            for (int j = 0; j < text.size(); j++) {
                                text.get(j).setText("");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                        else if(m_num==2)
                        {
                            list.remove(1);
                            for (int j = 0; j < text.size(); j++) {
                                text.get(j).setText("");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                        else if(m_num==3)
                        {
                            list.remove(2);
                            for (int j = 0; j < text.size(); j++) {
                                text.get(j).setText("");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                        else if(m_num==4)
                        {
                            list.remove(3);
                            for (int j = 0; j < text.size(); j++) {
                                text.get(j).setText("");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                        else if(m_num==5)
                        {
                            list.remove(4);
                            for (int j = 0; j < text.size(); j++) {
                                text.get(j).setText("");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                        else if(m_num==6)
                        {
                            list.remove(5);
                            for (int j = 0; j < text.size(); j++) {
                                text.get(j).setText("");
                            }
                            for (int i = 0; i < list.size(); i++) {
                                TextView temp = text.get(i);
                                temp.setTextSize(25);
                                temp.setText((i+1)+". "+list.get(i).getEvent());
                            }
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override//Cancel button for popup menu
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        return view;
    }
}
