package com.temwatech.yenza.bottom_nav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.temwatech.yenza.MainActivity;
import com.temwatech.yenza.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment implements View.OnClickListener {

    //
    private FloatingActionButton btnAddSchool;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Log.d(TAG, "onCreateView Home Fragment: started.");

        btnAddSchool = view.findViewById(R.id.fab_add);

        btnAddSchool.setOnClickListener(this);



        Log.d(TAG, "initRecyclerView: after fab click.");
        //findMatches();

        return view;

    }






    @Override
    public void onClick(View v) {

    }
}
