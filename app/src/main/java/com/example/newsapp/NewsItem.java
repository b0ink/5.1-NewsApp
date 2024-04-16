package com.example.newsapp;

public class NewsItem {
    private int imageResource;
    private String date;
    private String headline;
    private String caption;
    private String text;

    //TODO: two image

    public NewsItem(int imageResource, String date, String headline) {
        this.imageResource = imageResource;
        this.date = date;
        this.headline = headline;
    }


    public NewsItem(String headline, String caption, String text, String date) {
//        this.imageResource = imageResource;
        this.date = date;
        this.headline = headline;
        this.caption = caption;
        this.text = text;

    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDate() {
        return date;
    }

    public String getHeadline() {
        return headline;
    }
}
