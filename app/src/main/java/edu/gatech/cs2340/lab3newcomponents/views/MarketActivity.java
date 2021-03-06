package edu.gatech.cs2340.lab3newcomponents.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;

import java.io.Serializable;
import java.util.Random;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.market_activity);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Player player = (Player) st;
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Serializable c = getIntent().getSerializableExtra("Count");
        final Intent in = getIntent();

        Button backButton = findViewById(R.id.button4);
        Button buyButton = findViewById(R.id.button2);
        Button sellButton = findViewById(R.id.button3);
        Button hireButton = findViewById(R.id.button5);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, PlayActivity.class));
                Intent intent = new Intent(MarketActivity.this, PlayActivity.class);
                intent.putExtra("Count",c);
                intent.putExtra("Player", st);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                String planNum = Character.toString(player.getPlanet().charAt(player.getPlanet().length() - 1));
                int x = Integer.parseInt(planNum) % 10;
                intent.putExtra("Planet", "Planet " + Integer.toString(x));
                startActivity(intent);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, BuyActivity.class));
                Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
                intent.putExtra("Player", st);
                Player player = (Player) st;
                intent.putExtra("Count", c);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                Random rand = new Random();
                int n = rand.nextInt(10);
                if (n >= 0 && n <= 5) {
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Player", st);
                    startActivity(intent);
                } else if (n == 6 || n == 7) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MarketActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You have been transported to Planet 2 for free! Prices in market now match Planet 2's prices.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    intent.putExtra("Planet", "Planet 2");
                    player.setPolitics("Capitalist");
                    intent.putExtra("Player", player);
                    intent.putExtra("Count",c);
                    startActivity(intent);
                } else {
                    String planNum = Character.toString(player.getPlanet().charAt(player.getPlanet().length() - 1));
                    int x = Integer.parseInt(planNum) * 2;
                    AlertDialog alertDialog = new AlertDialog.Builder(MarketActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("An alien has intercepted your travels and has stolen 100 dollars!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    //intent.putExtra("Planet", "Planet " + Integer.toString(x));
                    player.setMoney(player.getMoney() - 100);
                    intent.putExtra("Player", player);
                    intent.putExtra("Planet", "Planet " + Integer.toString(x));
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });

        hireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, MercenaryActivity.class));
                Intent intent = new Intent(MarketActivity.this, MercenaryActivity.class);
                intent.putExtra("Player", st);
                Player player = (Player) st;
                intent.putExtra("Count", c);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                startActivity(intent);
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, SellActivity.class));
                Intent intent = new Intent(MarketActivity.this, SellActivity.class);
                intent.putExtra("Player", st);
                Player player = (Player) st;
                intent.putExtra("Count", c);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                Random rand = new Random();
                int n = rand.nextInt(10);
                if (n >= 0 && n <= 5) {
                    intent.putExtra("Planet", pt);
                    startActivity(intent);
                } else if (n == 6 || n == 7) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MarketActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You have been transported to Planet 2 for free! Prices in market now match Planet 2's prices.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    intent.putExtra("Planet", "Planet 2");
                    intent.putExtra("Count", c);
                    startActivity(intent);
                } else {
                    String planNum = Character.toString(player.getPlanet().charAt(player.getPlanet().length() - 1));
                    int x = Integer.parseInt(planNum) * 2;
                    AlertDialog alertDialog = new AlertDialog.Builder(MarketActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("An alien has intercepted your travels and has moved you to a random planet.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    intent.putExtra("Planet", "Planet " + Integer.toString(x));
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });
    }
}
