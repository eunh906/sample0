package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.RetrofitClient;
import com.example.myapplication.databinding.FragmentHomeBinding;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private ArrayList<PostData> homeArrayList = new ArrayList<>();
    private ArrayList<PostData> data = new ArrayList<>();
    private ArrayList<PostData> getData = new ArrayList<>();
    private RecyclerView hrecyclerView;
    private HomeAdapter homeAdapter;
    private TextView button, button1, button2;

    TextView name, title, time;
    String getTitle, nickname, post_image;
    Date date;
    Button status;
    private List<Post> posts;

    private ViewGroup.LayoutParams layoutparams;
    private Toolbar toolbar;
    private RelativeLayout searchbar;

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate( inflater, container, false );
        View root = binding.getRoot();


        name = root.findViewById( R.id.textView5 );
        title = root.findViewById( R.id.I_title );
        time = root.findViewById( R.id.textView2 );

        button = root.findViewById( R.id.txtv_company_notice);
        button1 = root.findViewById( R.id.txtv_personal_notice);
        button2 = root.findViewById( R.id.txtv_writing);
        status = root.findViewById( R.id.button );

        hrecyclerView = root.findViewById( R.id.hrecycler );
        hrecyclerView.setHasFixedSize( true );

        posts = new ArrayList<>();
        homeAdapter = new HomeAdapter(posts, requireContext());
        hrecyclerView.setAdapter( homeAdapter );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity() );
        hrecyclerView.setLayoutManager( layoutManager );
        hrecyclerView.addItemDecoration(new DividerItemDecoration(root.getContext(), 1));

        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController( HomeFragment.this )
                        .navigate( R.id.action_navigation_home_to_writingFragment);
            }
        } );

        fetchPosts();
        return root;
    }

    private void fetchPosts(){
        Call<List<Post>> call = RetrofitClient.getApiService().getPosts();
        call.enqueue( new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    List<Post> fetchPost = response.body();
                    if(fetchPost != null){
                        posts.clear();
                        posts.addAll( fetchPost );
                        homeAdapter.notifyDataSetChanged();

                        Log.d("결과: ", "성공");
                    } else {
                        Log.d("결과: ", "실패");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("결과: ", "네트워크 오류");
            }
        } );
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
    public void onCreate(Bundle saveInstanceState){
        super.onCreate( saveInstanceState );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}