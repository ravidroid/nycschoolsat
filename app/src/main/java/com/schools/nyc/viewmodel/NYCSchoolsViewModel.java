package com.schools.nyc.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.schools.nyc.model.NYCSchoolsModel;
import com.schools.nyc.model.NYCSchoolsModelDetails;
import com.schools.nyc.repository.NYCSchoolsApiRepository;

import java.util.ArrayList;

public class NYCSchoolsViewModel extends ViewModel {

    private NYCSchoolsApiRepository nycSchoolsApiRepository;

    public void init() {
        nycSchoolsApiRepository = NYCSchoolsApiRepository.getRepositoryInstance();
        nycSchoolsApiRepository.init();
    }

    public LiveData<ArrayList<NYCSchoolsModel>> getNYCSchoolLists() {
        return nycSchoolsApiRepository.getNYCSchoolsResults();
    }

    public LiveData<ArrayList<NYCSchoolsModelDetails>> getNYCSchoolSATDetails() {
        return nycSchoolsApiRepository.getNYCSchoolsSATDetails();
    }

}
