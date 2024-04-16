package com.example.newsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        RecyclerView topNewsRecycler = findViewById(R.id.top_news_recycler);
        topNewsRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        List<NewsItem> topNewsList = generateDummyData(); // Generate dummy data
        List<NewsItem> topNewsList = JsonHelper.parseArticles(this); // Generate dummy data

        NewsAdapter topNewsAdapter = new NewsAdapter(topNewsList, true);
        topNewsRecycler.setAdapter(topNewsAdapter);



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

//        List<NewsItem> newsList = generateDummyData(); // Generate dummy data
        List<NewsItem> newsList = JsonHelper.parseArticles(this); // Generate dummy data

        NewsAdapter adapter = new NewsAdapter(newsList, false);
        recyclerView.setAdapter(adapter);


    }

    private List<NewsItem> generateDummyData() {
        List<NewsItem> newsList = new ArrayList<>();
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 16, 2023", "Sample Headline 1"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 15, 2022", "Sample Headline 2"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 14, 2021", "Sample Headline 3"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 13, 2024", "Sample Headline 4"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 12, 2025", "Sample Headline 5"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 6"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 7"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 8"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 9"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 10"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 11"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 12"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 11, 2026", "Sample Headline 13"));
        return newsList;
    }
}