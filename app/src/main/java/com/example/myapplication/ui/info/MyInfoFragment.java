package com.example.myapplication.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMyInfoBinding;

public class MyInfoFragment extends Fragment {
    private FragmentMyInfoBinding binding;
    private TextView btn_userinfo, btn_mywriting;
    private de.hdodenhof.circleimageview.CircleImageView btn_profile;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMyInfoBinding.inflate( inflater, container, false);
        View root = binding.getRoot();

        btn_userinfo = root.findViewById( R.id.textView8 );
        btn_mywriting = root.findViewById( R.id.textView7 );
        btn_profile = root.findViewById( R.id.btn_profile );

        btn_userinfo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController( MyInfoFragment.this )
                        .navigate( R.id.action_navigation_inf_to_userinfoFragment);
            }
        } );

        btn_mywriting.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController( MyInfoFragment.this )
                        .navigate( R.id.action_navigation_inf_to_mywritingFragment);
            }
        } );

        btn_profile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController( MyInfoFragment.this )
                        .navigate( R.id.action_navigation_inf_to_profileFragment);
            }
        } );

        return root;
    }
}
