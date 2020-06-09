package com.temwatech.yenza.bottom_nav;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.temwatech.yenza.AddSchoolFragment;
import com.temwatech.yenza.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment implements View.OnClickListener {

    //
    private FloatingActionButton btnAddSchool;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        Log.d(TAG, "onCreateView Home Fragment: started.");

        btnAddSchool = homeFragmentView.findViewById(R.id.fab_add);

        btnAddSchool.setOnClickListener(this);

        return homeFragmentView;
    }



    @Override
    public void onClick(View v) {
        Log.d(TAG, "Home fragment: fab clicked");
        AddSchoolFragment fragment = new AddSchoolFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame, fragment, getString(R.string.tag_fragment_add_school));
    }
}
