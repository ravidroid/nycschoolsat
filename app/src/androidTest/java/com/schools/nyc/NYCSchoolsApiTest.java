package com.schools.nyc;

import android.support.test.filters.LargeTest;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.schools.nyc.model.NYCSchoolsModel;
import com.schools.nyc.model.NYCSchoolsModelDetails;
import com.schools.nyc.network.NYCSchoolsApi;
import com.schools.nyc.utils.NYCSchoolsUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class NYCSchoolsApiTest {

    NYCSchoolsApi placesListService;

    CompositeDisposable mCompositeDisposable;
    /*@Test
    public void tesNYCSchoolApiResults() {
        mCompositeDisposable = new CompositeDisposable();

        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        NYCSchoolsApi requestInterface = new Retrofit.Builder()
                .baseUrl(NYCSchoolsUtils.NYC_API_HOST)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NYCSchoolsApi.class);

   requestInterface.getNYCSchoolsResults()
                .enqueue(new Callback<ArrayList<NYCSchoolsModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<NYCSchoolsModel>> call, Response<ArrayList<NYCSchoolsModel>> response) {
                        Assert.assertNotNull(response.body());

                    }

                    @Override
                    public void onFailure(Call<ArrayList<NYCSchoolsModel>> call, Throwable t) {

                    }
                });


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void tesNYCSchoolApiResultsDetails() {
        mCompositeDisposable = new CompositeDisposable();

        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        NYCSchoolsApi requestInterface = new Retrofit.Builder()
                .baseUrl(NYCSchoolsUtils.NYC_API_HOST)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NYCSchoolsApi.class);

        requestInterface.getNYCSchoolsSATDetails()
                .enqueue(new Callback<ArrayList<NYCSchoolsModelDetails>>() {
                    @Override
                    public void onResponse(Call<ArrayList<NYCSchoolsModelDetails>> call, Response<ArrayList<NYCSchoolsModelDetails>> response) {
                        Assert.assertNotNull(response.body());

                    }

                    @Override
                    public void onFailure(Call<ArrayList<NYCSchoolsModelDetails>> call, Throwable t) {

                    }
                });


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
