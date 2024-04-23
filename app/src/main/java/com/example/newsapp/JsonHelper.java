package com.example.newsapp;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    public static List<NewsItem> parseArticles(Context context) {
        List<NewsItem> articles = new ArrayList<>();
        try {
            // Read JSON file from assets folder
            String json = loadJSONFromAsset(context, "Articles.json");
            if (json != null) {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("articles");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject articleObject = jsonArray.getJSONObject(i);
                    int id = articleObject.getInt("id");
                    String headline = articleObject.getString("Headline");
                    String caption = articleObject.getString("Caption");
                    String text = articleObject.getString("Text");
                    String date = articleObject.getString("Date");
                    articles.add(new NewsItem(id, headline, caption, text, date));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return articles;
    }

    private static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
