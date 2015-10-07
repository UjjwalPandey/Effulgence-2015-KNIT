package com.knit.effulgence;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class About extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about, container, false);

        ExpandableListView ExpandList = (ExpandableListView) v.findViewById(R.id.elvAbout);
        ArrayList<Group> ExpListItems = SetStandardGroups();
        AboutExpandable ExpAdapter = new AboutExpandable(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        return v;
    }
    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"About Effulgence'15", "Contact Us", "Developed By"};
        String emails[] = {"anupamchatterjee93@gmail.com\n+919807202687", "krishnatrey25@gmail.com\n+919457266643",
                "roopaknijhara@gmail.com\n+918869952780", "adityatyagi230@gmail.com\n+918868077446",
                "nirupamsingh29@gmail.com\n+918052492242", "ujwalpande@gmail.com\n+918858327030"};
        String names[] = { "Anupam Chatterjee", "Saumya Krishnatrey", "Roopak Nijhara", "Aditya Tyagi",
                "Nirupam Singh", "Ujjwal Pandey"};
        int Images[] = { R.drawable.chatru, R.drawable.saumya, R.drawable.roopak, R.drawable.tyagi,
                R.drawable.niru, R.drawable.ujjwal};

        ArrayList<Group> list = new ArrayList<>();

        int contact_us = 4;
        int developers = 2;
        int j = 0;

        String group_name = group_names[0];
        Group gru = new Group();
        gru.setName(group_name);

        ArrayList<ContactInfo> ch_list = new ArrayList<>();

            ContactInfo ch_eff = new ContactInfo();
            ch_eff.name= "EFFULGENCE is an annual Techical Fest of KNIT Sultanpur.";
            ch_eff.email= null;
            ch_eff.thumb=R.drawable.knit;
            ch_list.add(ch_eff);

        gru.setItems(ch_list);
        list.add(gru);

        group_name = group_names[1];
        gru = new Group();
        gru.setName(group_name);

        ch_list = new ArrayList<>();
        for (; j < contact_us; j++) {
            ContactInfo ch = new ContactInfo();
            ch.name=names[j];
            ch.email=emails[j];
            ch.thumb=Images[j];
            ch_list.add(ch);
        }

        gru.setItems(ch_list);
        list.add(gru);

        group_name = group_names[2];
        gru = new Group();
        gru.setName(group_name);

        ch_list = new ArrayList<>();

        for (j=contact_us; j < contact_us+developers; j++) {
            ContactInfo ch = new ContactInfo();
            ch.name=names[j];
            ch.email=emails[j];
            ch.thumb=Images[j];
            ch_list.add(ch);
        }
        gru.setItems(ch_list);
        list.add(gru);

        return list;
    }
}