package com.knit.effulgence;

import java.util.ArrayList;

public class Group {

    private String Name;
    private ArrayList<ContactInfo> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<ContactInfo> getItems() {
        return Items;
    }

    public void setItems(ArrayList<ContactInfo> Items) {
        this.Items = Items;
    }

}
