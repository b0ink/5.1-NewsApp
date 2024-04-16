package com.example.newsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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

        List<NewsItem> topNewsList = generateDummyData(); // Generate dummy data
        NewsAdapter topNewsAdapter = new NewsAdapter(topNewsList, true);
        topNewsRecycler.setAdapter(topNewsAdapter);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<NewsItem> newsList = generateDummyData(); // Generate dummy data
        NewsAdapter adapter = new NewsAdapter(newsList, false);
        recyclerView.setAdapter(adapter);


    }

    private List<NewsItem> generateDummyData() {
        List<NewsItem> newsList = new ArrayList<>();
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 16, 2024", "Sample Headline 1"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 15, 2024", "Sample Headline 2"));
        newsList.add(new NewsItem(R.drawable.placeholder_image, "April 14, 2024", "Sample Headline 3"));
        return newsList;
    }
}