package edu.neu.madcourse.numad21su_emilycolladay;

public class ItemCard {

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


}
