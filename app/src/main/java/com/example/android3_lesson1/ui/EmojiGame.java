package com.example.android3_lesson1.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmojiGame {
    private final Game<String> game;
    private final Context context;

    @SuppressLint("NewApi")
    public EmojiGame(Context context) {
        this.context = context;
        game = new Game<>(List.of("\uD83D\uDC7B", "\uD83C\uDF83",
                "\uD83D\uDC79", "😈", "️🧟‍♂","🦇"));
    }

    public void choose(Card<String> card) {
        game.choose(card);
        if (game.getFinish())
            setWinMessage();
    }

    private void setWinMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.win).show();
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }


 }
