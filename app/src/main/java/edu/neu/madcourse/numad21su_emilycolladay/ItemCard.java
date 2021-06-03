package edu.neu.madcourse.numad21su_emilycolladay;

import android.content.Intent;
import android.net.Uri;

public class ItemCard implements LinkClickListener {

    private final String linkName;
    private final String linkHyper;

    public ItemCard(String linkName, String linkHyper){
        this.linkName = linkName;
        this.linkHyper = linkHyper;

    }

    public String getLinkName() {
        return linkName;
    }

    public String getLinkHyper() {
        return linkHyper;
    }


    @Override
    public void onItemClick(int position) {
    }

}
