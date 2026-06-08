package com.example.retrogamesapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrogamesapp.DetailActivity;
import com.example.retrogamesapp.Game;
import com.example.retrogamesapp.R;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private List<Game> list;

    public GameAdapter(List<Game> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, platform;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            platform = itemView.findViewById(R.id.txtPlatform);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Game game = list.get(position);

        holder.title.setText(game.getTitle());
        holder.platform.setText(game.getPlatform());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(
                    v.getContext(),
                    DetailActivity.class
            );

            intent.putExtra("title", game.getTitle());
            intent.putExtra("platform", game.getPlatform());
            intent.putExtra("release_date", game.getReleaseDate());
            intent.putExtra("description", game.getDescription());
            intent.putExtra("image", game.getImage());
            intent.putExtra("youtube_url", game.getYoutubeUrl());

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
