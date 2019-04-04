package edu.gatech.cs2340.lab3newcomponents.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;
import edu.gatech.cs2340.lab3newcomponents.entity.TradeGoods;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;

public class SellActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.buy_screen_main);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        Intent ip = getIntent();
        String planNum = Character.toString(ip.getStringExtra("Planet").charAt(ip.getStringExtra("Planet").length() - 1));
        final Integer plan = (Integer.parseInt(planNum) + 1);

        final TextView moneyAmt = findViewById(R.id.moneyAmount);
        moneyAmt.setText(String.format("$%d", player.getMoney()));

        final TextView cargo = findViewById(R.id.cargoSupply);
        String newS = "";
        for (int i = 0; i < player.getCargoList().size(); i++) {
            newS = newS + player.getCargoList().get(i) + ", ";
        }
        cargo.setText(newS);

        int i = 0;
        int objVal = TradeGoods.WATER.getPrice();
        final List<String> tradePics = Arrays.asList("water", "furs", "food", "ore", "games", "firearms", "medicine", "machines", "narcotics", "robots");
        final TradeGoods trades[] = TradeGoods.values();

        ImageView product = findViewById(R.id.supply);
        product.setImageResource(getResources().getIdentifier(tradePics.get(0), "drawable", "edu.gatech.cs2340.lab3newcomponents"));

        final TextView productName = findViewById(R.id.supplyName);
        productName.setText(tradePics.get(0));

        final TextView priceObj = findViewById(R.id.price);
        priceObj.setText(String.format("$%d", trades[0].getPrice() * plan));

        ImageButton next = findViewById(R.id.rightButton);
        next.setOnClickListener(new View.OnClickListener() {
            int j = 0;
            ImageView product = findViewById(R.id.supply);
            TextView productName = findViewById(R.id.supplyName);
            TextView priceObj = findViewById(R.id.price);
            final List<String> tradePics = Arrays.asList("water", "furs", "food", "ore", "games", "firearms", "medicine", "machines", "narcotics", "robots");
            public void onClick(View v) {
                j = j + 1;
                product.setImageResource(getResources().getIdentifier(tradePics.get((j) % tradePics.size()), "drawable", "edu.gatech.cs2340.lab3newcomponents"));
                productName.setText(tradePics.get((j) % tradePics.size()));
                priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan));
            }
        });

        Button buyButton = findViewById(R.id.buyButton);
        buyButton.setText("SELL");
//        final TextView cargo = findViewById(R.id.cargoSupply);
        buyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!player.getCargoList().contains(productName.getText().toString())) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SellActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You don't have this item in your cargo. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    player.setMoney(player.getMoney() + Integer.parseInt((priceObj.getText().subSequence(1, priceObj.getText().length())).toString()));
                    moneyAmt.setText(String.format("$%d", player.getMoney()));
                    player.getCargoList().remove(productName.getText().toString());
                    String newS = "";
                    for (int i = 0; i < player.getCargoList().size(); i++) {
                        newS = newS + player.getCargoList().get(i) + ", ";
                    }
                    cargo.setText(newS);
                }
            }
        });

        ImageButton backBuy = findViewById(R.id.backButtonBuy);
        backBuy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SellActivity.this, MarketActivity.class));
                Intent intent = new Intent(SellActivity.this, MarketActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
                startActivity(intent);
            }
        });
    }

}
