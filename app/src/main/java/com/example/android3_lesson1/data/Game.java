package com.example.android3_lesson1.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game<Content> {
    private final List<Card<Content>> cards = new ArrayList<>();

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>((i + 1) * 2, false,false,contents.get(i)));
            cards.add(new Card<>(i * 2, false,false,contents.get(i)));
            Collections.shuffle(cards);
        }
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            checkPairs(card);
        }
    }

    private void checkPairs(Card<Content> card) {
        for (Card<Content> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.equals(anotherCard) && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                    Log.d("TAG", "MATCH");
                } else if (!card.equals(anotherCard)) {
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                }
            }
        }
        remove();
    }

    private void remove() {
        List<Card<Content>> result = new ArrayList<>(cards);
        for (Card<Content> contentCard: cards) {
            if (contentCard.isMatched()){
                result.remove(contentCard);
            }
        }
        cards.clear();
        cards.addAll(result);
    }

    public List<Card<Content>> getCards() {
        return cards;
    }
}
