package com.knit.effulgence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EventCardListActivity extends Activity {
    int branchId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_listview);
        RecyclerView recList = (RecyclerView) findViewById(R.id.LvEventList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b != null) {
            branchId = Integer.parseInt(b.get("BranchList").toString());
        }
        EventCardArrayAdapter ca = new EventCardArrayAdapter(createList());
        recList.setAdapter(ca);
}
    private List<ContactInfo> createList() {

        List<ContactInfo> result = new ArrayList<>();
        String[] cse = {"Da Vinci", "Codigo", "Windows Piratage", "App Development","Puzzling Chamber",
                "Code Defraggler","No Mercy Coding","Debugging","Code Triangle","Cyber Quiz"};
        String[] me = {"Mechgripper", "Mad 4 CAD", "Contraction", "Mechanical Hydrobot", "Aqua-Crane"};
        String[] ee = {"Wiring Web", "Matpuzz", "Junkyard"};
        String[] el = {"Mine Hunter", "The Matrix", "Robo GP", "Bob the Builder"};
        String[] ce = {"Bond with the Best", "Cadanzo", "Hunt your Goal", "Inclinatus","Urbanismo","Suspendo Brucke"};
        String[] buizz = {"Biz Quiz", "Tempus Ride", "Marketing Mania", "Namo- The Genius"};
        String[] ppt = {"Technoscript", "N-Tech Script"};
        String[] cs = {"Counter Strike 1.6", "NFS- Most Wanted", "FIFA 12"};

            switch(branchId){
                case 0:
                    for (int i=0; i < cse.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = cse[i];
                        ci.branchId = 0;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 1:
                    for (int i=0; i < el.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = el[i];
                        ci.branchId = 1;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 2:
                    for (int i=0; i < ee.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = ee[i];
                        ci.branchId = 2;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 3:
                    for (int i=0; i < ce.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = ce[i];
                        ci.branchId = 3;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 4:
                    for (int i=0; i < me.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = me[i];
                        ci.branchId = 4;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 5:
                    for (int i=0; i < buizz.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = buizz[i];
                        ci.branchId = 5;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 6:
                    for (int i=0; i < cs.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = cs[i];
                        ci.branchId = 6;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;
                case 7:
                    for (int i=0; i < ppt.length; i++) {
                        ContactInfo ci = new ContactInfo();
                        ci.name = ppt[i];
                        ci.branchId = 7;
                        ci.thumb = i;
                        result.add(ci);
                    }
                    break;

            }
        return result;
    }
}
