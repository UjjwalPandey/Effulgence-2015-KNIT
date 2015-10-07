package com.knit.effulgence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HospitalityDescriptionAdapter extends RecyclerView.Adapter<HospitalityDescriptionAdapter.HospitalityDescriptionViewHolder> {

    private CharSequence txt;
    private int HospitalityID;

    public HospitalityDescriptionAdapter(CharSequence txt, int hospitalityID) {

        this.txt = txt;
        this.HospitalityID = hospitalityID;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onBindViewHolder(HospitalityDescriptionViewHolder hospitalityDescriptionViewHolder, int i) {
        if(HospitalityID==1 || HospitalityID==3) {
            hospitalityDescriptionViewHolder.vImg.setVisibility(View.GONE);
            hospitalityDescriptionViewHolder.vContent.setText(txt);
        }else{
            hospitalityDescriptionViewHolder.vContent.setVisibility(View.GONE);
            hospitalityDescriptionViewHolder.vImg.setImageResource(R.drawable.trainsup);
        }
    }

    @Override
    public HospitalityDescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.hospitality_description_card, viewGroup, false);

        return new HospitalityDescriptionViewHolder(itemView);
    }

    public static class HospitalityDescriptionViewHolder extends RecyclerView.ViewHolder {

        protected TextView vContent;
        protected ImageView vImg;

        public HospitalityDescriptionViewHolder(View v) {
            super(v);
            vContent =  (TextView) v.findViewById(R.id.hospitality_card_description);
            vImg = (ImageView) v.findViewById(R.id.hospitality_card_image);

        }
    }
}