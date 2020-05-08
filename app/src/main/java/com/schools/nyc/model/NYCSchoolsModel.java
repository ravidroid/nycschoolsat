package com.schools.nyc.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NYCSchoolsModel implements Parcelable {

    private String dbn;
    private String school_name;
    private String boro;
    private String school_10th_seats;
    private String school_sports;
    private String attendance_rate;

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getSchool_10th_seats() {
        return school_10th_seats;
    }

    public void setSchool_10th_seats(String school_10th_seats) {
        this.school_10th_seats = school_10th_seats;
    }

    public String getSchool_sports() {
        return school_sports;
    }

    public void setSchool_sports(String school_sports) {
        this.school_sports = school_sports;
    }

    public String getAttendance_rate() {
        return attendance_rate;
    }

    public void setAttendance_rate(String attendance_rate) {
        this.attendance_rate = attendance_rate;
    }

    protected NYCSchoolsModel(Parcel in) {
    }

    public static final Creator<NYCSchoolsModel> CREATOR = new Creator<NYCSchoolsModel>() {
        @Override
        public NYCSchoolsModel createFromParcel(Parcel in) {
            return new NYCSchoolsModel(in);
        }

        @Override
        public NYCSchoolsModel[] newArray(int size) {
            return new NYCSchoolsModel[size];
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
