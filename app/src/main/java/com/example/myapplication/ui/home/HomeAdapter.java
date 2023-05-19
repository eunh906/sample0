package com.example.myapplication.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<Post> posts;
    private Context context;
    String BASE_URL = "http://10.0.2.2:5000/";

    public HomeAdapter(List<Post> posts, Context context){
        this.posts = posts;
        this.context = context;
    }
    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }
    private OnItemClickListener hitemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.hitemClickListener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.home, parent, false );

        return new HomeViewHolder( view );
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position){
        Post post = posts.get(position);
        String imageUrl = post.getImageUrl().replace("\\", "/");
        String url = BASE_URL+imageUrl;
        holder.title.setText(post.getTitle());
        holder.charity.setText(post.getContent());

        // Glide를 사용하여 이미지 로드 및 표시
        Glide.with(context)
                .load(url)
                .into(holder.getimage);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.getDecoder().decode(encodedString);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    @Override
    public int getItemCount(){
        return posts.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Bitmap stringToBitmap(String data){
        Bitmap bitmap = null;
        byte[] byteArray = Base64.getDecoder().decode(data);
        ByteArrayInputStream stream = new ByteArrayInputStream(byteArray);
        bitmap = BitmapFactory.decodeStream(stream);
        return bitmap;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        public TextView title, content, charity, date;
        public ImageView getimage;
        public Button button;
        public HomeViewHolder(View view) {
            super( view );
            title = view.findViewById( R.id.I_title );
            date = view.findViewById( R.id.textView2 );
            charity = view.findViewById( R.id.textView5 );
            getimage = view.findViewById( R.id.charity_image );
            button = view.findViewById( R.id.button );
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
}
