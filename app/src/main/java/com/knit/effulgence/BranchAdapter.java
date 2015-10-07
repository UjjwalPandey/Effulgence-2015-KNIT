package com.knit.effulgence;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class BranchAdapter extends BaseAdapter {
    private Context mContext;
    private int activity;
    public BranchAdapter(Context c,  int act) {
        mContext = c;
        activity = act;
    }

    public int getCount() {
    	switch(activity){
        case 0:
        	return mThumbId0.length;
        	
        case 1:
        	return mThumbId1.length;
        	
        default:
        	return mThumbId2.length;
        	
        }
        
    }

    public Object getItem(int position) {
        return getItemId(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);

            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } else {
            imageView = (ImageView) convertView;
        }
        switch(activity){
        case 0:
        	imageView.setImageResource(mThumbId0[position]);
        	break;
        case 1:
        	imageView.setImageResource(mThumbId1[position]);
        	break;
        case 2:
        	imageView.setImageResource(mThumbId2[position]);
        	break;
        }
        return imageView;
    }

    // references to our images
    private Integer[] mThumbId0 = {R.drawable.events, R.drawable.guest, R.drawable.workshop, R.drawable.sponsor};
    private Integer[] mThumbId1 = {R.drawable.computerscience,R.drawable.electronicsengineering,R.drawable.electricalengineering,
    		R.drawable.civilengineering,R.drawable.mechanicalengineering,R.drawable.businessengineering,R.drawable.counterstrike,R.drawable.paperpresentation};
    private Integer[] mThumbId2 = {R.drawable.branch,R.drawable.branch,R.drawable.branch,R.drawable.branch,R.drawable.branch,R.drawable.branch};
    
}