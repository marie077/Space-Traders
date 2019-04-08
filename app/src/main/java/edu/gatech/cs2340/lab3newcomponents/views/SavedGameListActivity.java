package edu.gatech.cs2340.lab3newcomponents.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;

public class SavedGameListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.game_list);

        final Button buttonOne = findViewById(R.id.gameOne);
        final Button buttonTwo = findViewById(R.id.gameTwo);
        final Button buttonThree = findViewById(R.id.gameThree);
        final Button buttonFour= findViewById(R.id.gameFour);
        final Button buttonFive = findViewById(R.id.gameFive);
        final Button back = findViewById(R.id.backButton);

        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable c = getIntent().getSerializableExtra("Count");

        final Integer count = (Integer) getIntent().getSerializableExtra("Count");
        if (count == 1) {
            buttonOne.setText(((Player) st1).getName());
        } else if (count == 2) {
            buttonOne.setText(((Player) st1).getName());
            buttonTwo.setText(((Player) st2).getName());
        } else if (count == 3) {
            buttonOne.setText(((Player) st1).getName());
            buttonTwo.setText(((Player) st2).getName());
            buttonThree.setText(((Player) st3).getName());
        } else if (count == 4) {
            buttonOne.setText(((Player) st1).getName());
            buttonTwo.setText(((Player) st2).getName());
            buttonThree.setText(((Player) st3).getName());
            buttonFour.setText(((Player) st4).getName());
        } else if (count == 5) {
            buttonOne.setText(((Player) st1).getName());
            buttonTwo.setText(((Player) st2).getName());
            buttonThree.setText(((Player) st3).getName());
            buttonFour.setText(((Player) st4).getName());
            buttonFive.setText(((Player) st5).getName());
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavedGameListActivity.this, PlayActivity.class));
                Intent intent = new Intent(SavedGameListActivity.this, PlayActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
                intent.putExtra("Count", c);
                startActivity(intent);
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonOne.getText().toString().equals("NO GAME")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SavedGameListActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No Game Saved Here!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(SavedGameListActivity.this, PlayActivity.class));
                    Intent intent = new Intent(SavedGameListActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st1);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonTwo.getText().toString().equals("NO GAME")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SavedGameListActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No Game Saved Here!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(SavedGameListActivity.this, PlayActivity.class));
                    Intent intent = new Intent(SavedGameListActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st2);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonThree.getText().toString().equals("NO GAME")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SavedGameListActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No Game Saved Here!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(SavedGameListActivity.this, PlayActivity.class));
                    Intent intent = new Intent(SavedGameListActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st3);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonFour.getText().toString().equals("NO GAME")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SavedGameListActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No Game Saved Here!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(SavedGameListActivity.this, PlayActivity.class));
                    Intent intent = new Intent(SavedGameListActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st4);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonFive.getText().toString().equals("NO GAME")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SavedGameListActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("No Game Saved Here!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(SavedGameListActivity.this, PlayActivity.class));
                    Intent intent = new Intent(SavedGameListActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st5);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", c);
                    startActivity(intent);
                }
            }
        });

    }


}
