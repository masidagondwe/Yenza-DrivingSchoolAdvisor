package com.temwatech.yenza.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DrivingSchool implements Parcelable {

    private String id;
    private String school_name;
    private String school_description;
    private float avg_user_rating;
    private int no_of_reviews;
    private String location;

    private String ds_phone_number;
    private String ds_email;

    //1 driving school - M images
    private ArrayList<String> imageUrls;//private String imageUrl;
    private  ArrayList<String> imageNames;//private String imageName;

    //1 driving school - M services
    private String service_offered;
    private String service_price;

    //1 driving school - M user reviews and rating
    private String school_user_rating;
    private String school_user_review;


    protected DrivingSchool(Parcel in) {

    }

    public static final Creator<DrivingSchool> CREATOR = new Creator<DrivingSchool>() {
        @Override
        public DrivingSchool createFromParcel(Parcel in) {
            return new DrivingSchool(in);
        }

        @Override
        public DrivingSchool[] newArray(int size) {
            return new DrivingSchool[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
