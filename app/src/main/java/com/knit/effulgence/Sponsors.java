package com.knit.effulgence;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Sponsors extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);

        setContentView(R.layout.sponsors);
        RecyclerView recList = (RecyclerView) findViewById(R.id.clSponsor);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        SponsorsAdapter ca = new SponsorsAdapter(createList(13));
        recList.setAdapter(ca);
    }

    private List<ContactInfo> createList(int size) {

        List<ContactInfo> result = new ArrayList<>();
        Integer[] ThumbId = {R.drawable.hindustan , R.drawable.sky, R.drawable.skyfi
                , R.drawable.codechef, R.drawable.civil, R.drawable.iste, R.drawable.ti, R.drawable.i
                , R.drawable.asar, R.drawable.time, R.drawable.atom, R.drawable.cetpa, R.drawable.td, R.drawable.eco2};
        for (int i=0; i < size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.thumb = ThumbId[i];
            result.add(ci);
        }
        return result;
    }
}
