package edu.gatech.cs2340.lab3newcomponents.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Planet;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;
import edu.gatech.cs2340.lab3newcomponents.entity.Resources;
import edu.gatech.cs2340.lab3newcomponents.entity.TechLevel;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;

public class UniverseActivity extends AppCompatActivity {
    private TechLevel tech;
    private Resources resource;
    private int latitude;
    private int longitude;
    private static List<String> var; //what is this

    private static final String TAG = "Planet: ";
    private ImageView planet;
    private TextView name;
    private Button submitP;


    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.universe_edit);
        planet = findViewById(R.id.planet);
        submitP = findViewById(R.id.selectPlanet);
        name = findViewById(R.id.planetName);

        planet.setImageResource(getResources().getIdentifier("p1", "drawable", "edu.gatech.cs2340.lab3newcomponents"));
        name.setText("Planet 1");

        ImageButton next = findViewById(R.id.nextPlanet);
        next.setOnClickListener(new View.OnClickListener() {
            int j = 0;
            ImageView planet = findViewById(R.id.planet);
            final List<String> tradePics = Arrays.asList("p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10");
            public void onClick(View v) {
                j = j + 1;
                planet.setImageResource(getResources().getIdentifier(tradePics.get((j) % tradePics.size()), "drawable", "edu.gatech.cs2340.lab3newcomponents"));
                name.setText("Planet " + Integer.toString((j % tradePics.size()) + 1));
            }
        });

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable c = getIntent().getSerializableExtra("Count");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final String plan = (String) getIntent().getSerializableExtra("Planet");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");


        Button backPlay = findViewById(R.id.buttonBack);
        backPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(UniverseActivity.this, PlayActivity.class));
                    Intent intent = new Intent(UniverseActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st);
                    intent.putExtra("Planet", pt);
                    intent.putExtra("Count", c);
                    intent.putExtra("Player1", st1);
                    intent.putExtra("Player2", st2);
                    intent.putExtra("Player3", st3);
                    intent.putExtra("Player4", st4);
                    intent.putExtra("Player5", st5);
                    //player.setFuel(player.getFuel() - 10);
                    startActivity(intent);
            }
        });

        Button submitP = findViewById(R.id.selectPlanet);
        submitP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inP = getIntent();
                if (inP.getStringExtra("Planet") == name.getText()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(UniverseActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("You are already on this planet.");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    startActivity(new Intent(UniverseActivity.this, PlayActivity.class));
                    Intent intent = new Intent(UniverseActivity.this, PlayActivity.class);
                    intent.putExtra("Player", st);
                    intent.putExtra("Planet", name.getText());
                    intent.putExtra("Count", c);
                    intent.putExtra("Player1", st1);
                    intent.putExtra("Player2", st2);
                    intent.putExtra("Player3", st3);
                    intent.putExtra("Player4", st4);
                    intent.putExtra("Player5", st5);
                    player.setFuel(player.getFuel() - 10);
                    startActivity(intent);
                }
            }
        });
    }
}
