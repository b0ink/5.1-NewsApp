package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsItem> newsList;
    private Boolean isTopNews;

    public NewsAdapter(List<NewsItem> newsList, Boolean horizontal) {
        this.newsList = newsList;
        this.isTopNews = horizontal;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(isTopNews){
            //TODO: make top news a carousel with arrows on either side to imply there are stories to swipe across to
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news_article, parent, false);
            return new NewsViewHolder(view);
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_row, parent, false);
            return new NewsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        // Calculate the position of the news items in the dataset
        int firstItemPosition = position * 2;
        int secondItemPosition = firstItemPosition + 1;

        // Bind data to the first news item
        if (firstItemPosition < newsList.size()) {
            holder.bind(newsList.get(firstItemPosition));
        }

        // Bind data to the second news item
        if (secondItemPosition < newsList.size()) {
            holder.bind(newsList.get(secondItemPosition));
        } else {
            // Hide the second item if it doesn't have data
            holder.clear();
        }
    }

    @Override
    public int getItemCount() {
        // Calculate the number of rows needed for the news items
        return (int) Math.ceil(newsList.size() / 2.0);
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewDate;
        public TextView textViewHeadline;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_article);
            textViewDate = itemView.findViewById(R.id.textView_date);
            textViewHeadline = itemView.findViewById(R.id.textView_headline);
        }

        public void bind(NewsItem newsItem) {
            // Bind data to the views
            imageView.setImageResource(newsItem.getImageResource());
            textViewDate.setText(newsItem.getDate());
            textViewHeadline.setText(newsItem.getHeadline());
        }

        public void clear() {
        }
    }
}
