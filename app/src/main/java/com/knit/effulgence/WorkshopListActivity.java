package com.knit.effulgence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class WorkshopListActivity extends Activity {

    int branchId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workshop_listview);
        RecyclerView recList = (RecyclerView) findViewById(R.id.LvWorkshopList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b != null) {
            branchId = Integer.parseInt(b.get("BranchList").toString());
        }
        WorkshopCardArrayAdapter ca = new WorkshopCardArrayAdapter(createList());
        recList.setAdapter(ca);
    }
    private List<ContactInfo> createList() {
        List<ContactInfo> result = new ArrayList<>();
        String[] workshop = {"Ethical Hacking", "Live Website Design", "Astronomy",
                "PCB Designing","Matlab","Transportation Engineering"};
                for (int i=0; i < workshop.length; i++) {
                    ContactInfo ci = new ContactInfo();
                    ci.name = workshop[i];
                    ci.thumb = i;
                    result.add(ci);
                }
        return result;
    }
}
