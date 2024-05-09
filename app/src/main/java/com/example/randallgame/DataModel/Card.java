package com.example.randallgame.DataModel;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.google.android.material.card.MaterialCardView;

public class Card {

   MaterialCardView cardView;

    public MaterialCardView getCardView() {
        return cardView;
    }

    public void setCardView(MaterialCardView cardView) {
        this.cardView = cardView;
    }

    public Card(String name, Drawable drawable){
        this.name = name;
        this.drawable = drawable;
    }
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    Drawable drawable;
}
