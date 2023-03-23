package com.example.myapplication.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentChatBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    private ArrayList<Chat> chatArrayList = new ArrayList<>();
    private RecyclerView mrecyclerView;
    private ChatAdapter chatAdapter;

    private BottomNavigationView nav_view;
    private FragmentChatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentChatBinding.inflate( inflater, container, false );
        View root = binding.getRoot();

        mrecyclerView = root.findViewById( R.id.recyclerview );
        mrecyclerView.setHasFixedSize( true );
        chatAdapter = new ChatAdapter(chatArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        mrecyclerView.setLayoutManager( layoutManager );
        mrecyclerView.setAdapter( chatAdapter );
        mrecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), 1));

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        chatAdapter.setOnItemClickListener( new ChatAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                NavHostFragment.findNavController( ChatFragment.this )
                        .navigate( R.id.action_navigation_chat_to_chattingFragment );
            }
        } );
    }
        @Override
    public void onCreate(Bundle savveInstanceState){
        super.onCreate( savveInstanceState );
        preparData();
    }

    private void preparData() {
        chatArrayList.add( new Chat("name",  "message1"));
        chatArrayList.add( new Chat("name1",  "message12"));
        chatArrayList.add( new Chat("name3",  "message123"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}