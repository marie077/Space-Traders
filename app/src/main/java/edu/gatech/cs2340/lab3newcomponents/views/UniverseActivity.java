package edu.gatech.cs2340.lab3newcomponents.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Planet;
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
    private TextView outputText;


    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.universe_edit);
        outputText = findViewById(R.id.out);
        String output = "";
        Universe solarUniv = new Universe(TechLevel.AGRICULTURE, Resources.MINERALRICH,35, 40, "Universe Space");
        output = solarUniv.createPlanets();
//        for (int i = 0; i < 10; i++) {
//            Planet plan = planetArr[0];
//            output +=  "PLANET: Name: " + plan.getName() + "\nLatitude: " + plan.getLatitude() + "\nLongitude: " + plan.getLongitude() + "\nLevel: " + plan.getLevel() + "\nResource: " + plan.getResources();
//        }
        //output += "hi";
        //Toast.makeText(this,output, Toast.LENGTH_SHORT).show();
        outputText.setText(output);
        final Serializable st = getIntent().getSerializableExtra("Player");

        Button backPlay = findViewById(R.id.buttonBack);
        backPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UniverseActivity.this, PlayActivity.class));
                Intent intent = new Intent(UniverseActivity.this, PlayActivity.class);
                intent.putExtra("Player", st);
                startActivity(intent);
            }
        });
    }
}
