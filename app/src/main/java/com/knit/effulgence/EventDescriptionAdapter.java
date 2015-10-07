package com.knit.effulgence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class EventDescriptionAdapter extends RecyclerView.Adapter<EventDescriptionAdapter.EventDescriptionViewHolder> {

    private CharSequence txt;

    public EventDescriptionAdapter(CharSequence txt) {
        this.txt = txt;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onBindViewHolder(EventDescriptionViewHolder EventDescriptionViewHolder, int i) {
        EventDescriptionViewHolder.vContent.setText(txt);
    }

    @Override
    public EventDescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.event_description_card_layout, viewGroup, false);

        return new EventDescriptionViewHolder(itemView);
    }

    public static class EventDescriptionViewHolder extends RecyclerView.ViewHolder {

        protected TextView vContent;

        public EventDescriptionViewHolder(View v) {
            super(v);
            vContent =  (TextView) v.findViewById(R.id.event_des);
        }
    }
}