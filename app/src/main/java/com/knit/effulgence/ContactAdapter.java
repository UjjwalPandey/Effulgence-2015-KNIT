package com.knit.effulgence;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<ContactInfo> contactList;
    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }
    @Override
    public int getItemCount() {
        return contactList.size();
    }
    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vEmail.setText(ci.email);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vImg.setImageResource(ci.thumb);
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vEmail;
        protected ImageView vImg;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.title);
            vEmail = (TextView)  v.findViewById(R.id.txtEmail);
            vImg = (ImageView) v.findViewById(R.id.ivAbout);
            //vImg.getLayoutParams().height=50;
            //vImg.getLayoutParams().width=50;
        }
    }
}