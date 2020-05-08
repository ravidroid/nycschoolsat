package com.schools.nyc.ui.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.schools.nyc.BR;
import com.schools.nyc.R;
import com.schools.nyc.model.NYCSchoolsModelDetails;



public class NYCSchoolsListDetails extends Fragment {

    private NYCSchoolsModelDetails nycSchoolsModelDetails;
    private String mParam2;

    public NYCSchoolsListDetails() {
    }


    public static NYCSchoolsListDetails newInstance(NYCSchoolsModelDetails nycSchoolsListDetails) {
        NYCSchoolsListDetails fragment = new NYCSchoolsListDetails();
        Bundle args = new Bundle();
        args.putParcelable("nycListDetails", nycSchoolsListDetails);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nycSchoolsModelDetails = getArguments().getParcelable("nycListDetails");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      ViewDataBinding nycSchoolsFragment_viewBinding =   DataBindingUtil.inflate(
                LayoutInflater.from(container.getContext()),
                R.layout.fragment_n_y_c_schools_list_details, container, false);
        nycSchoolsFragment_viewBinding.setVariable(BR.nycSchoolsListDetails, nycSchoolsModelDetails);
        nycSchoolsFragment_viewBinding.executePendingBindings();
        return nycSchoolsFragment_viewBinding.getRoot();
    }
}
