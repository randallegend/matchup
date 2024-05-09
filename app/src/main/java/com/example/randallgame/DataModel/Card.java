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

    public Card(String name, int resource){
        this.name = name;
        this.resource = resource;
    }
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    int resource;

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}
