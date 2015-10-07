package com.knit.effulgence;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.internal.in;

import java.util.List;

public class HospitalityCardArrayAdapter extends RecyclerView.Adapter<HospitalityCardArrayAdapter.ContactViewHolder> {
    private static Context context;
    private List<ContactInfo> contactList;
    private static int BranchId;
    private static int position;

    public HospitalityCardArrayAdapter(List<ContactInfo> contactList) {
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
        contactViewHolder.vEventId.setText(Integer.toString(ci.branchId));

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View itemView = LayoutInflater.
                from(context).
                inflate(R.layout.hospitalitycard, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vEventId;
        protected RelativeLayout vLayout;
        protected LinearLayout vLinear;
        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.tvHospitality);
            vEventId =  (TextView) v.findViewById(R.id.tvHospitalityContentId);
            vLayout = (RelativeLayout) v.findViewById(R.id.rlHospitality);
            vLinear = (LinearLayout) v.findViewById(R.id.llHospitalityInvisible);
            vLinear.setVisibility(View.GONE);
            vLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int hospitalityId = Integer.parseInt(vEventId.getText().toString());
                    Intent intent = null;
                    switch(hospitalityId){
                        case 0:
                            intent = new Intent(context,MapsActivity.class);
                            break;
                        case 1:

                        case 2:

                        case 3:
                            intent = new Intent(context,HospitalityDescription.class);
                            intent.putExtra("HospitalityID",hospitalityId);
                            break;

                    }
            if(intent != null) {
                context.startActivity(intent);
            }
                }
            });
        }


    }
}