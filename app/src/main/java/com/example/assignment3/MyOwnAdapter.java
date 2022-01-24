package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder>{

    ArrayList data1;
    ArrayList data2;
    Context ctx;

    public MyOwnAdapter(Context ct, ArrayList s1, ArrayList s2){
        ctx = ct;
        data1 = s1;
        data2 = s2;

    }

    @NonNull
    @Override
    public MyOwnAdapter.MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(ctx);
        View myOwnView = myInflater.inflate(R.layout.row, parent, false);
        return new MyOwnHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnAdapter.MyOwnHolder holder, int position) {
        holder.t1.setText(data1.get(position).toString());
        holder.t2.setText(data2.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder{
        TextView t1, t2;

        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.text1);
            t2 = (TextView) itemView.findViewById(R.id.text2);

        }
    }
}

