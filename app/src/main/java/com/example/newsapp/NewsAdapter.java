package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
//        if (isTopNews) {
        if (true) {
            //TODO: make top news a carousel with arrows on either side to imply there are stories to swipe across to
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news_article, parent, false);
            return new NewsViewHolder(view, isTopNews);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_row, parent, false);
            return new NewsViewHolder(view, isTopNews);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewDate;
        public TextView textViewHeadline;
        private Boolean isTopNews;

        public NewsViewHolder(@NonNull View itemView, Boolean isTopNews) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_article);
            textViewDate = itemView.findViewById(R.id.textView_date);
            textViewHeadline = itemView.findViewById(R.id.textView_headline);
            this.isTopNews = isTopNews;
        }

        public void bind(NewsItem newsItem) {
            // Bind data to the views
//            imageView.setImageResource(newsItem.getImageResource());
            textViewDate.setText(newsItem.getDate());
            textViewHeadline.setText(newsItem.getHeadline());

            String imageUrl;
            if (isTopNews) {
                imageUrl = "https://picsum.photos/300/200";
            } else {
                imageUrl = "https://picsum.photos/200/200";
            }

            Picasso.get().load(imageUrl).into(imageView);
        }

        public void clear() {
        }
    }
}
