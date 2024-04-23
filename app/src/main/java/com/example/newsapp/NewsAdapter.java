package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
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

    public NewsAdapter(List<NewsItem> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO: make top news a carousel with arrows on either side to imply there are stories to swipe across to
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news_article, parent, false);
        return new NewsViewHolder(view);
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
        public TextView textViewCaption;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_article);
            textViewDate = itemView.findViewById(R.id.textView_date);
            textViewHeadline = itemView.findViewById(R.id.textView_headline);
            textViewCaption = itemView.findViewById(R.id.textView_caption);
        }

        public void bind(NewsItem newsItem) {
            // Bind data to the views
            textViewDate.setText(newsItem.getDate());
            textViewHeadline.setText(newsItem.getHeadline());
            textViewCaption.setText("");

            String imageUrl = "https://picsum.photos/425/200?v=" + newsItem.getHeadline();
            Picasso.get().load(imageUrl).into(imageView);

            imageView.setOnClickListener((view) -> {
                Intent intent = new Intent(view.getContext(), ArticleActivity.class);
                intent.putExtra(ArticleActivity.EXTRA_ARTICLE_ID, newsItem.id);
                view.getContext().startActivity(intent);
            });
        }

        public void clear() {
        }
    }
}
