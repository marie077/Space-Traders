package edu.gatech.cs2340.lab3newcomponents.views;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import edu.gatech.cs2340.lab3newcomponents.R;
import java.io.Serializable;

import edu.gatech.cs2340.lab3newcomponents.entity.Difficulty;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;

@SuppressWarnings("ALL")
public class PlayActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.play_activity);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Serializable c = getIntent().getSerializableExtra("Count");

        ImageButton marketButton = findViewById(R.id.market);
        Button startOverButton = findViewById(R.id.startOver);
        ImageButton navButton = findViewById(R.id.nav);
        TextView info = findViewById(R.id.information);
        Button saveButton = findViewById(R.id.saveGame);
        final Button buttonOne =  findViewById(R.id.gameOne);
        final Button buttonTwo = findViewById(R.id.gameTwo);
        final Button buttonThree = findViewById(R.id.gameThree);
        final Button buttonFour = findViewById(R.id.gameFour);
        final Button buttonFive = findViewById(R.id.gameFive);

        Intent in = getIntent();
        info.setText("\nPlayer Name: " + player.getName() + "\nPlanet Name: " + player.getPlanet() + "\nCargo: " + player.getCargoList() + "\nMoney: " + player.getMoney() + "\nFuel: " + player.getFuel() + "\nTrader: " + player.getTraderPoints() + " Pilot: " + player.getPilotPoints() +" Fighter: " + player.getFighterPoints() + " Engineer: " + player.getEngineerPoints());

//        RelativeLayout container = (RelativeLayout) findViewById(R.layout.game_list);
//        View view = View.inflate(this, R.layout.play_activity, container);
//        final Button buttonOne = (Button) v.findViewById(R.id.gameOne);

        saveButton.setOnClickListener(new View.OnClickListener() {

//                startActivity(new Intent(PlayActivity.this, GameListActivity.class));
//                Intent intent = new Intent(PlayActivity.this, GameListActivity.class);
//                startActivity(intent);

            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uId = user.getUid();
                player.setPlanet((String) pt);
                Player spaceTrader = player;
                // Write a message to the database
                // Access a Cloud Firestore instance from your Activity
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                //if the user document is null, create a new game

                db.collection("spaceTrader")
                        .document(uId).set(spaceTrader);
                AlertDialog alertDialog = new AlertDialog.Builder(PlayActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Game has been saved and updated");

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
//                PlayActivity playActivity = (PlayActivity)
//                if ((Integer)c == 0)  {
//                    final Serializable st1 = getIntent().getSerializableExtra("Player");
//                    startActivity(new Intent(PlayActivity.this, SavedGameListActivity.class));
//                    Intent intent = new Intent(PlayActivity.this, SavedGameListActivity.class);
//                    intent.putExtra("Player", st);
//                    intent.putExtra("Planet", pt);
//                    intent.putExtra("Player1", st1);
//                    intent.putExtra("Player2", st2);
//                    intent.putExtra("Player3", st3);
//                    intent.putExtra("Player4", st4);
//                    intent.putExtra("Player5", st5);
//                    intent.putExtra("Count", 1);
//                    startActivity(intent);
//
//                } else if ((Integer)c == 1) {
//                    final Serializable st2 = getIntent().getSerializableExtra("Player");
//                    startActivity(new Intent(PlayActivity.this, SavedGameListActivity.class));
//                    Intent intent = new Intent(PlayActivity.this, SavedGameListActivity.class);
//                    intent.putExtra("Player", st);
//                    intent.putExtra("Planet", pt);
//                    intent.putExtra("Player1", st1);
//                    intent.putExtra("Player2", st2);
//                    intent.putExtra("Player3", st3);
//                    intent.putExtra("Player4", st4);
//                    intent.putExtra("Player5", st5);
//                    intent.putExtra("Count", 2);
//                    startActivity(intent);
//
//                } else if ((Integer)c == 2) {
//                    final Serializable st3 = getIntent().getSerializableExtra("Player");
//                    startActivity(new Intent(PlayActivity.this, SavedGameListActivity.class));
//                    Intent intent = new Intent(PlayActivity.this, SavedGameListActivity.class);
//                    intent.putExtra("Player", st);
//                    intent.putExtra("Planet", pt);
//                    intent.putExtra("Player1", st1);
//                    intent.putExtra("Player2", st2);
//                    intent.putExtra("Player3", st3);
//                    intent.putExtra("Player4", st4);
//                    intent.putExtra("Player5", st5);
//                    intent.putExtra("Count", 3);
//                    startActivity(intent);
//
//                } else if ((Integer)c == 3) {
//                    final Serializable st4 = getIntent().getSerializableExtra("Player");
//                    startActivity(new Intent(PlayActivity.this, SavedGameListActivity.class));
//                    Intent intent = new Intent(PlayActivity.this, SavedGameListActivity.class);
//                    intent.putExtra("Player", st);
//                    intent.putExtra("Planet", pt);
//                    intent.putExtra("Player1", st1);
//                    intent.putExtra("Player2", st2);
//                    intent.putExtra("Player3", st3);
//                    intent.putExtra("Player4", st4);
//                    intent.putExtra("Player5", st5);
//                    intent.putExtra("Count", 4);
//                    startActivity(intent);
//
//                } else if ((Integer)c == 4) {
//                    final Serializable st5 = getIntent().getSerializableExtra("Player");
//                    startActivity(new Intent(PlayActivity.this, SavedGameListActivity.class));
//                    Intent intent = new Intent(PlayActivity.this, SavedGameListActivity.class);
//                    intent.putExtra("Player", st);
//                    intent.putExtra("Planet", pt);
//                    intent.putExtra("Player1", st1);
//                    intent.putExtra("Player2", st2);
//                    intent.putExtra("Player3", st3);
//                    intent.putExtra("Player4", st4);
//                    intent.putExtra("Player5", st5);
//                    intent.putExtra("Count", 5);
//                    startActivity(intent);
//
//                } else {
//                    AlertDialog alertDialog = new AlertDialog.Builder(PlayActivity.this).create();
//                    alertDialog.setTitle("Alert");
//                    alertDialog.setMessage("No space to save games");
//
//                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                    alertDialog.show();
//                }

            }
        });

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, MarketplaceCutSceneActivity.class));
                Intent intent = new Intent(PlayActivity.this, MarketplaceCutSceneActivity.class);
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

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getFuel() <= 0) {
                    AlertDialog alertDialog = new AlertDialog.Builder(PlayActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You have no fuel left. Go buy some from the market.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(PlayActivity.this, NavigationCutSceneActivity.class));
                    Intent intent = new Intent(PlayActivity.this, NavigationCutSceneActivity.class);
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

            }
        });

        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, GameListActivity.class));
                Intent intent = new Intent(PlayActivity.this, GameListActivity.class);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Planet", pt);
                intent.putExtra("Count", c);
                startActivity(intent);
            }
        });

    }
}
