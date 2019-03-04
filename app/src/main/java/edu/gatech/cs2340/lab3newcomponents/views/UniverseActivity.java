package edu.gatech.cs2340.lab3newcomponents.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
    private static List<String>;

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
    }
}
