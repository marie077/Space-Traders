package edu.gatech.cs2340.lab3newcomponents.views;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.lab3newcomponents.R;

public class GameListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.start_game_main);

        Button newGameButton = findViewById(R.id.newGame);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameListActivity.this, ConfigurationActivity.class));
                Intent intent = new Intent(GameListActivity.this, ConfigurationActivity.class);
                startActivity(intent);
            }
        });
    }
}
