package com.knit.effulgence;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class CategoryCardArrayAdapter extends RecyclerView.Adapter<CategoryCardArrayAdapter.ContactViewHolder> {
    private static Context context;
    private List<ContactInfo> contactList;

    public CategoryCardArrayAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        //contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vEventId.setText(Integer.toString(ci.thumb));
        contactViewHolder.vImage.setImageResource(ci.branchId);

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View itemView = LayoutInflater.
                from(context).
                inflate(R.layout.category_card, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        //protected TextView vName;
        protected TextView vEventId;
        protected ImageView vImage;
        protected RelativeLayout vLayout;
        protected LinearLayout vLinear;
        public ContactViewHolder(View v) {
            super(v);
           // vName =  (TextView) v.findViewById(R.id.tvCategory);
            vEventId =  (TextView) v.findViewById(R.id.tvCategoryContentId);
            vImage = (ImageView) v.findViewById(R.id.ivCategory);
            vLayout = (RelativeLayout) v.findViewById(R.id.rlCategory);
            vLinear = (LinearLayout) v.findViewById(R.id.llCategoryInvisible);
            vLinear.setVisibility(View.GONE);
            vLayout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int categoryId = Integer.parseInt(vEventId.getText().toString());
                    Intent intent = null;
                    switch(categoryId){
                        case 0:

                            intent = new Intent(context,Branch.class);
                            break;
                        case 1:
                            intent = new Intent(context,WorkshopListActivity.class);
                            break;
                        case 2:
                            intent = new Intent(context,Sponsors.class);

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