package com.schools.nyc.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.schools.nyc.R;
import com.schools.nyc.adapter.NYCSchoolsAdapter;
import com.schools.nyc.model.NYCSchoolsModel;
import com.schools.nyc.model.NYCSchoolsModelDetails;
import com.schools.nyc.ui.NYCSchoolsActivity;
import com.schools.nyc.utils.NYCProgressDialog;
import com.schools.nyc.viewmodel.NYCSchoolsViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NYCSchoolsFragment extends Fragment   {

    @BindView(R.id.places_list_recycler_view)
    RecyclerView nycSchoolsListRecyclerView;

    @BindView((R.id.empty_view))
    TextView emptyView;

    private View mView;

    private NYCSchoolsAdapter mAdapter;
    private ArrayList<NYCSchoolsModel> nycSchoolsModel;
    private NYCSchoolsViewModel nycSchoolsViewModel;
    private HashMap<String, NYCSchoolsModelDetails> nycSchoolsModelDetailsHashMap;


    public static NYCSchoolsFragment newInstance() {
        return new NYCSchoolsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mView==null){
            mView = inflater.inflate(R.layout.nyc_schools_list, container, false);
            ButterKnife.bind(this, mView);
            initRecyclerView();
            nycSchoolsViewModel = ViewModelProviders.of(this).get(NYCSchoolsViewModel.class);
            nycSchoolsViewModel.init();
            loadNYCSchoolsList();
        }



        return mView;
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        nycSchoolsListRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new NYCSchoolsAdapter(new ArrayList<>(), new HashMap<>(),null);
        nycSchoolsListRecyclerView.setAdapter(mAdapter);
    }



    @Override
    public void onStart() {
        super.onStart();
    }


    private void loadNYCSchoolsList() {

        NYCProgressDialog.showProgressDialog(getActivity(), "Loading NYC Schools...");
        nycSchoolsViewModel.getNYCSchoolLists().observe(this, nycSchoolsList -> {
            nycSchoolsModel = nycSchoolsList;

            nycSchoolsViewModel.getNYCSchoolSATDetails().observe(this,nycSchoolsModelDetails -> {
                NYCProgressDialog.dismissDialog();
                nycSchoolsModelDetailsHashMap = new HashMap<>();

                for(NYCSchoolsModel nycSchoolsModel : nycSchoolsModel)
                    for(NYCSchoolsModelDetails nycSchoolsModelDetails1 : nycSchoolsModelDetails){
                        if(nycSchoolsModel.getSchool_name().equalsIgnoreCase(nycSchoolsModelDetails1.getSchool_name())){
                            nycSchoolsModelDetailsHashMap.put(nycSchoolsModel.getSchool_name(),nycSchoolsModelDetails1);
                        }
                    }
                if (nycSchoolsList != null && nycSchoolsList != null) {
                    if (nycSchoolsList.size() > 0) {
                        mAdapter = new NYCSchoolsAdapter(nycSchoolsList,nycSchoolsModelDetailsHashMap,(NYCSchoolsActivity)getActivity());
                        mAdapter.notifyDataSetChanged();
                        nycSchoolsListRecyclerView.setAdapter(mAdapter);
                        NYCProgressDialog.dismissDialog();
                        emptyView.setVisibility(View.GONE);
                        nycSchoolsListRecyclerView.setVisibility(View.VISIBLE);
                    } else {
                        NYCProgressDialog.dismissDialog();
                        nycSchoolsListRecyclerView.setVisibility(View.GONE);
                        emptyView.setVisibility(View.VISIBLE);
                    }
                }
            });


        });

    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStop() {
        super.onStop();
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }
}
