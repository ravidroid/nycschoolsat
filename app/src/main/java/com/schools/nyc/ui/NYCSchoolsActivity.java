package com.schools.nyc.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.schools.nyc.R;
import com.schools.nyc.model.NYCSchoolsModelDetails;
import com.schools.nyc.ui.fragments.NYCSchoolsFragment;
import com.schools.nyc.ui.fragments.NYCSchoolsListDetails;

import butterknife.ButterKnife;

public class NYCSchoolsActivity extends AppCompatActivity {

    ActionBar ab;
    NYCSchoolsFragment nycSchoolsListFragment;
    NYCSchoolsListDetails nycSchoolsListDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyc_schools);
        ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(true);
        ButterKnife.bind(this);
        showNYCFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void showNYCFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        nycSchoolsListFragment = NYCSchoolsFragment.newInstance();
        ft.replace(R.id.listcontainer, nycSchoolsListFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void showNYCFDetailsragment(NYCSchoolsModelDetails nycSchoolsModelDetails){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        nycSchoolsListDetails = NYCSchoolsListDetails.newInstance(nycSchoolsModelDetails);
        ft.replace(R.id.listcontainer, nycSchoolsListDetails);
        ft.addToBackStack(nycSchoolsListFragment.getClass().getName());
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
