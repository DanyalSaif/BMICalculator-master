package com.techease.danyal.bmicalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Danyal on 26/07/17.
 */
public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] spinnerTypes;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] spinnerType) {
        this.context = applicationContext;
        this.spinnerTypes = spinnerType ;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return spinnerTypes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom, null);

        TextView names = (TextView) view.findViewById(R.id.custom);
        names.setText(spinnerTypes[i]);
        return view;
    }

}
