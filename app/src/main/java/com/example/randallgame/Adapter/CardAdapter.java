package com.example.randallgame.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.randallgame.Callback.CardCallback;
import com.example.randallgame.DataModel.Card;
import com.example.randallgame.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<Card> cardList = new ArrayList<>();
    CardCallback cardCallback;
    Context context;

    public CardAdapter(Context context, List<Card> cardList, CardCallback cardCallback){
        this.cardList = cardList;
        this.context = context;
        this.cardCallback = cardCallback;
    }
    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.imgCard.setImageDrawable(ContextCompat.getDrawable(context, card.getResource()));
        card.setCardView(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCard;
        MaterialCardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCard = itemView.findViewById(R.id.imgCard);
            cardView = itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cardCallback.onCardClick(getAdapterPosition());
                }
            });
        }
    }
}
