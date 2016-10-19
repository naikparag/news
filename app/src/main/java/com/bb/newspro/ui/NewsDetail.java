package com.bb.newspro.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bb.newspro.R;
import com.bb.newspro.model.News;
import com.squareup.picasso.Picasso;

/**
 * Created by parnaik on 6/27/16.
 */

public class NewsDetail extends AppCompatActivity {

    private static final String EXTRA_NEWS_INTENT = "news.detail.extra";

    public static Intent newIntent(Context context, News news) {
        Intent i = new Intent(context, NewsDetail.class);
        i.putExtra(EXTRA_NEWS_INTENT, news);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
        initView();
    }

    private void initView() {
        News news = getIntent().getParcelableExtra(EXTRA_NEWS_INTENT);
        ((TextView) findViewById(R.id.news_detail_title)).setText(news.getTitle());
        ((TextView) findViewById(R.id.news_detail_description)).setText(news.getDescription());
        if (news.getImageUrl() != null) {
            ImageView image = (ImageView) findViewById(R.id.news_detail_image);
            image.setVisibility(View.VISIBLE);
            Picasso.with(this).load(news.getImageUrl()).into(image);
        }
    }
}
