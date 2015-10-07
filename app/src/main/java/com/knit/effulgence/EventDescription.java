package com.knit.effulgence;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDescription extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.event_description);
        RecyclerView recList = (RecyclerView) findViewById(R.id.clEventDescription);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        int branchId = 0;
        int eventId = 0;
        if(b != null){
            branchId = Integer.parseInt(b.get("BranchIs").toString());
            eventId = Integer.parseInt(b.get("Event").toString());
        }
        EventDescriptionAdapter ca = new EventDescriptionAdapter(readTxt(branchId,eventId));
        recList.setAdapter(ca);
    }

    private CharSequence readTxt(int branchId, int eventId) {
		
		//event_branchId_eventI
		int res = 0;
		switch(branchId){
		case 0:	switch(eventId){
				case 0:
                    this.setTitle("Da Vinci");
					res = R.raw.event_0_0;
					break;
				case 1:
                    this.setTitle("Codigo");
					res = R.raw.event_0_1;
					break;
				case 2:
                    this.setTitle("Window's Piratage");
					res = R.raw.event_0_2;
					break;
				case 3:
                    this.setTitle("App Development");
					res = R.raw.event_0_3;
					break;
				case 4:
                    this.setTitle("Puzzling Chamber");
					res = R.raw.event_0_4;
					break;
				case 5:
                    this.setTitle("Code Defraggler");
					res = R.raw.event_0_5;
					break;
				case 6:
                    this.setTitle("No Mercy Coding");
					res = R.raw.event_0_6;
					break;
				case 7:
                    this.setTitle("Debugging");
					res = R.raw.event_0_7;
					break;
				case 8:
                    this.setTitle("Code Triangle");
					res = R.raw.event_0_8;
					break;
				case 9:
                    this.setTitle("Cyber Quiz");
					res = R.raw.event_0_9;
					break;
				}
                break;
                case 1:	switch(eventId){
                case 0:
                    this.setTitle("Mine Hunter");
                    res = R.raw.event_1_0;
                    break;
                case 1:
                    this.setTitle("The Matrix");
                    res = R.raw.event_1_1;
                    break;
                case 2:
                    this.setTitle("Robo GP");
                    res = R.raw.event_1_2;
                    break;
                case 3:
                    this.setTitle("Bob the Builder");
                    res = R.raw.event_1_3;
                    break;
                }
                break;
                case 2:	switch(eventId){
                case 0:
                    this.setTitle("Wiring Web");
                    res = R.raw.event_2_0;
                    break;
                case 1:
                    this.setTitle("Matpuzz");
                    res = R.raw.event_2_1;
                    break;
                case 2:
                    this.setTitle("Junkyard");
                    res = R.raw.event_2_2;
                    break;
                }
                break;
                case 3:	switch(eventId){
                case 0:
                    this.setTitle("Bond with the Best");
                    res = R.raw.event_3_0;
                    break;
                case 1:
                   this.setTitle("Cadanzo");
                    res = R.raw.event_3_1;
                    break;
                case 2:
                    this.setTitle("Hunt Your Goal");
                    res = R.raw.event_3_2;
                    break;
                case 3:
                    this.setTitle("Inclinatus");
                    res = R.raw.event_3_3;
                    break;
                case 4:
                    this.setTitle("Urbanismo");
                        res = R.raw.event_3_4;
                        break;
                case 5:
                    this.setTitle("Suspendo Brucke");
                        res = R.raw.event_3_5;
                        break;
                }
                break;
        case 4:	switch(eventId){
                case 0:
                    this.setTitle("Mechgripper");
                    res = R.raw.event_4_0;
                    break;
                case 1:
                    this.setTitle("MAD 4 CAD");
                    res = R.raw.event_4_1;
                    break;
                case 2:
                    this.setTitle("Contraction");
                    res = R.raw.event_4_2;
                    break;
                case 3:
                    this.setTitle("Mechanical Hydrobot");
                    res = R.raw.event_4_3;
                    break;
                case 4:
                    this.setTitle("Aqua Crane");
                    res = R.raw.event_4_4;
                    break;

                }
                break;
        case 5:	switch(eventId){
                case 0:
                    this.setTitle("Biz Quiz");
                    res = R.raw.event_5_0;
                    break;
                case 1:
                    this.setTitle("Tempus Ride");
                    res = R.raw.event_5_1;
                    break;
                case 2:
                    this.setTitle("Marketting Mania");
                    res = R.raw.event_5_2;
                    break;
                case 3:
                    this.setTitle("Namo - The Genius");
                    res = R.raw.event_5_3;
                    break;
                }
                break;
        case 6:	switch(eventId){
                case 0:
                    this.setTitle("Counter Strike 1.6");
                    res = R.raw.event_6_0;
                    break;
                case 1:
                    this.setTitle("NFSMW");
                    res = R.raw.event_6_1;
                    break;
                case 2:
                    this.setTitle("FIFA 12");
                    res = R.raw.event_6_2;
                break;
                }
                break;
        case 7:	switch(eventId){
                case 0:
                    this.setTitle("Technoscript");
                    res = R.raw.event_7_0;
                    break;
                case 1:
                    this.setTitle("N-Tech Script");
                    res = R.raw.event_7_1;
                    break;
                }
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