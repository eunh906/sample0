package com.example.myapplication.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeitemAdapter extends RecyclerView.Adapter<HomeitemAdapter.HomeitemViewHolder> {

    private ArrayList<Homeitem> homeitemdata;

    public class HomeitemViewHolder extends RecyclerView.ViewHolder{
        public TextView name, text, title, date;

        public HomeitemViewHolder(View view) {
            super( view );
            name = view.findViewById( R.id.charityname );
            text = view.findViewById( R.id.content1 );
            title = view.findViewById( R.id.title1 );
            date = view.findViewById( R.id.date );

        }
    }
    public HomeitemAdapter(ArrayList<Homeitem> homeitemdata){
        this.homeitemdata = homeitemdata;
    }

    @NonNull
    @Override
    public HomeitemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.homeitem, parent, false );
        return new HomeitemViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull HomeitemViewHolder holder, int position){
        holder.name.setText(homeitemdata.get( position ).getName());
        holder.text.setText( homeitemdata.get( position ).getText());
        holder.title.setText( homeitemdata.get(position).getTitle());
        holder.date.setText( homeitemdata.get(position).getDate());
      }

    @Override
    public int getItemCount(){
        return homeitemdata.size();
    }
}
