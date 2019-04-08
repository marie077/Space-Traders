package edu.gatech.cs2340.lab3newcomponents.views;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import edu.gatech.cs2340.lab3newcomponents.R;
import java.io.Serializable;

public class GameListActivity extends AppCompatActivity {

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

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameListActivity.this, ConfigurationActivity.class));
                Intent intent = new Intent(GameListActivity.this, ConfigurationActivity.class);
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
                startActivity(intent);
            }
        });

        loadGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameListActivity.this, SavedGameListActivity.class));
                Intent intent = new Intent(GameListActivity.this, SavedGameListActivity.class);
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
