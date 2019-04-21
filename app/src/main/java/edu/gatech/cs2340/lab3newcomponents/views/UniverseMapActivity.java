package edu.gatech.cs2340.lab3newcomponents.views;


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


public class UniverseMapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.universe_map);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable pl = getIntent().getSerializableExtra("Politics");
        final Serializable c = getIntent().getSerializableExtra("Count");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final String plan = (String) getIntent().getSerializableExtra("Planet");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");

        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
                intent.putExtra("Politics", pl);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                startActivity(intent);
            }
        });
        Button one = findViewById(R.id.planetonebutton);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                final Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 1");
                player.setPolitics("Anarchy");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 1 is an Anarchy. Food is in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button two = findViewById(R.id.planettwobutton);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 2");
                player.setPolitics("Capitalist");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 2 is Capitalist. Ore is in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button three = findViewById(R.id.planetthreebutton);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 3");
                player.setPolitics("Confederacy");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 3 is a Confederacy. Games are in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button four = findViewById(R.id.planetfourbutton);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 4");
                player.setPolitics("Corporate");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 4 is Corporate. Robots are in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button five = findViewById(R.id.planetfivebutton);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 5");
                player.setPolitics("Cybernetic");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 5 is Cybernetic. Narcotics is in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button six = findViewById(R.id.planetsixbutton);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 6");
                player.setPolitics("Democracy");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 1 is a Democracy. Furs are in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button seven = findViewById(R.id.planetsevenbutton);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 7");
                player.setPolitics("Fascist");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 1 is Fascist. Machines are in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button eight = findViewById(R.id.planeteightbutton);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 8");
                player.setPolitics("Feudal");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 1 is Feudal. Firearms are in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button nine = findViewById(R.id.planetninebutton);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 9");
                player.setPolitics("Military");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 1 is Military. Water is in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });
        Button ten = findViewById(R.id.planettenbutton);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, PlayActivity.class);
                player.setPlanet("Planet 10");
                player.setPolitics("Monarchy");
                player.setFuel(player.getFuel() - 10);
                intent.putExtra("Player", player);
                intent.putExtra("Planet", pt);
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                AlertDialog.Builder builder = new AlertDialog.Builder(UniverseMapActivity.this);
                builder.setMessage("Planet 1 is a Monarchy. Medicine is in high demand!")
                        .setCancelable(false)
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                startActivity(intent);
            }
        });

//        Button travel = findViewById(R.id.travelButton);
//        travel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(UniverseMapActivity.this, UniverseActivity.class));
//                Intent intent = new Intent(UniverseMapActivity.this, UniverseActivity.class);
//                intent.putExtra("Player", st);
//                intent.putExtra("Planet", pt);
//                intent.putExtra("Player1", st1);
//                intent.putExtra("Player2", st2);
//                intent.putExtra("Player3", st3);
//                intent.putExtra("Player4", st4);
//                intent.putExtra("Player5", st5);
//                intent.putExtra("Count", c);
//                startActivity(intent);
//            }
//        });
    }
}
