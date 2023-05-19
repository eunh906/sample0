package com.example.myapplication.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentChattingBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {

    private ArrayList<Chatting> chattingList = new ArrayList<>();
    private RecyclerView crecyclerView;
    private ChattingAdapter chattingAdapter;

    EditText editText;
    ImageView image, image1;


    private FragmentChattingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentChattingBinding.inflate( inflater, container, false );
        View root = binding.getRoot();

        crecyclerView = root.findViewById( R.id.c_recyclerView );
        image = root.findViewById( R.id.imageView2 );
        image1 = root.findViewById( R.id.imageView3 );

        editText = root.findViewById( R.id.editTextTextPersonName );
        String _message = editText.getText().toString();

        crecyclerView.setHasFixedSize( true );
        chattingAdapter = new ChattingAdapter( chattingList );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        crecyclerView.setLayoutManager( layoutManager );
        crecyclerView.setAdapter( chattingAdapter );

        return root;
    }

    @Override
    public void onCreate(Bundle savveInstanceState){
        super.onCreate( savveInstanceState );
        BottomNavigationView bottomNavigationView = getActivity().findViewById( R.id.nav_view );
        bottomNavigationView.setVisibility( View.GONE );
        chatData();
    }

    private void chatData() {
        chattingList.add( new Chatting("12:01",  "message1"));
        chattingList.add( new Chatting("12:01",  "message12"));
        chattingList.add( new Chatting("12:02",  "message123"));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BottomNavigationView bottomnav = getActivity().findViewById( R.id.nav_view );
        bottomnav.setVisibility( View.VISIBLE );

    }
}