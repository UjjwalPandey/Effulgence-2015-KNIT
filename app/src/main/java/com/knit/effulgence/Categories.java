package com.knit.effulgence;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;


public class Categories extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
    View rootView =  inflater.inflate(R.layout.categories, container, false);
    final RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.rvCategoriesList);
    recList.setHasFixedSize(true);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recList.setLayoutManager(llm);
    CategoryCardArrayAdapter adapter = new CategoryCardArrayAdapter(createList());
    recList.setAdapter(adapter);
    return rootView;

    }

    private List<ContactInfo> createList() {

        List<ContactInfo> result = new ArrayList<>();
        String[] category = {"Events", "Workshops", "Sponsors"};
        Integer[] thumb = {R.drawable.events, R.drawable.workshop,R.drawable.sponsor};
        for (int i=0; i < category.length; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = category[i];
            ci.branchId=thumb[i];
            ci.thumb = i;
            result.add(ci);
        }
        return result;
    }
}