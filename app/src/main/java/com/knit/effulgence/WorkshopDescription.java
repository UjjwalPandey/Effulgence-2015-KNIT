package com.knit.effulgence;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkshopDescription extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_description);
        RecyclerView recList = (RecyclerView) findViewById(R.id.clWorkshopDescription);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        int workshopId = 0;

        if(b != null){
            workshopId = Integer.parseInt(b.get("WorkshopID").toString());

        }
        WorkshopDescriptionAdapter ca = new WorkshopDescriptionAdapter(readTxt(workshopId));
        recList.setAdapter(ca);
    }

    private CharSequence readTxt(int workshopId) {

        //event_branchId_eventI
       int res = 0;
       switch(workshopId){
                case 0:
                    res = R.raw.workshop_0;
                    break;
                case 1:
                    res = R.raw.workshop_1;
                    break;
                case 2:
                    res = R.raw.workshop_2;
                    break;
                case 3:
                    res = R.raw.workshop_3;
                    break;
                case 4:
                    res = R.raw.workshop_4;
                    break;
                case 5:
                    res = R.raw.workshop_5;
                    break;

            }

        InputStream inputStream = getResources().openRawResource(res);
        System.out.println(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1)
            {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();
    }
}