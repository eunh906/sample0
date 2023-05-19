package com.example.myapplication.ui.home;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.HomeMainActivity;
import com.example.myapplication.R;
import com.example.myapplication.RetrofitClient;
import com.example.myapplication.databinding.FragmentWritingBinding;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WritingFragment extends Fragment {
    private Button btn_complete;
    public static ImageView postimage;
    private FragmentWritingBinding binding;
    private CheckBox cb_yes, cb_no;
    public static EditText titletxt;
    public static EditText contenttxt;
    private Button[] buttons = new Button[5];
    static Bitmap bitmap;
    static String deduction;
    static int user;
    static String tag;
    private static final int PERMISSION_REQUEST_CODE = 100;

    Uri uri;

    static String imagePath;
    Button addbutton;
    List<String> list = new ArrayList<>();
    List<String> taglist = list.stream().distinct().collect( Collectors.toList() );

    public void setButton(Button button){
        this.btn_complete = button;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWritingBinding.inflate( inflater, container, false);
        View root = binding.getRoot();

        tag = taglist.toString();

        titletxt = root.findViewById( R.id.titletext );
        contenttxt = root.findViewById( R.id.contenttext );

        cb_yes = root.findViewById(R.id.cbox_yes);
        cb_no = root.findViewById(R.id.cbox_no);

        postimage = root.findViewById( R.id.imageView4 );

        ActivityResultLauncher<Intent> activityResultLauncher =
                registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            uri = data.getData();
                            String[] filePathColumn = {MediaStore.Images.Media.DATA};
                            Cursor cursor = getContentResolver().query( uri, filePathColumn, null, null, null );
                            assert cursor != null;
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex( filePathColumn[0] );
                            imagePath = cursor.getString( columnIndex );
                            cursor.close();
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap( getContentResolver(), uri );
                                postimage.setImageBitmap( bitmap );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } );

        postimage.setOnClickListener( view -> {
            Intent intent = new Intent( Intent.ACTION_PICK );
            intent.setData( MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
            activityResultLauncher.launch( intent );
        });

        buttons[0] = root.findViewById(R.id.btn_ha);
        buttons[1] = root.findViewById(R.id.btn_dn);
        buttons[2] = root.findViewById(R.id.btn_clothes);
        buttons[3] = root.findViewById(R.id.btn_goods);
        buttons[4] = root.findViewById(R.id.btn_book);

        buttons[0].setOnClickListener(btnhaListener);
        buttons[1].setOnClickListener(btndnListener);
        buttons[2].setOnClickListener(btnclothesListener);
        buttons[3].setOnClickListener(btngoodsListener);
        buttons[4].setOnClickListener(btnbookListener);

        cb_yes.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_yes.isChecked()) {
                    cb_no.setChecked(false);
                }
                deduction = "O";
            }
        });

        cb_no.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_no.isChecked()) {
                    cb_yes.setChecked(false);
                }
                deduction = "X";
            }
        });
        return root;
    }
    View.OnClickListener btnhaListener = new View.OnClickListener() {
        int count;
        int i;
        @Override
        public void onClick(View view) {
            count=0;
            i=0;
            while(true) {
                if(buttons[i].isSelected()) {
                    count++;
                    list.add( "가전제품" );
                }
                i++;
                if(i>4 || count>3) break;
            }
            list.remove( "가전제품" );
            System.out.println(i);
            System.out.println(count);
            if( buttons[0].isSelected() ) {
                buttons[0].setSelected(false);
            } else if(count >= 3) {
                buttons[0].setSelected(false);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "태그는 3개 이상 선택할 수 없습니다.",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                buttons[0].setSelected(true);
            }
        }
    };

    View.OnClickListener btndnListener = new View.OnClickListener() {
        int count;
        int i;
        @Override
        public void onClick(View view) {
            count=0;
            i=0;
            while(true) {
                if(buttons[i].isSelected()) {
                    list.add( "생활용품" );
                    count++;
                }
                i++;
                if(i>4 || count>3) break;
            }
            list.remove( "생활용품" );
            System.out.println(i);
            System.out.println(count);
            if( buttons[1].isSelected() ) {
                buttons[1].setSelected(false);
            } else if(count >= 3) {
                buttons[1].setSelected(false);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "태그는 3개 이상 선택할 수 없습니다.",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                buttons[1].setSelected(true);
            }
        }
    };

    View.OnClickListener btnclothesListener = new View.OnClickListener() {
        int count;
        int i;
        @Override
        public void onClick(View view) {
            count=0;
            i=0;
            while(true) {
                if(buttons[i].isSelected()) {
                    list.add( "옷" );
                    count++;
                }
                i++;
                if(i>4 || count>3) break;
            }
            list.remove( "옷" );
            System.out.println(i);
            System.out.println(count);
            if( buttons[2].isSelected() ) {
                buttons[2].setSelected(false);
            } else if(count >= 3) {
                buttons[2].setSelected(false);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "태그는 3개 이상 선택할 수 없습니다.",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                buttons[2].setSelected(true);
            }
        }
    };

    View.OnClickListener btngoodsListener = new View.OnClickListener() {
        int count;
        int i;
        @Override
        public void onClick(View view) {
            count=0;
            i=0;
            while(true) {
                if(buttons[i].isSelected()) {
                    list.add( "잡화" );
                    count++;
                }
                i++;
                if(i>4 || count>3) break;
            }
            list.remove( "잡화" );
            System.out.println(i);
            System.out.println(count);
            if( buttons[3].isSelected() ) {
                buttons[3].setSelected(false);
            } else if(count >= 3) {
                buttons[3].setSelected(false);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "태그는 3개 이상 선택할 수 없습니다.",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                buttons[3].setSelected(true);
            }
        }
    };

    View.OnClickListener btnbookListener = new View.OnClickListener() {
        int count;
        int i;
        @Override
        public void onClick(View view) {
            count=0;
            i=0;
            while(true) {
                if(buttons[i].isSelected()) {
                    list.add( "책" );
                    count++;
                }
                i++;
                if(i>4 || count>3) break;
            }
            list.remove( "책" );
            System.out.println(i);
            System.out.println(count);
            if( buttons[4].isSelected() ) {
                buttons[4].setSelected(false);
            } else if(count >= 3) {
                buttons[4].setSelected(false);
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "태그는 3개 이상 선택할 수 없습니다.",Toast.LENGTH_SHORT);
                toast.show();
            } else {
                buttons[4].setSelected(true);
            }
        }
    };
    /*
    public static void upload(){
        String title = titletxt.getText().toString();
        String content = contenttxt.getText().toString();
        String status = "매칭중";
        user=1;

        if (imagePath != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress( Bitmap.CompressFormat.JPEG, 10, baos );
            bitmap = resize( bitmap );
            byte[] imageBytes = baos.toByteArray();
            final String imageString = Base64.encodeToString( imageBytes, Base64.NO_WRAP );

            Post input = new Post( user, title, content, tag, imageString, deduction, null, status );

            Call<Post> call = RetrofitClient.getApiService().postlist( input );
            call.enqueue( new Callback<Post>() {
                @Override
                public void onResponse(@Nullable Call<Post> call, @Nullable Response<Post> response) {

                }

                @Override
                public void onFailure(@Nullable Call<Post> call, @Nullable Throwable t) {
                }
            } );
        }
    }
    private ContentResolver getContentResolver() {
        return getActivity().getContentResolver();
    }

  */
    private ContentResolver getContentResolver() {
        return getActivity().getContentResolver();
    }
        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            if (context instanceof HomeMainActivity) {
                HomeMainActivity mainActivity = (HomeMainActivity) context;
                btn_complete = mainActivity.getButton();

                btn_complete.setOnClickListener( view -> {
                    if (bitmap != null) {
                        uploadImage( uri );
                    }
                    Intent intent = new Intent(getActivity(), HomeMainActivity.class);
                    startActivity( intent );
                } );
            }
        }
    private void uploadImage(Uri imageUri) {
        String title = titletxt.getText().toString();
        String content = contenttxt.getText().toString();
        File imageFile = new File( imagePath );

        RequestBody titleRequest = RequestBody.create( MediaType.parse( "text/plain" ), title);
        RequestBody contentRequest = RequestBody.create( MediaType.parse( "text/plain" ), content );
        RequestBody requestBody = RequestBody.create( MediaType.parse( "image/*" ), imageFile );
        MultipartBody.Part imagePart = MultipartBody.Part.createFormData( "image", imageFile.getName(), requestBody );

        Call<ResponseBody> call = RetrofitClient.getApiService().uploadPost( titleRequest, contentRequest, imagePart );

        call.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
// Write logic for successful response
                Log.d( "result", "success");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d( "result", "failure : " + t.getMessage() );
            }
        });
    }

    private Bitmap resize(Bitmap bm) {
        Configuration config = getResources().getConfiguration();
        if (config.smallestScreenWidthDp >= 800)
            bm = Bitmap.createScaledBitmap( bm, 240, 220, true );
        else if (config.smallestScreenWidthDp >= 600)
            bm = Bitmap.createScaledBitmap( bm, 200, 180, true );
        else if (config.smallestScreenWidthDp >= 400)
            bm = Bitmap.createScaledBitmap( bm, 160, 140, true );
        else if (config.smallestScreenWidthDp >= 360)
            bm = Bitmap.createScaledBitmap( bm, 120, 100, true );
        else
            bm = Bitmap.createScaledBitmap( bm, 100, 80, true );
        return bm;
    }

}