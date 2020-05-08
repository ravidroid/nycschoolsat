package com.schools.nyc.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NYCSchoolsModelDetails implements Parcelable {

    private String dbn;
    private String school_name;
    private String num_of_sat_test_takers;
    private String sat_critical_reading_avg_score;
    private String sat_math_avg_score;
    private String sat_writing_avg_score;
    public String empty = "N/A";

    public String getDbn() {
        return dbn;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getNum_of_sat_test_takers() {
        return num_of_sat_test_takers;
    }

    public String getSat_critical_reading_avg_score() {
        return sat_critical_reading_avg_score;
    }

    public String getSat_math_avg_score() {
        return sat_math_avg_score;
    }

    public String getSat_writing_avg_score() {
        return sat_writing_avg_score;
    }



    protected NYCSchoolsModelDetails(Parcel in) {
    }

    public static final Creator<NYCSchoolsModelDetails> CREATOR = new Creator<NYCSchoolsModelDetails>() {
        @Override
        public NYCSchoolsModelDetails createFromParcel(Parcel in) {
            return new NYCSchoolsModelDetails(in);
        }

        @Override
        public NYCSchoolsModelDetails[] newArray(int size) {
            return new NYCSchoolsModelDetails[size];
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
