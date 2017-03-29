package com.miguelcr.a03_hotelcustomlistview;

/**
 * Created by miguelcampos on 29/3/17.
 */

public class HotelItem {
    String name;
    int rate;
    int price;
    String tags;
    String moreInfo;
    String opinions;
    String photo;

    public HotelItem(String name, int rate, int price, String tags, String moreInfo, String opinions, String photo) {
        this.name = name;
        this.rate = rate;
        this.price = price;
        this.tags = tags;
        this.moreInfo = moreInfo;
        this.opinions = opinions;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getOpinions() {
        return opinions;
    }

    public void setOpinions(String opinions) {
        this.opinions = opinions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
