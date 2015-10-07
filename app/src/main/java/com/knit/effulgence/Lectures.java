package com.knit.effulgence;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class Lectures extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        ContactAdapter ca = new ContactAdapter(createList(4));
        recList.setAdapter(ca);
    }
    private List<ContactInfo> createList(int size) {
        List<ContactInfo> result = new ArrayList<>();
        String[] Name={"Kailash Satyarthi", "Nirupam Singh", "Ujjwal Pandey", "Aai Sala"};
        String[] Email={"ks@gmail.com", "nirupamsingh29@gmail.com", "ujjwalpande@gmail.com",
                "arrebhaiya@gmail.com"};
        Integer[] ThumbId = {R.drawable.counterstrike,R.drawable.counterstrike,
                R.drawable.counterstrike,R.drawable.computerscience};
        for (int i=0; i < size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = Name[i];
            ci.email = Email[i];
            ci.thumb = ThumbId[i];
            result.add(ci);
        }
        return result;
    }
}
