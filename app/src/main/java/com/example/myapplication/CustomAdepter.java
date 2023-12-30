package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdepter extends RecyclerView.Adapter<CustomAdepter.MyViewHolder> {

    private Context context;
    private List<model> list;
    public CustomAdepter(Context context ,List<model> list){
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public CustomAdepter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdepter.MyViewHolder holder, int position) {
        model addM = list.get(position);

        //holder.id_txt.setText(addM.getId());
        holder.name_txt.setText(addM.getName());
        holder.price_txt.setText(addM.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id_txt, name_txt, price_txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //id_txt = itemView.findViewById(R.id.itemId);
            name_txt = itemView.findViewById(R.id.itemName);
            price_txt = itemView.findViewById(R.id.itemPrice);
        }
    }
}
