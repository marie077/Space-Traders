package edu.gatech.cs2340.lab3newcomponents.views;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Difficulty;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;

import java.io.Serializable;
import java.util.Map;

public class GameListActivity extends AppCompatActivity {
    private static final String TAG = "Document status:";
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.start_game_main);

        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable c = getIntent().getSerializableExtra("Count");
        final Serializable st = getIntent().getSerializableExtra("Player");

        Button newGameButton = findViewById(R.id.newGame);
        Button loadGameButton = findViewById(R.id.loadGame);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String uId = user.getUid();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(GameListActivity.this, ConfigurationActivity.class));
                final Intent intent = new Intent(GameListActivity.this, ConfigurationActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Planet", pt);
                if (c == null) {
                    intent.putExtra("Count", 0);
                } else {
                    intent.putExtra("Count", c);
                }

                db.collection("spaceTrader").document(uId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (!document.exists()) {
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(GameListActivity.this);
                                builder.setMessage("Game will be overwritten. Would you like to continue?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                                //Intent intent2 = new Intent(GameListActivity.this, ConfigurationActivity.class);
                                                startActivity(intent);
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();
                            }
                        }
                    }

                });




//                if (db.collection("spaceTrader").document(uId).get() == null) {
//                    startActivity(intent);
//                } else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(GameListActivity.this);
//                    builder.setMessage("Game will be overwritten. Would you like to continue?")
//                            .setCancelable(false)
//                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.dismiss();
//                                    //Intent intent2 = new Intent(GameListActivity.this, ConfigurationActivity.class);
//                                    startActivity(intent);
//                                }
//                            })
//                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//                    AlertDialog alert = builder.create();
//                    alert.show();
//
//                }

            }
        });

        loadGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(GameListActivity.this, PlayActivity.class));
                final Intent intent = new Intent(GameListActivity.this, PlayActivity.class);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Planet", pt);
                if (c == null) {
                    intent.putExtra("Count", 0);
                } else {
                    intent.putExtra("Count", c);
                }

                db.collection("spaceTrader").document(uId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (!document.exists()) {
                                Log.d(TAG, "Document is empty");
                                AlertDialog alertDialog = new AlertDialog.Builder(GameListActivity.this).create();
                                alertDialog.setTitle("Alert");
                                alertDialog.setMessage("No game to load, create a new game!");

                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();
                            } else {
                                Log.d(TAG, "Document is not empty");
                                String name = (String) document.getData().get("name");
                                Difficulty difficulty = Difficulty.valueOf((String)document.getData().get("difficulty"));
                                Integer fighter = Integer.valueOf(((Long) document.getData().get("fighterPoints")).intValue());
                                Integer trader = Integer.valueOf(((Long) document.getData().get("traderPoints")).intValue());
                                Integer engineer = Integer.valueOf(((Long) document.getData().get("engineerPoints")).intValue());
                                Integer pilot = Integer.valueOf(((Long) document.getData().get("pilotPoints")).intValue());
                                Integer money = Integer.valueOf(((Long) document.getData().get("money")).intValue());
                                Integer fuel = Integer.valueOf(((Long) document.getData().get("fuel")).intValue());
                                String cargoList = (String) document.getData().get("cargoList");
                                String planet = (String) document.getData().get("planet");
                                String politics = (String) document.getData().get("politics");
                                intent.putExtra("Player", new Player(name, difficulty, fighter, pilot, trader, engineer, money,cargoList, fuel, planet, politics));
                                startActivity(intent);
                            }
                        }
                    }
                    //}
                });



            }
        });


    }
}
