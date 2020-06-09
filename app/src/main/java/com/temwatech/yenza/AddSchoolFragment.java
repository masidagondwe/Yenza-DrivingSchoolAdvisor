package com.temwatech.yenza;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;


public class AddSchoolFragment extends Fragment {
    private static final String TAG = "AddSchoolFragment";

    //
    private static final int SELECT_PICTURES = 10 ;

    //image URIs
    ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
    Uri imageUri;

    //
    int up = 0;
    int k =0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_school, container, false);
    }



    public void Upload(View view) {
        StorageReference filepath = FirebaseStorage.getInstance().getReference().child("school_images");

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

}