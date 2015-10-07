package com.knit.effulgence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WorkshopDescriptionAdapter extends RecyclerView.Adapter<WorkshopDescriptionAdapter.WorkshopDescriptionViewHolder> {

    private CharSequence txt;

    public WorkshopDescriptionAdapter(CharSequence txt) {
        this.txt = txt;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onBindViewHolder(WorkshopDescriptionViewHolder EventDescriptionViewHolder, int i) {
        EventDescriptionViewHolder.vContent.setText(txt);
    }

    @Override
    public WorkshopDescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.worshop_description_card_layout, viewGroup, false);

        return new WorkshopDescriptionViewHolder(itemView);
    }

    public static class WorkshopDescriptionViewHolder extends RecyclerView.ViewHolder {

        protected TextView vContent;

        public WorkshopDescriptionViewHolder(View v) {
            super(v);
            vContent =  (TextView) v.findViewById(R.id.workshop_description);
        }
    }
}