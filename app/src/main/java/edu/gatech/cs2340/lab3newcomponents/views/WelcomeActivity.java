package edu.gatech.cs2340.lab3newcomponents.views;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import edu.gatech.cs2340.lab3newcomponents.R;
import java.io.Serializable;

import edu.gatech.cs2340.lab3newcomponents.entity.Player;

@SuppressWarnings("ALL")
public class WelcomeActivity extends AppCompatActivity {

    private TextView name;

    private TextView difficulty;

    private TextView pilot;

    private TextView fighter;

    private TextView trader;

    private TextView engineer;

    private ImageView alien;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.welcome_screen_edit);

        /*
         * Grab the dialog widgets so we can get info for later
         */
        name = findViewById(R.id.characterName);
        difficulty = findViewById(R.id.diff);
        pilot = findViewById(R.id.pilotInput);
        fighter = findViewById(R.id.fightInput);
        trader = findViewById(R.id.tradeInput);
        engineer = findViewById(R.id.engInput);
        alien = findViewById(R.id.alienPic);
        Button universeButton = findViewById(R.id.univButton);


        Intent in = getIntent();
        String characterIn = in.getStringExtra("character");
        String difficultyIn = in.getStringExtra("difficulty");
        String pilotIn = in.getStringExtra("Pilot");
        String fighterIn = in.getStringExtra("Fighter");
        String traderIn = in.getStringExtra("Trader");
        String engineerIn = in.getStringExtra("Engineer");
        final Serializable st = getIntent().getSerializableExtra("Player");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable c = getIntent().getSerializableExtra("Count");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");

        name.setText(player.getName());
        difficulty.setText("Difficulty:  " + player.getDifficulty());
        pilot.setText("P points:  " + player.getPilotPoints());
        fighter.setText("F points:  " + player.getFighterPoints());
        trader.setText("T points:  " + player.getTraderPoints());
        engineer.setText("E points:  " + player.getEngineerPoints());

        universeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, PlayActivity.class));
                Intent intent = new Intent(WelcomeActivity.this, PlayActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
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
                startActivity(intent);
            }
        });

    }


}
