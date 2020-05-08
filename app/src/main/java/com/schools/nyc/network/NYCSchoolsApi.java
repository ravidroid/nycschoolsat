package com.schools.nyc.network;

import com.schools.nyc.model.NYCSchoolsModel;
import com.schools.nyc.model.NYCSchoolsModelDetails;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NYCSchoolsApi {
   // https://data.cityofnewyork.us/resource/s3k6-pzi2.json
    @GET("resource/s3k6-pzi2.json?")
    Call<ArrayList<NYCSchoolsModel>> getNYCSchoolsResults();

    @GET("resource/f9bf-2cp4.json?")
    Call<ArrayList<NYCSchoolsModelDetails>> getNYCSchoolsSATDetails();

}
