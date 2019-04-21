package edu.gatech.cs2340.lab3newcomponents.views;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.io.Serializable;
import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;

public class MercenaryActivity extends AppCompatActivity {
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.mercenary_screen);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable c = getIntent().getSerializableExtra("Count");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Intent ip = getIntent();

        final TextView moneyAmt = findViewById(R.id.moneyAmount);
        moneyAmt.setText(String.format("$%d", player.getMoney()));

        Button back = findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MercenaryActivity.this, MarketActivity.class));
                Intent intent = new Intent(MercenaryActivity.this, MarketActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                startActivity(intent);
            }
        });

        Button hireTrader = findViewById(R.id.traderHire);
        hireTrader.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if (800 > player.getMoney()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You don't have enough money. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else if (player.getTraderPoints() > 15) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You can't have more than 16 points. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    player.setMoney(player.getMoney() - 800);
                    moneyAmt.setText(String.format("$%d", player.getMoney()));
                    player.setTraderPoints(player.getTraderPoints() + 1);
                }
            }
        });

        Button hirePilot = findViewById(R.id.pilotHire);
        hirePilot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if (1000 > player.getMoney()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You don't have enough money. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else if (player.getPilotPoints() > 15) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You can't have more than 16 points total. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    player.setMoney(player.getMoney() - 1000);
                    moneyAmt.setText(String.format("$%d", player.getMoney()));
                    player.setPilotPoints(player.getPilotPoints() + 1);
                }
            }
        });

        Button hireFighter = findViewById(R.id.fighterHire);
        hireFighter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if (1200 > player.getMoney()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You don't have enough money. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else if (player.getFighterPoints() > 15) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You can't have more than 16 points total. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    player.setMoney(player.getMoney() - 1200);
                    moneyAmt.setText(String.format("$%d", player.getMoney()));
                    player.setFighterPoints(player.getFighterPoints() + 1);
                }
            }
        });

        Button hireEngineer = findViewById(R.id.engineerHire);
        hireEngineer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                if (1200 > player.getMoney()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You don't have enough money. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else if (player.getEngineerPoints() > 15) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MercenaryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You can't have more than 16 points total. Try again!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    player.setMoney(player.getMoney() - 1200);
                    moneyAmt.setText(String.format("$%d", player.getMoney()));
                    player.setEngineerPoints(player.getEngineerPoints() + 1);
                }
            }
        });

    }

}
