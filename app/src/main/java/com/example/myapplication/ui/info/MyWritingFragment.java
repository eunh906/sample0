package com.example.myapplication.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMyWritingBinding;

import java.util.ArrayList;

public class MyWritingFragment extends Fragment {
    private ArrayList<MyWriting> mywritingArrayList= new ArrayList<>();
    private RecyclerView mwrecyclerView;
    private MyWritingAdapter mywritingAdapter;
    private FragmentMyWritingBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyWritingBinding.inflate( inflater, container, false);
        View root = binding.getRoot();
        mwrecyclerView = root.findViewById( R.id.mwrecycler );
        mwrecyclerView.setHasFixedSize( true );
        mywritingAdapter = new MyWritingAdapter(mywritingArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        mwrecyclerView.setLayoutManager( layoutManager );
        mwrecyclerView.setAdapter( mywritingAdapter );
        mwrecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), 1));

        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mywritingData();
    }

    private void mywritingData() {
        mywritingArrayList.add( new MyWriting("title", "content1"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.mywriting_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.change:
                break;
            case R.id.delete:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
