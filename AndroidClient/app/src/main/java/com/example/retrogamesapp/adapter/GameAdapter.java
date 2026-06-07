package com.example.retrogamesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrogamesapp.Game;
import com.example.retrogamesapp.R;

import java.util.List;

public class GameAdapter
        extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<Game> gameList;

    public GameAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public GameViewHolder onCreateViewHolder(
            ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game,
                        parent,
                        false);

        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            GameViewHolder holder,
            int position) {

        Game game = gameList.get(position);

        holder.title.setText(game.getTitle());
        holder.platform.setText(game.getPlatform());
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public static class GameViewHolder
            extends RecyclerView.ViewHolder {

        TextView title;
        TextView platform;

        public GameViewHolder(View itemView) {

            super(itemView);

            title =
                    itemView.findViewById(R.id.txtTitle);

            platform =
                    itemView.findViewById(R.id.txtPlatform);
        }
    }
        }
