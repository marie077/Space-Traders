package edu.gatech.cs2340.lab3newcomponents.views;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;
import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Difficulty;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;


@SuppressWarnings("ALL")
public class ConfigurationActivity extends AppCompatActivity {


// widgets we will need in our view

    private EditText playerName;

    private TextView difficultTitle;

    private Spinner difficultyLevel;

    private TextView skillTitle;

    private TextView skillOneTitle;

    private Spinner skillTypeOne;

    private TextView skillTwoTitle;

    private Spinner skillTypeTwo;

    private TextView skillThreeTitle;

    private Spinner skillTypeThree;

    private TextView skillFourTitle;

    private Spinner skillTypeFour;

    private Player player;

    MediaPlayer mediaPlayer;

    private final String TAG = "Space Trader Instatiation:";

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.character_edit);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

        mediaPlayer.start();
        /*
         * Grab the dialog widgets so we can get info for later
         */
        playerName = findViewById(R.id.name);
        difficultTitle = findViewById(R.id.diff);
        difficultyLevel = findViewById(R.id.diffLevel);
        skillTitle = findViewById(R.id.skillTitle);
        skillOneTitle = findViewById(R.id.firstSkillTitle);
        skillTypeOne = findViewById(R.id.firstSkillSpin);
        skillTwoTitle = findViewById(R.id.secondSkillTitle);
        skillTypeTwo = findViewById(R.id.secondSkillSpin);
        skillThreeTitle = findViewById(R.id.thirdSkillTitle);
        skillTypeThree = findViewById(R.id.thirdSkillSpin);
        skillFourTitle = findViewById(R.id.fourthSkillTitle);
        skillTypeFour = findViewById(R.id.fourthSkillSpin);
        Button startButton = findViewById(R.id.startGameButton);

         /*
          Set up the adapter to display the allowable difficulties in the spinner
         */

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultyLevel.setAdapter(adapter);

        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Player.pointList);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skillTypeOne.setAdapter(adapter2);

        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Player.pointList);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skillTypeTwo.setAdapter(adapter3);

        ArrayAdapter<Integer> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Player.pointList);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skillTypeThree.setAdapter(adapter4);

        ArrayAdapter<Integer> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Player.pointList);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skillTypeFour.setAdapter(adapter5);

        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Serializable c = getIntent().getSerializableExtra("Count");

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //maybe we need to instantiate a player using the constructor here? not sure?
                int pilotPoints = Integer.parseInt(skillTypeOne.getSelectedItem().toString());
                int fighterPoints = Integer.parseInt(skillTypeTwo.getSelectedItem().toString());
                int traderPoints = Integer.parseInt(skillTypeThree.getSelectedItem().toString());
                int engineerPoints = Integer.parseInt(skillTypeFour.getSelectedItem().toString());
                int check = pilotPoints + fighterPoints + traderPoints + engineerPoints;

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uId = user.getUid();

                if ((check == 16) && (playerName.getText() != null)) {
                    //instantiated a user!
                    Player spaceTrader = new Player(playerName.getText().toString(), (Difficulty) difficultyLevel.getSelectedItem(), fighterPoints, pilotPoints, traderPoints, engineerPoints, 1000, "", 50);
                    // Write a message to the database
                    // Access a Cloud Firestore instance from your Activity

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    db.collection("spaceTrader")
                            .document(uId).set(spaceTrader);
//                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                @Override
//                                public void onSuccess(DocumentReference documentReference) {
//                                    Log.d(TAG, "DocumentSnapshot added with ID:" + documentReference.getId());
//                                }
//                            })
//                            .addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.w(TAG, "Error adding document", e);
//                                }
//                            });


                    startActivity(new Intent(ConfigurationActivity.this, WelcomeActivity.class));
                    Intent intent = new Intent(ConfigurationActivity.this, WelcomeActivity.class);
                    intent.putExtra("character", spaceTrader.getName());
                    intent.putExtra("difficulty", spaceTrader.getDifficulty().toString());
                    intent.putExtra("Pilot", spaceTrader.getPilotPoints().toString());
                    intent.putExtra("Fighter", spaceTrader.getFighterPoints().toString());
                    intent.putExtra("Trader",spaceTrader.getTraderPoints().toString());
                    intent.putExtra("Engineer", spaceTrader.getEngineerPoints().toString());
                    intent.putExtra("Player", spaceTrader);
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
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(ConfigurationActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Points must total to 16 and you must have a character name if you have not put one in!");

                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }

            }

        });


    }

}
