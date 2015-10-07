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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HospitalityDescription extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitalitydescription);
        RecyclerView recList = (RecyclerView) findViewById(R.id.clHospitalityDescription);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        int hospitalityId = 0;

        if(b != null){
            hospitalityId = Integer.parseInt(b.get("HospitalityID").toString());
        }
        HospitalityDescriptionAdapter ca;
        if(hospitalityId == 1 || hospitalityId==3) {
            if(hospitalityId == 1){
                this.setTitle("How to Reach");
            }else{
                this.setTitle("Misc Details");
            }
            ca = new HospitalityDescriptionAdapter(readTxt(hospitalityId), hospitalityId);
        }
        else {
            this.setTitle("Trains' Time Table");
            ca = new HospitalityDescriptionAdapter(null, hospitalityId);
        }
        recList.setAdapter(ca);
    }




    private CharSequence readTxt(int HospitalityID) {

        //event_branchId_eventI
        int res = 0;
       switch(HospitalityID){

                case 1:
                    res = R.raw.how_to_reach;
                    break;
                case 3:
                    res = R.raw.miscllaneous;
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