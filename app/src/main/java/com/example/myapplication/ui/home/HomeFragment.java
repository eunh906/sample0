package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;


import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<Home> homeArrayList = new ArrayList<>();
    private RecyclerView hrecyclerView;
    private HomeAdapter homeAdapter;
    private Button button, button1, button2;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate( inflater, container, false );
        View root = binding.getRoot();
        hrecyclerView = root.findViewById( R.id.hrecycler );
        hrecyclerView.setHasFixedSize( true );
        homeAdapter = new HomeAdapter(homeArrayList);

        button = root.findViewById( R.id.button4 );
        button1 = root.findViewById( R.id.button5 );
        button2 = root.findViewById( R.id.button6 );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        hrecyclerView.setLayoutManager( layoutManager );
        hrecyclerView.setAdapter( homeAdapter );
        hrecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), 1));

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        homeAdapter.setOnItemClickListener( new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                NavHostFragment.findNavController( HomeFragment.this )
                        .navigate( R.id.action_navigation_home_to_homeitemFragment );
            }
        } );

    }
    @Override
    public void onCreate(Bundle savveInstanceState){
        super.onCreate( savveInstanceState );
        homeData();
    }

    private void homeData() {
        homeArrayList.add( new Home("tile",  "content1", "name"));
        homeArrayList.add( new Home("tile1",  "content2", "name1"));
        homeArrayList.add( new Home("title2",  "content3", "name2"));

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}