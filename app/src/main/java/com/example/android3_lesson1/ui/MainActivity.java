package com.example.android3_lesson1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.Game;
import com.example.android3_lesson1.ui.adapter.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.OnCardClick {
    private RecyclerView recyclerView;
    private EmojiAdapter adapter;
    private EmojiGame game;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_win);
        recyclerView = findViewById(R.id.rv_cards);
        adapter = new EmojiAdapter(this);

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