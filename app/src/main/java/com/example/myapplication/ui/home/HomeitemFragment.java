package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.HomeMainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeitemBinding;
import com.example.myapplication.ui.chat.ChatFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeitemFragment extends Fragment {

    private ArrayList<Homeitem> homeitemList = new ArrayList<>();
    private RecyclerView hirecyclerView;
    private HomeitemAdapter homeitemAdapter;

    ImageView image;
    TextView chattext, match;
    Button listbutton;

    private FragmentHomeitemBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeitemBinding.inflate( inflater, container, false );
        View root = binding.getRoot();

        image = root.findViewById( R.id.imageview1 );

        chattext = root.findViewById( R.id.chattext );
        match = root.findViewById( R.id.matchtext );
        listbutton = root.findViewById( R.id.button3 );
        listbutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController( HomeitemFragment.this )
                        .navigate( R.id.action_homeitemFragment_to_navigation_home );
            }
        } );

        homeitemAdapter = new HomeitemAdapter( homeitemList );
        return root;
    }

    @Override
    public void onCreate(Bundle savveInstanceState){
        super.onCreate( savveInstanceState );
        homeitemData();
    }

    private void homeitemData() {
        homeitemList.add( new Homeitem("name",  "content","title", "date" ));
        homeitemList.add( new Homeitem("name1",  "content", "title", "date"));
        homeitemList.add( new Homeitem("name3",  "content", "title", "date"));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BottomNavigationView bottomnav = getActivity().findViewById( R.id.nav_view );
        bottomnav.setVisibility( View.VISIBLE );

    }
}