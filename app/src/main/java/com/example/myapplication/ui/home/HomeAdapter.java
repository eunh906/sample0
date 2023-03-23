package com.example.myapplication.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context context;
    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }
    private OnItemClickListener hitemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.hitemClickListener = listener;
    }

    private ArrayList<Home> cdata;

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        public TextView title, content, charity;

        public HomeViewHolder(View view) {
            super( view );
            title = view.findViewById( R.id.title );
            content = view.findViewById( R.id.content );
            charity = view.findViewById( R.id.textView5 );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (hitemClickListener != null) {
                            hitemClickListener.onItemClick( view, pos );
                        }
                    }
                }
            } );
        }
    }
    public HomeAdapter(ArrayList<Home> homedata){
        this.cdata = homedata;
        this.context = context;
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.home, parent, false );
        return new HomeViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position){
        holder.title.setText(cdata.get( position ).getTitle());
        holder.content.setText( cdata.get( position ).getContent());
        holder.charity.setText( cdata.get(position).getCharity() );
    }

    @Override
    public int getItemCount(){
        return cdata.size();
    }
}
