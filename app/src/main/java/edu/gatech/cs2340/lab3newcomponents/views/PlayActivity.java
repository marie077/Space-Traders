package edu.gatech.cs2340.lab3newcomponents.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.io.Serializable;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.play_activity);

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Player player = (Player) getIntent().getSerializableExtra("Player");

        ImageButton marketButton = findViewById(R.id.market);
        Button startOverButton = findViewById(R.id.startOver);
        ImageButton navButton = findViewById(R.id.nav);
        TextView info = findViewById(R.id.information);

        Intent in = getIntent();
        info.setText("\nPlayer Name: " + player.getName() + "\nPlanet Name: " + in.getStringExtra("Planet") + "\nCargo: " + player.getCargoList() + "\nMoney: " + player.getMoney() + "\nFuel: " + player.getFuel());

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, MarketActivity.class));
                Intent intent = new Intent(PlayActivity.this, MarketActivity.class);
                intent.putExtra("Player", st);
                intent.putExtra("Planet", pt);
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
                    startActivity(new Intent(PlayActivity.this, UniverseActivity.class));
                    Intent intent = new Intent(PlayActivity.this, UniverseActivity.class);
                    intent.putExtra("Player", st);
                    intent.putExtra("Planet", pt);
                    startActivity(intent);
                }

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
