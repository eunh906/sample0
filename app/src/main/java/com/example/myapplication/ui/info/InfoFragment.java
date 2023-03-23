package com.example.myapplication.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentInfoBinding;

public class InfoFragment  extends Fragment {
    private FragmentInfoBinding binding;
    TextView textview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentInfoBinding.inflate( inflater, container, false );
        View root = binding.getRoot();
        textview = root.findViewById( R.id.textView7 );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
