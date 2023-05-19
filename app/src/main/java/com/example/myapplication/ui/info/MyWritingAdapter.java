package com.example.myapplication.ui.info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MyWritingAdapter extends RecyclerView.Adapter<MyWritingAdapter.MyWritingViewHolder>{
    private Context context;
    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }
    private OnItemClickListener mwitemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mwitemClickListener = listener;
    }

    private ArrayList<MyWriting> cdata;

    public class MyWritingViewHolder extends RecyclerView.ViewHolder {
        public TextView title, content;

        public MyWritingViewHolder(View view) {
            super( view );
            title = view.findViewById( R.id.tv_name);
            content = view.findViewById( R.id.tv_content);

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION) {
                        if(mwitemClickListener != null) {
                            mwitemClickListener.onItemClick( view, pos);
                        }
                    }
                }
            });
            }
            }
        public MyWritingAdapter(ArrayList<MyWriting> mywritingdata){
            this.cdata = mywritingdata;
        }

    @NonNull
    @Override
    public MyWritingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from( parent.getContext() )
                .inflate(R.layout.my_writing_listview, parent, false );
        return new MyWritingViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyWritingViewHolder holder, int position) {
        holder.title.setText(cdata.get( position ).getTitle());
        holder.content.setText(cdata.get( position ).getContent());
    }

    @Override
    public int getItemCount() { return cdata.size(); }
}
