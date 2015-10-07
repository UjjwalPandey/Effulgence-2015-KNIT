package com.knit.effulgence;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

public class WorkshopCardArrayAdapter extends RecyclerView.Adapter<WorkshopCardArrayAdapter.ContactViewHolder> {
    private static Context context;
    private List<ContactInfo> contactList;

    public WorkshopCardArrayAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vEventId.setText(Integer.toString(ci.thumb));

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View itemView = LayoutInflater.
                from(context).
                inflate(R.layout.workshop_list_item_card, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vEventId;
        protected RelativeLayout vLayout;
        protected LinearLayout vLinear;
        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.tvWorkshop);
            vEventId =  (TextView) v.findViewById(R.id.tvWorkshopId);
            vLayout = (RelativeLayout) v.findViewById(R.id.rlWorkshop);
            vLinear = (LinearLayout) v.findViewById(R.id.llInvisibleWorkshop);
            vLinear.setVisibility(View.GONE);
            vLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context,WorkshopDescription.class);
                    intent.putExtra("WorkshopID", Integer.parseInt(vEventId.getText().toString()));
                    context.startActivity(intent);
                }
            });
        }


    }
}