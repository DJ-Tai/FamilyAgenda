package example.com.familyagenda;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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

        ArrayList<Chore> chores = new ArrayList<>();

        chores.add(new Chore("Laundry", 2017, 4, 17, false));
        chores.add(new Chore("Dishes", 2017, 4, 17, false));
        chores.add(new Chore("Feed the dog", 2017, 4, 17, false));

        //Creating an ArrayList to easily access every text object in the chores tab
        ArrayList<TextView> textViews = new ArrayList<>();
        TextView tempT1, tempT2, tempT3, TempT3, tempT4, tempT5, tempT6, tempT7, tempT8, tempT9, tempT10;

        tempT1 = (TextView) view.findViewById(R.id.textView1);
        tempT2 = (TextView) view.findViewById(R.id.textView2);
        tempT3 = (TextView) view.findViewById(R.id.textView3);
        tempT4 = (TextView) view.findViewById(R.id.textView4);
        tempT5 = (TextView) view.findViewById(R.id.textView5);
        tempT6 = (TextView) view.findViewById(R.id.textView6);
        tempT7 = (TextView) view.findViewById(R.id.textView7);
        tempT8 = (TextView) view.findViewById(R.id.textView8);
        tempT9 = (TextView) view.findViewById(R.id.textView9);
        tempT10 = (TextView) view.findViewById(R.id.textView10);

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

        for (int i = 0; i < chores.size(); i++) {
            TextView temp = textViews.get(i);
            temp.setText(chores.get(i).getName());
        }

        // Inflate the layout for this fragment

        return view;

    }

}
