package com.knit.effulgence;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class Hospitality extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.hospitality, container, false);
        final RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.LvHospitalityList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        HospitalityCardArrayAdapter adapter = new HospitalityCardArrayAdapter(createList());
        recList.setAdapter(adapter);
        return rootView;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }



    private List<ContactInfo> createList() {

        List<ContactInfo> result = new ArrayList<ContactInfo>();
        String[] hospitality = {"Visit the Map", "How to  reach", "Trains Time Table", "Miscellaneous Details"};

        for (int i=0; i < hospitality.length; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = hospitality[i];
            ci.branchId = i;
            result.add(ci);
        }
        return result;
    }
}
