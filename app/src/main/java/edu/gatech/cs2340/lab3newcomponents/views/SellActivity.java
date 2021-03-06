package edu.gatech.cs2340.lab3newcomponents.views;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

@SuppressWarnings("ALL")
public class SellActivity extends AppCompatActivity {
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.buy_screen_main);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable c =  getIntent().getSerializableExtra("Count");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        Intent ip = getIntent();
        String planNum = Character.toString(player.getPlanet().charAt(player.getPlanet().length() - 1));
        final Integer plan = (Integer.parseInt(planNum) + 1);

        final TextView moneyAmt = findViewById(R.id.moneyAmount);
        moneyAmt.setText(String.format("$%d", player.getMoney()));

        final TextView cargo = findViewById(R.id.cargoSupply);
//        String newS = "";
//        for (int i = 0; i < player.getCargoList().size(); i++) {
//            newS = newS + player.getCargoList().get(i) + ", ";
//        }
        cargo.setText(player.getCargoList());

        int i = 0;
        int objVal = TradeGoods.WATER.getPrice();
        final List<String> tradePics = Arrays.asList("water", "furs", "food", "ore", "games", "firearms", "medicine", "machines", "narcotics", "robots");
        final TradeGoods trades[] = TradeGoods.values();

        ImageView product = findViewById(R.id.supply);
        product.setImageResource(getResources().getIdentifier(tradePics.get(0), "drawable", "edu.gatech.cs2340.lab3newcomponents"));

        final TextView productName = findViewById(R.id.supplyName);
        productName.setText(tradePics.get(0));

        final TextView priceObj = findViewById(R.id.price);
        if (player.getPolitics().equals("Military") && productName.getText().toString().equals("water")) {
            priceObj.setText(String.format("$%d", trades[0].getPrice() * plan + 1000));
        } else {
            priceObj.setText(String.format("$%d", trades[0].getPrice() * plan));
        }

        ImageButton next = findViewById(R.id.rightButton);
        next.setOnClickListener(new View.OnClickListener() {
            int j = 0;
            ImageView product = findViewById(R.id.supply);
            TextView productName = findViewById(R.id.supplyName);
            TextView priceObj = findViewById(R.id.price);
            final List<String> tradePics = Arrays.asList("water", "furs", "food", "fuel", "games", "firearms", "medicine", "machines", "narcotics", "robots");
            @SuppressLint("DefaultLocale")
            public void onClick(View v) {
                j = j + 1;
                product.setImageResource(getResources().getIdentifier(tradePics.get((j) % tradePics.size()), "drawable", "edu.gatech.cs2340.lab3newcomponents"));
                productName.setText(tradePics.get((j) % tradePics.size()));
                if (player.getPolitics().equals("Anarchy") && productName.getText().toString().equals("food")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Capitalist") && productName.getText().toString().equals("fuel")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Confederacy") && productName.getText().toString().equals("games")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Corporate") && productName.getText().toString().equals("robots")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Cybernetic") && productName.getText().toString().equals("narcotics")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Democracy") && productName.getText().toString().equals("furs")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Fascist") && productName.getText().toString().equals("machines")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Feudal") && productName.getText().toString().equals("firearms")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Military") && productName.getText().toString().equals("water")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else if (player.getPolitics().equals("Monarchy") && productName.getText().toString().equals("medicine")) {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan + 1000));
                } else {
                    priceObj.setText(String.format("$%d", trades[j % tradePics.size()].getPrice() * plan));
                }
            }
        });

        Button buyButton = findViewById(R.id.buyButton);
        buyButton.setText("SELL");
//        final TextView cargo = findViewById(R.id.cargoSupply);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
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
                    ArrayList<String> items = new ArrayList<String>(Arrays.asList(player.getCargoList().split(", ")));//player.getCargoList().split("\\s*,\\s*"));
                    items.remove(productName.getText().toString());
                    String newS = "";
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(items.get(i));
                        newS = newS + items.get(i) + ", ";
                    }
                    player.setCargoList(newS);
                    cargo.setText(player.getCargoList());
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
                intent.putExtra("Count", c);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                startActivity(intent);
            }
        });
    }

}
