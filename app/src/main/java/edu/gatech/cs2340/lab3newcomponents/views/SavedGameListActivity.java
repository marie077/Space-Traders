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

        Player player1 = (Player) st1;
        Player player2 = (Player) st2;
        Player player3 = (Player) st3;
        Player player4 = (Player) st4;
        Player player5 = (Player) st5;

        Integer count = (Integer) getIntent().getSerializableExtra("Count");
        if (count == 1) {
            buttonOne.setText(((Player) st1).getName());
        } else if (count == 2) {
            if (((Player) st1).getName().equals(((Player) st2).getName())) {
                buttonOne.setText(((Player) st1).getName());
                player1 = player2;
                player1.setCargoList(player2.getCargoList());
                count--;
            } else {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
            }
        } else if (count == 3) {
            if (((Player) st1).getName().equals(((Player) st3).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                player1 = player3;
                player1.setCargoList(player3.getCargoList());
                count--;
            } else if (((Player) st2).getName().equals(((Player) st3).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                player2 = player3;
                player2.setCargoList(player3.getCargoList());
                count--;
            } else {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
            }
        } else if (count == 4) {
            if (((Player) st1).getName().equals(((Player) st4).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                player1 = player4;
                player1.setCargoList(player4.getCargoList());
                count--;
            } else if (((Player) st2).getName().equals(((Player) st4).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                player2 = player4;
                player2.setCargoList(player3.getCargoList());
                count--;
            } else if (((Player) st3).getName().equals(((Player) st4).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                player3 = player4;
                player3.setCargoList(player4.getCargoList());
                count--;
            } else {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                buttonFour.setText(((Player) st4).getName());
            }
        } else if (count == 5) {
            if (((Player) st1).getName().equals(((Player) st5).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                buttonFour.setText(((Player) st4).getName());
                player1 = player5;
                player1.setCargoList(player5.getCargoList());
                count--;
            } else if (((Player) st2).getName().equals(((Player) st5).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                buttonFour.setText(((Player) st4).getName());
                player2 = player5;
                player2.setCargoList(player5.getCargoList());
                count--;
            } else if (((Player) st3).getName().equals(((Player) st5).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                buttonFour.setText(((Player) st4).getName());
                player3 = player5;
                player3.setCargoList(player5.getCargoList());
                count--;
            } else if (((Player) st4).getName().equals(((Player) st5).getName())) {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                buttonFour.setText(((Player) st4).getName());
                player4 = player5;
                player4.setCargoList(player5.getCargoList());
                count--;
            } else {
                buttonOne.setText(((Player) st1).getName());
                buttonTwo.setText(((Player) st2).getName());
                buttonThree.setText(((Player) st3).getName());
                buttonFour.setText(((Player) st4).getName());
                buttonFive.setText(((Player) st5).getName());
            }
        }

        final Integer countFinal = count;
        final Player player1Final = player1;
        final Player player2Final = player2;
        final Player player3Final = player3;
        final Player player4Final = player4;
        final Player player5Final = player5;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SavedGameListActivity.this, GameListActivity.class));
                Intent intent = new Intent(SavedGameListActivity.this, GameListActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
                intent.putExtra("Count", countFinal);
                intent.putExtra("Player1", player1Final);
                intent.putExtra("Player2", player2Final);
                intent.putExtra("Player3", player3Final);
                intent.putExtra("Player4", player4Final);
                intent.putExtra("Player5", player5Final);
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
//                    if ((Integer)c == 1) {
//                        intent.putExtra("Player", player1Final);
//                    } else if ((Integer)c == 2) {
//                        intent.putExtra("Player", player2Final);
//                    } else if ((Integer) c == 3) {
//                        intent.putExtra("Player", player3Final);
//                    } else if ((Integer) c == 4) {
//                        intent.putExtra("Player", player4Final);
//                    } else {
//                        intent.putExtra("Player", player5Final);
//                    }
                    intent.putExtra("Player", player1Final);
                    intent.putExtra("Player1", player1Final);
                    intent.putExtra("Player2", player2Final);
                    intent.putExtra("Player3", player3Final);
                    intent.putExtra("Player4", player4Final);
                    intent.putExtra("Player5", player5Final);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", countFinal);
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
//                    if ((Integer)c == 1) {
//                        intent.putExtra("Player", player1Final);
//                    } else if ((Integer)c == 2) {
//                        intent.putExtra("Player", player2Final);
//                    } else if ((Integer) c == 3) {
//                        intent.putExtra("Player", player3Final);
//                    } else if ((Integer) c == 4) {
//                        intent.putExtra("Player", player4Final);
//                    } else {
//                        intent.putExtra("Player", player5Final);
//                    }
                    intent.putExtra("Player", player2Final);
                    intent.putExtra("Player1", player1Final);
                    intent.putExtra("Player2", player2Final);
                    intent.putExtra("Player3", player3Final);
                    intent.putExtra("Player4", player4Final);
                    intent.putExtra("Player5", player5Final);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", countFinal);
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
//                    if ((Integer)c == 1) {
//                        intent.putExtra("Player", player1Final);
//                    } else if ((Integer)c == 2) {
//                        intent.putExtra("Player", player2Final);
//                    } else if ((Integer) c == 3) {
//                        intent.putExtra("Player", player3Final);
//                    } else if ((Integer) c == 4) {
//                        intent.putExtra("Player", player4Final);
//                    } else {
//                        intent.putExtra("Player", player5Final);
//                    }
                    intent.putExtra("Player", player3Final);
                    intent.putExtra("Player1", player1Final);
                    intent.putExtra("Player2", player2Final);
                    intent.putExtra("Player3", player3Final);
                    intent.putExtra("Player4", player4Final);
                    intent.putExtra("Player5", player5Final);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", countFinal);
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
//                    if ((Integer)c == 1) {
//                        intent.putExtra("Player", player1Final);
//                    } else if ((Integer)c == 2) {
//                        intent.putExtra("Player", player2Final);
//                    } else if ((Integer) c == 3) {
//                        intent.putExtra("Player", player3Final);
//                    } else if ((Integer) c == 4) {
//                        intent.putExtra("Player", player4Final);
//                    } else {
//                        intent.putExtra("Player", player5Final);
//                    }
                    intent.putExtra("Player", player4Final);
                    intent.putExtra("Player1", player1Final);
                    intent.putExtra("Player2", player2Final);
                    intent.putExtra("Player3", player3Final);
                    intent.putExtra("Player4", player4Final);
                    intent.putExtra("Player5", player5Final);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", countFinal);
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
//                    if ((Integer)c == 1) {
//                        intent.putExtra("Player", player1Final);
//                    } else if ((Integer)c == 2) {
//                        intent.putExtra("Player", player2Final);
//                    } else if ((Integer) c == 3) {
//                        intent.putExtra("Player", player3Final);
//                    } else if ((Integer) c == 4) {
//                        intent.putExtra("Player", player4Final);
//                    } else {
//                        intent.putExtra("Player", player5Final);
//                    }
                    intent.putExtra("Player", player5Final);
                    intent.putExtra("Player1", player1Final);
                    intent.putExtra("Player2", player2Final);
                    intent.putExtra("Player3", player3Final);
                    intent.putExtra("Player4", player4Final);
                    intent.putExtra("Player5", player5Final);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", countFinal);
                    startActivity(intent);
                }
            }
        });

    }


}
