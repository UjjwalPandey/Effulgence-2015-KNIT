package com.knit.effulgence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.SponsorsViewHolder> {

    private List<ContactInfo> SponsorsList;

    public SponsorsAdapter(List<ContactInfo> SponsorsList) {
        this.SponsorsList = SponsorsList;
    }


    @Override
    public int getItemCount() {
        return SponsorsList.size();
    }

    @Override
    public void onBindViewHolder(SponsorsViewHolder SponsorsViewHolder, int i) {
        ContactInfo ci = SponsorsList.get(i);
        SponsorsViewHolder.vImg.setImageResource(ci.thumb);
    }

    @Override
    public SponsorsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.sp_card_layout, viewGroup, false);

        return new SponsorsViewHolder(itemView);
    }

    public static class SponsorsViewHolder extends RecyclerView.ViewHolder {

        protected ImageView vImg;

        public SponsorsViewHolder(View v) {
            super(v);
            vImg = (ImageView) v.findViewById(R.id.spAbout);
        }
    }
}