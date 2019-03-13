package edu.gatech.cs2340.lab3newcomponents.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.io.Serializable;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.play_activity);

        final Serializable st = getIntent().getSerializableExtra("Player");

        ImageButton marketButton = findViewById(R.id.market);
        Button startOverButton = findViewById(R.id.startOver);
        ImageButton navButton = findViewById(R.id.nav);

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, MarketActivity.class));
                Intent intent = new Intent(PlayActivity.this, MarketActivity.class);
                intent.putExtra("Player", st);
                startActivity(intent);
            }
        });

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, UniverseActivity.class));
                Intent intent = new Intent(PlayActivity.this, UniverseActivity.class);
                intent.putExtra("Player", st);
                startActivity(intent);
            }
        });

        startOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, ConfigurationActivity.class));
                Intent intent = new Intent(PlayActivity.this, ConfigurationActivity.class);
                startActivity(intent);
            }
        });

    }
}
