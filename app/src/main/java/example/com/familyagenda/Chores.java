package example.com.familyagenda;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chores extends Fragment {

    public Chores() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chores, container, false);

        /*
        This area takes care of the displaying of the choresList
         */
        final ArrayList<Chore> choresList = new ArrayList<>();
        final ArrayList<Button> buttonList = new ArrayList<>();

//        choresList.add(new Chore("Laundry"));

        //Creating an ArrayList to easily access every text object in the choresList tab
        final ArrayList<TextView> textViews = new ArrayList<>();
        TextView tempT1, tempT2, tempT3, tempT4, tempT5, tempT6, tempT7, tempT8, tempT9, tempT10;
        Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

        button1= view.findViewById((R.id.button1));
        button2 = view.findViewById((R.id.button2));
        button3 = view.findViewById((R.id.button3));
        button4 = view.findViewById((R.id.button4));
        button5 = view.findViewById((R.id.button5));
        button6 = view.findViewById((R.id.button6));
        button7 = view.findViewById((R.id.button7));
        button8 = view.findViewById((R.id.button8));
        button9 = view.findViewById((R.id.button9));
        button10 = view.findViewById((R.id.button10));

        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);
        buttonList.add(button10);

        tempT1 = view.findViewById(R.id.textView1);
        tempT2 = view.findViewById(R.id.textView2);
        tempT3 = view.findViewById(R.id.textView3);
        tempT4 = view.findViewById(R.id.textView4);
        tempT5 = view.findViewById(R.id.textView5);
        tempT6 = view.findViewById(R.id.textView6);
        tempT7 = view.findViewById(R.id.textView7);
        tempT8 = view.findViewById(R.id.textView8);
        tempT9 = view.findViewById(R.id.textView9);
        tempT10 = view.findViewById(R.id.textView10);

        textViews.add(tempT1);
        textViews.add(tempT2);
        textViews.add(tempT3);
        textViews.add(tempT4);
        textViews.add(tempT5);
        textViews.add(tempT6);
        textViews.add(tempT7);
        textViews.add(tempT8);
        textViews.add(tempT9);
        textViews.add(tempT10);

        //making all of the buttons invisible unless there is a chore there
        for (int i = 0; i < 10; i++) {
            Button tempButton = buttonList.get(i);
            tempButton.setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < choresList.size(); i++) {
            TextView temp = textViews.get(i);
            temp.setTextSize(25);
            temp.setText(choresList.get(i).getName());
        }


        /*
        This area will take care of adding in a new chore
         */

        Button bAddChore = (Button) view.findViewById(R.id.bAddChore);
        final EditText bChoreName = (EditText) view.findViewById(R.id.choreName);

        bAddChore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String choreName = bChoreName.getText().toString();
            if (choreName.length() != 0) {
                bChoreName.setText("");
                choresList.add(new Chore(choreName));

                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
            }
        });


        //deleting an event
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(0);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(1);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(2);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(3);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(4);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(5);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(6);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(7);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(8);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choresList.remove(9);
                for (int k = 0; k < buttonList.size(); k++) {
                    buttonList.get(k).setVisibility(View.INVISIBLE);
                }
                for (int j = 0; j < textViews.size(); j++) {
                    textViews.get(j).setText("");
                }
                for (int i = 0; i < choresList.size(); i++) {
                    TextView temp = textViews.get(i);
                    temp.setTextSize(25);
                    temp.setText(choresList.get(i).getName());
                    Button tempButton = buttonList.get(i);
                    tempButton.setVisibility(View.VISIBLE);
                }
            }
        });


        return view;

    }

}

