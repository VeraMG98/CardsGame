package com.example.android3_lesson1.ui;

import android.annotation.SuppressLint;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.data.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmojiGame {
    private final Game<String> game;

    @SuppressLint("NewApi")
    public EmojiGame() {
        game = new Game<>(List.of("\uD83D\uDC7B", "\uD83C\uDF83",
                "\uD83D\uDC79", "😈", "️🧟‍♂","🦇"));
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
 }
