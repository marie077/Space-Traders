package edu.gatech.cs2340.lab3newcomponents.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import edu.gatech.cs2340.lab3newcomponents.R;

public class WelcomeActivity extends AppCompatActivity {

    private TextView name;

    private TextView difficulty;

    private TextView pilot;

    private TextView fighter;

    private TextView trader;

    private TextView engineer;

    private ImageView alien;

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

    }
}
