package com.bb.newspro.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bb.newspro.R;
import com.bb.newspro.model.News;

import java.util.List;

/**
 * Created by parnaik on 6/27/16.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {

    private List<News> newsList;
    private Holder.ClickListener listener;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final News news = newsList.get(position);

        holder.title.setText(news.getTitle());
        holder.description.setText(news.getDescription());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(news);
            }
        });
    }

    public void setOnClickListener(Holder.ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView description;
        public View container;

        public Holder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.news_item_container);
            title = (TextView) itemView.findViewById(R.id.news_item_title);
            description = (TextView) itemView.findViewById(R.id.news_item_description);
        }

        public static interface ClickListener {
            public void onClick(News news);
        }
    }
}
