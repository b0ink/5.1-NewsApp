package com.example.newsapp;

public class NewsItem {
    private int imageResource;
    private String date;
    private String headline;

    public NewsItem(int imageResource, String date, String headline) {
        this.imageResource = imageResource;
        this.date = date;
        this.headline = headline;
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
