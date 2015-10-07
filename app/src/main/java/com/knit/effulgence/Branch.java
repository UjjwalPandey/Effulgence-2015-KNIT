package com.knit.effulgence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

public class Branch extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        GridView gridview = (GridView) findViewById(R.id.branchview);
        gridview.setAdapter(new BranchAdapter(Branch.this,1));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(Branch.this,EventCardListActivity.class);
                intent.putExtra("BranchList", position);
                startActivity(intent);
            }
        });
    }
}
