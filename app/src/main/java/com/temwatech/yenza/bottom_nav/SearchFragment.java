package com.temwatech.yenza.bottom_nav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.temwatech.yenza.R;

public class SearchFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View searchView = inflater.inflate(R.layout.fragment_search, container, false);
        //final TextView textView = searchView.findViewById(R.id.text_dashboard);

        return searchView;
    }
}
