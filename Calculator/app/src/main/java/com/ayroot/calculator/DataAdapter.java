package com.ayroot.calculator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by airat on 23.04.2017.
 */

public class DataAdapter extends ArrayAdapter<String> {

    private static final String[] number ={
            "1","2","3","4","5","6","7","8","9","0"
    };

    Context Context;

    public DataAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId, number);
        this.Context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = (TextView) convertView;
        if (convertView==null) {
            convertView = new TextView(Context);
            label = (TextView) convertView;
        }
        label.setText(number[position]);
        return (convertView);
    }
    public String getItem(int position) {
        return number[position];
    }

}
