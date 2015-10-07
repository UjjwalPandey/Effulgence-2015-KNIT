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

public class EventCardArrayAdapter extends RecyclerView.Adapter<EventCardArrayAdapter.ContactViewHolder> {
    private static Context context;
    private List<ContactInfo> contactList;

    public EventCardArrayAdapter(List<ContactInfo> contactList) {
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
        contactViewHolder.vBranchId.setText(Integer.toString(ci.branchId));
        contactViewHolder.vEventId.setText(Integer.toString(ci.thumb));
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View itemView = LayoutInflater.
                from(context).
                inflate(R.layout.event_list_item_card, viewGroup, false);
        return new ContactViewHolder(itemView);
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vBranchId;
        protected TextView vEventId;
        protected RelativeLayout vLayout;
        protected LinearLayout vLinear;
        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.tvEvent);
            vBranchId =  (TextView) v.findViewById(R.id.tvBranchId);
            vEventId =  (TextView) v.findViewById(R.id.tvEventId);
            vLayout = (RelativeLayout) v.findViewById(R.id.rlEvent);
            vLinear = (LinearLayout) v.findViewById(R.id.llInvisible);
            vLinear.setVisibility(View.GONE);
            vLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,EventDescription.class);
                    intent.putExtra("Event", Integer.parseInt(vEventId.getText().toString()));
                    intent.putExtra("BranchIs", Integer.parseInt(vBranchId.getText().toString()));
                    context.startActivity(intent);
                }
            });
        }
    }
}