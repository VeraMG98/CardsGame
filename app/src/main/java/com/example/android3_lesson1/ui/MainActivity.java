package com.example.android3_lesson1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.Game;
import com.example.android3_lesson1.ui.adapter.EmojiAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.OnCardClick {
    private EmojiAdapter adapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_cards);
        adapter = new EmojiAdapter(this, new EmojiGame(this));
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void cardClick(Card<String> card) {
        adapter.notifyDataSetChanged();
    }
}