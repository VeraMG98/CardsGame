package com.example.android3_lesson1.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_lesson1.R;
import com.example.android3_lesson1.data.Card;
import com.example.android3_lesson1.ui.EmojiGame;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final EmojiGame emojiGame;
    private final OnCardClick onCardClick;

    public EmojiAdapter(OnCardClick onCardClick, EmojiGame emojiGame) {
        this.onCardClick = onCardClick;
        this.emojiGame = emojiGame;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_card, parent, false);
        return new EmojiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    class EmojiHolder extends RecyclerView.ViewHolder {
        private final TextView txtCard;

        public EmojiHolder(@NonNull View itemView) {
            super(itemView);
            txtCard = itemView.findViewById(R.id.txt_card_content);
        }

        @SuppressLint("ResourceAsColor")
        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                txtCard.setText(card.getContent());
            } else {
                txtCard.setText("");
            }

            itemView.setOnClickListener(v -> {
                emojiGame.choose(card);
                onCardClick.cardClick(card);
            });
        }

    }

    public interface OnCardClick {
        void cardClick(Card<String> card);
    }
}
