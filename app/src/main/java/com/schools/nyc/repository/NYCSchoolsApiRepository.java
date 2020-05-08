package com.schools.nyc.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.schools.nyc.model.NYCSchoolsModel;
import com.schools.nyc.model.NYCSchoolsModelDetails;
import com.schools.nyc.network.NYCSchoolsApi;
import com.schools.nyc.utils.NYCSchoolsUtils;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NYCSchoolsApiRepository {

    private NYCSchoolsApi nycSchoolsApi;
    private static NYCSchoolsApiRepository nycSchoolsApiRepository;

    private NYCSchoolsApiRepository() {
    }

    synchronized public static NYCSchoolsApiRepository getRepositoryInstance() {
        if (nycSchoolsApiRepository == null)
            nycSchoolsApiRepository = new NYCSchoolsApiRepository();

        return nycSchoolsApiRepository;
    }

    public void init() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        nycSchoolsApi = new Retrofit.Builder()
                .baseUrl(NYCSchoolsUtils.NYC_API_HOST)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NYCSchoolsApi.class);
    }

    public LiveData<ArrayList<NYCSchoolsModel>> getNYCSchoolsResults() {
        final MutableLiveData<ArrayList<NYCSchoolsModel>> data = new MutableLiveData<>();

        nycSchoolsApi.getNYCSchoolsResults().enqueue(new Callback<ArrayList<NYCSchoolsModel>>() {
            @Override
            public void onResponse(Call call, Response response) {
                data.setValue((ArrayList<NYCSchoolsModel>) response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("NYCSchoolRepository",t.getMessage());
            }
        });
        return data;
    }

    public LiveData<ArrayList<NYCSchoolsModelDetails>> getNYCSchoolsSATDetails() {
        final MutableLiveData<ArrayList<NYCSchoolsModelDetails>> data = new MutableLiveData<>();

        nycSchoolsApi.getNYCSchoolsSATDetails().enqueue(new Callback<ArrayList<NYCSchoolsModelDetails>>() {
            @Override
            public void onResponse(Call call, Response response) {
                data.setValue((ArrayList<NYCSchoolsModelDetails>) response.body());
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("NYCSchoolRepository",t.getMessage());
            }
        });
        return data;
    }
}
