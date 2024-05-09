package com.example.randallgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.randallgame.Adapter.CardAdapter;
import com.example.randallgame.Callback.CardCallback;
import com.example.randallgame.DataModel.Card;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements CardCallback {


    ImageButton btnHome, btnRefresh;
    RecyclerView rvCards;
    CardAdapter cardAdapter;
    List<Card> cardList = new ArrayList<>();

    Card selectedCard;
    int selectcount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        cardList = getCardList();
        Collections.shuffle(cardList);

        btnHome = findViewById(R.id.btnHome);
        btnRefresh = findViewById(R.id.btnRefresh);
        rvCards = findViewById(R.id.rvCard);

        cardAdapter = new CardAdapter(this, cardList, this);
        rvCards.setLayoutManager(new GridLayoutManager(this, 3));
        rvCards.setAdapter(cardAdapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialAlertDialogBuilder(GameActivity.this)
                        .setTitle("Quit Game")
                        .setMessage("Are you sure you want to quit?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNeutralButton("Cancel", null)
                        .show();
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffle();
            }
        });


    }

    private void shuffle() {
        for(int i = 0; i < cardList.size(); i++){
            cardList.get(i).getCardView().setSelected(false);
        }
        Collections.shuffle(cardList);

        selectedCard = null;
        selectcount = 0;

        cardAdapter = new CardAdapter(this, cardList, this);
        rvCards.setLayoutManager(new GridLayoutManager(this, 3));
        rvCards.setAdapter(cardAdapter);
    }

    boolean animating = false;
    @Override
    public void onCardClick(int pos) {
        Card card = cardList.get(pos);

        if(animating) return;

        if(selectedCard != null ){
            if(card.getCardView() == selectedCard.getCardView()) return;
            if(selectedCard.getName().equals(card.getName())){
                card.getCardView().setSelected(true);
                card.getCardView().setOnClickListener(null);
                selectedCard.getCardView().setOnClickListener(null);
                selectcount++;
            }
            else{
                animating = true;
                MaterialCardView temp = selectedCard.getCardView();
                card.getCardView().setSelected(true);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        card.getCardView().setSelected(false);
                        temp.setSelected(false);
                        selectcount--;
                        animating = false;
                    }
                },500);
            }
            selectedCard = null;
        }
        else{
            card.getCardView().setSelected(true);
            selectcount++;
            selectedCard = card;
        }

        if(selectcount == cardList.size()){
            Toast.makeText(this, "You won! congratulations", Toast.LENGTH_SHORT).show();
        }

    }

    private List<Card> getCardList(){
        cardList.clear();
        List<Card> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Monkey", R.drawable.card_monkey);
        map.put("Beetle", R.drawable.card_beetle);
        map.put("Chameleon", R.drawable.card_chameleon);
        map.put("Cobra", R.drawable.card_cobra);
        map.put("Raccoon", R.drawable.card_raccoon);
        map.put("Tiger", R.drawable.card_tiger);
        for(String s : map.keySet()){
            list.add(new Card(s, map.get(s)));
            list.add(new Card(s, map.get(s)));
        }

        return list;
    }
}