package com.example.newsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ArticleActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLE_ID = "EXTRA_ARTICLE_ID";

/*    public final String EXTRA_HEADLINE = "extra_headline";
    public final String EXTRA_CAPTION = "extra_caption";
    public final String EXTRA_IMAGE = "extra_image";
    public final String EXTRA_TEXT = "extra_text";*/

    public ImageView articleImage;
    public TextView articleHeadline;
    public TextView articleDate;
    public TextView articleText;

    public RecyclerView relatedArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_article);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        articleImage = findViewById(R.id.articleImage);
        articleHeadline = findViewById(R.id.articleHeadline);
        articleDate = findViewById(R.id.articleDate);
        articleText = findViewById(R.id.articleText);

        Intent intent = getIntent();
        int newsID = intent.getIntExtra(EXTRA_ARTICLE_ID, -1);


        List<NewsItem> newsList = JsonHelper.parseArticles(this);
        NewsItem mainArticle = null;

        for(NewsItem item : newsList){
            if(item.id == newsID){
                mainArticle = item;
                break;
            }
        }

        if(newsID == -1 || mainArticle == null){
            finish(); // exit activity;
            return;
        }

        articleHeadline.setText(mainArticle.getHeadline());
        articleText.setText(mainArticle.getArticleText());
        articleDate.setText(mainArticle.getDate());

        String imageUrl = "https://picsum.photos/425/200?v="+mainArticle.getHeadline();
        Picasso.get().load(imageUrl).into(articleImage);


        /* Standard news articles */
        RecyclerView recyclerView = findViewById(R.id.relatedArticles);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        NewsAdapter adapter = new NewsAdapter(this, newsList, false);
        recyclerView.setAdapter(adapter);

    }
}