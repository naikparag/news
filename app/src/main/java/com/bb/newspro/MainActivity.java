package com.bb.newspro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bb.newspro.model.News;
import com.bb.newspro.service.NewService;
import com.bb.newspro.ui.NewsDetail;
import com.bb.newspro.ui.adapter.NewsAdapter;

public class MainActivity extends AppCompatActivity implements NewsAdapter.Holder.ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        displayNews();
    }

    private void displayNews() {
        // NewService.getNews()
        RecyclerView newsRecycler = (RecyclerView) findViewById(R.id.main_news_recycler);
        NewsAdapter adapter = new NewsAdapter(NewService.getNews());
        adapter.setOnClickListener(this);
        newsRecycler.setAdapter(adapter);
        newsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(News news) {
        startActivity(NewsDetail.newIntent(this, news));
    }
}