package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList actGrid;

    ArrayList timeGrid;
    LayoutInflater inflater;




    public GridAdapter(Context context, ArrayList actGrid, ArrayList timeGrid) {
        this.context = context;
        this.actGrid = actGrid;
        this.timeGrid =timeGrid;

    }


    @Override
    public int getCount() {
        return actGrid.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) convertView = inflater.inflate(R.layout.block, null);


        TextView textView1 = convertView.findViewById(R.id.actGridtext);
        TextView textView2 = convertView.findViewById(R.id.timeGridtext);

        textView1.setText(actGrid.get(position).toString());
        textView2.setText(timeGrid.get(position).toString());

        return convertView;
    }
}
