package com.temwatech.yenza;

import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder> {
    @NonNull
    @Override
    public SchoolAdapter.SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapter.SchoolViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SchoolViewHolder extends RecyclerView.ViewHolder {
        ArrayList<Image> imageDeal;
        TextView tvSchoolName;
        TextView tvSchoolDescription;
        TextView tvAverageRating;
        TextView tvNoOfReviews;
        TextView tvLocation;
        CardView cardView;

        public SchoolViewHolder(View itemView) {
            super(itemView);
        }
    }
}
