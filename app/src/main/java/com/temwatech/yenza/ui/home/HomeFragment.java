package com.temwatech.yenza.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.temwatech.yenza.MainActivity;
import com.temwatech.yenza.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    //
    private FloatingActionButton btnAddSchool;

    //
    private static final int SELECT_PICTURES = 10 ;

    //image URIs
    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
    Uri imageUri;

    //
    int up = 0;
    int k =0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.d(TAG, "onCreateView: started.");
       // mRecyclerView = view.findViewById(R.id.recycler_view_deals);
        btnAddSchool = view.findViewById(R.id.fab_add);

        btnAddSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES);
            }
        });



        Log.d(TAG, "initRecyclerView: after fab click.");
        //findMatches();

        return view;

     /*   homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PICTURES) {
            if (resultCode == MainActivity.RESULT_OK) {
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();
                    Log.i("count", String.valueOf(count));
                    int currentItem = 0;
                    while (currentItem < count) {
                        imageUri = data.getClipData().getItemAt(currentItem).getUri();


                        Log.i("uri", imageUri.toString());
                        mArrayUri.add(imageUri);
                        currentItem = currentItem + 1;
                    }
                    Log.i("listsize", String.valueOf(mArrayUri.size()));
                  //  Toast.makeText(this, ""+mArrayUri.size(), Toast.LENGTH_SHORT).show();
                } else if (data.getData() != null) {
                    String imagePath = data.getData().getPath();

                }
            }
        }
    }


    public void Upload(View view) {
        StorageReference filepath = FirebaseStorage.getInstance().getReference().child("gpic");

        while (up < mArrayUri.size()){

            filepath.child(mArrayUri.get(k).getLastPathSegment()).putFile(mArrayUri.get(k)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //Toast.makeText(MainActivity.this, "Uploaded", Toast.LENGTH_LONG).show();



                }
            });
            up++;
            k++;

        }

    }


}
