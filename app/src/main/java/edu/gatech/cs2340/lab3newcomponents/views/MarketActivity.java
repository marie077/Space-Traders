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

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.market_activity);

        final Serializable st = getIntent().getSerializableExtra("Player");

        Button backButton = findViewById(R.id.button4);
        Button buyButton = findViewById(R.id.button2);
        Button sellButton = findViewById(R.id.button3);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, PlayActivity.class));
                Intent intent = new Intent(MarketActivity.this, PlayActivity.class);
                intent.putExtra("Player", st);
                startActivity(intent);
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, BuyActivity.class));
                Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
                intent.putExtra("Player", st);
                startActivity(intent);
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketActivity.this, SellActivity.class));
                Intent intent = new Intent(MarketActivity.this, SellActivity.class);
                intent.putExtra("Player", st);
                startActivity(intent);
            }
        });
    }
}
