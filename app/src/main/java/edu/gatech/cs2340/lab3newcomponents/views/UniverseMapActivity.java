package edu.gatech.cs2340.lab3newcomponents.views;


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
                intent.putExtra("Player1", st1);
                intent.putExtra("Player2", st2);
                intent.putExtra("Player3", st3);
                intent.putExtra("Player4", st4);
                intent.putExtra("Player5", st5);
                intent.putExtra("Count", c);
                startActivity(intent);
            }
        });

        Button travel = findViewById(R.id.travelButton);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseMapActivity.this, UniverseActivity.class));
                Intent intent = new Intent(UniverseMapActivity.this, UniverseActivity.class);
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
    }
}
