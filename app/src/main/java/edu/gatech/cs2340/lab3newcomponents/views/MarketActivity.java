package edu.gatech.cs2340.lab3newcomponents.views;

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
import java.util.Random;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.market_activity);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Intent in = getIntent();

        Button backButton = findViewById(R.id.button4);
        Button buyButton = findViewById(R.id.button2);
        Button sellButton = findViewById(R.id.button3);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, PlayActivity.class));
                Intent intent = new Intent(MarketActivity.this, PlayActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
                startActivity(intent);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, BuyActivity.class));
                Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
                intent.putExtra("Player", st);
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
                    startActivity(intent);
                } else {
                    String planNum = Character.toString(in.getStringExtra("Planet").charAt(in.getStringExtra("Planet").length() - 1));
                    int x = Integer.parseInt(planNum) * 2;
                    AlertDialog alertDialog = new AlertDialog.Builder(MarketActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("An alien has intercepted your travels and has doubled the prices and moved you to a random planet.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    intent.putExtra("Planet", "Planet " + Integer.toString(x));
                    startActivity(intent);
                }
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, SellActivity.class));
                Intent intent = new Intent(MarketActivity.this, SellActivity.class);
                intent.putExtra("Player", st);
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
                    startActivity(intent);
                } else {
                    String planNum = Character.toString(in.getStringExtra("Planet").charAt(in.getStringExtra("Planet").length() - 1));
                    int x = Integer.parseInt(planNum) * 2;
                    AlertDialog alertDialog = new AlertDialog.Builder(MarketActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("An alien has intercepted your travels and has doubled the prices and moved you to a random planet.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    intent.putExtra("Planet", "Planet " + Integer.toString(x));
                    startActivity(intent);
                }
            }
        });
    }
}
