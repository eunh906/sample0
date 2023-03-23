package com.example.myapplication.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ChattingAdapter extends RecyclerView.Adapter<ChattingAdapter.ChattingViewHolder> {

    private ArrayList<Chatting> chatdata;

    public class ChattingViewHolder extends RecyclerView.ViewHolder{
        public TextView name, message;
        public ImageView userimage;

        public ChattingViewHolder(View view) {
            super( view );
            name = view.findViewById( R.id.ntext_other );
            message = view.findViewById( R.id.mtext );
            userimage = view.findViewById( R.id.imageView_o );
        }
    }
    public ChattingAdapter(ArrayList<Chatting> cdata){
        this.chatdata = cdata;
    }

    @NonNull
    @Override
    public ChattingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.chatting, parent, false );
        return new ChattingViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ChattingAdapter.ChattingViewHolder holder, int position){
        holder.name.setText(chatdata.get( position ).getName());
        holder.message.setText( chatdata.get( position ).getMessage() );
        holder.userimage.setImageResource( R.drawable.baseline_person_outline_24 );
      }

    @Override
    public int getItemCount(){
        return chatdata.size();
    }
}
