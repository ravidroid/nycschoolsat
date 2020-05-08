package com.schools.nyc.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.schools.nyc.BR;
import com.schools.nyc.R;
import com.schools.nyc.databinding.NycSchoolsRecyclerListRowBinding;
import com.schools.nyc.model.NYCSchoolsModel;
import com.schools.nyc.model.NYCSchoolsModelDetails;
import com.schools.nyc.ui.NYCSchoolsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;

public class NYCSchoolsAdapter extends RecyclerView.Adapter<NYCSchoolsAdapter.ViewHolder> {

    private ArrayList<NYCSchoolsModel> mNYCSchoolsModels;
    private  HashMap<String,NYCSchoolsModelDetails> nycSchoolsModelDetailsHashMap;
    private NYCSchoolsActivity mnycSchoolsActivity;

    public NYCSchoolsAdapter(ArrayList<NYCSchoolsModel> nycSchoolsModels, HashMap<String,NYCSchoolsModelDetails> nycDetailsArrayList,
                             NYCSchoolsActivity nycSchoolsActivity) {
        mNYCSchoolsModels = nycSchoolsModels;
        nycSchoolsModelDetailsHashMap = nycDetailsArrayList;
        mnycSchoolsActivity = nycSchoolsActivity;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {

        NycSchoolsRecyclerListRowBinding nycSchoolsRecyclerListRowBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.nyc_schools_recycler_list_row, parent, false);
        return new ViewHolder(nycSchoolsRecyclerListRowBinding);
    }

    public ArrayList<NYCSchoolsModel> getPlacesResults() {
        return mNYCSchoolsModels;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NYCSchoolsModel nycSchoolsModel = mNYCSchoolsModels.get(position);
        holder.bind(nycSchoolsModel);
    }

    @Override
    public int getItemCount() {
        if (mNYCSchoolsModels == null || mNYCSchoolsModels.size() == 0)
            return 0;
        return Math.min(mNYCSchoolsModels.size(), 20);
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        NycSchoolsRecyclerListRowBinding nycSchoolsRecyclerListRowBinding;

        public ViewHolder(NycSchoolsRecyclerListRowBinding nycSchoolsRecyclerListRowBinding) {
            super(nycSchoolsRecyclerListRowBinding.getRoot());
            nycSchoolsRecyclerListRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NYCSchoolsModel nycSchoolsModel =  nycSchoolsRecyclerListRowBinding.getNycSchoolsList();
                    mnycSchoolsActivity.showNYCFDetailsragment( nycSchoolsModelDetailsHashMap.get(nycSchoolsModel.getSchool_name()));
                }
            });
            this.nycSchoolsRecyclerListRowBinding = nycSchoolsRecyclerListRowBinding;
        }

        public void bind(NYCSchoolsModel nycSchoolsModel) {
            nycSchoolsRecyclerListRowBinding.setVariable(BR.nycSchoolsList, nycSchoolsModel);
            nycSchoolsRecyclerListRowBinding.executePendingBindings();
        }


    }
}
