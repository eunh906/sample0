package com.example.myapplication.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentUserInfoBinding;

public class UserInfoFragment extends Fragment{
    private FragmentUserInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserInfoBinding.inflate( inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}
