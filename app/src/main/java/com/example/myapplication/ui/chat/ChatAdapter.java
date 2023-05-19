package com.example.myapplication.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private Context context;
    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.itemClickListener = listener;
    }

    private ArrayList<Chat> data;

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        public TextView name, message;
        public ImageView image, match;

        public ChatViewHolder(View view) {
            super( view );
            name = view.findViewById( R.id.textView3 );
            message = view.findViewById( R.id.textView4 );
            match = view.findViewById( R.id.ImageView6 );
            image = view.findViewById( R.id.imageView4 );
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (itemClickListener != null) {
                            itemClickListener.onItemClick( view, pos );
                        }
                    }
                }
            } );
        }
    }
    public ChatAdapter(ArrayList<Chat> mydata){
        this.data = mydata;
        this.context = context;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.chat, parent, false );
        return new ChatViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position){
        holder.name.setText(data.get( position ).getName());
        holder.message.setText( data.get( position ).getMessage() );

    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
