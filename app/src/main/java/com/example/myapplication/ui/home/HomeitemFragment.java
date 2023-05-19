package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeitemBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeitemFragment extends Fragment {

    private ArrayList<Homeitem> homeitemList = new ArrayList<>();
    private RecyclerView hirecyclerView;

    private ViewPager2 sliderViewPager;
    private LinearLayout layoutIndicator;
    private HomeitemAdapter homeitemAdapter;

    private int[] images = new int[] {
            R.drawable.default_image,
            R.drawable.rank0,
            R.drawable.app_logo
    };

    ImageView image;
    TextView chattext, match;
    Button listbutton;

    private FragmentHomeitemBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeitemBinding.inflate( inflater, container, false );
        View root = binding.getRoot();


        sliderViewPager = root.findViewById( R.id.sliderViewPager );
        layoutIndicator = root.findViewById( R.id.layoutIndicators );

        sliderViewPager.setOffscreenPageLimit(1);
        sliderViewPager.setAdapter(new ImageSliderAdapter(this, images));

        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.length);

        homeitemAdapter = new HomeitemAdapter( homeitemList );
        return root;
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count]; //이미지뷰 배열 생성. count 만큼
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getContext(),
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
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

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getContext(),
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getContext(),
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
}