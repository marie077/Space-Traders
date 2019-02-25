package edu.gatech.cs2340.lab3newcomponents.views;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Difficulty;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;
import edu.gatech.cs2340.lab3newcomponents.viewmodels.ConfigurationViewModel;


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



    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.character_edit);

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


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pilotPoints = Integer.parseInt(skillTypeOne.getSelectedItem().toString());
                int fighterPoints = Integer.parseInt(skillTypeTwo.getSelectedItem().toString());
                int traderPoints = Integer.parseInt(skillTypeThree.getSelectedItem().toString());
                int engineerPoints = Integer.parseInt(skillTypeFour.getSelectedItem().toString());
                int check = pilotPoints + fighterPoints + traderPoints + engineerPoints;
                if ((check == 16) && (playerName.getText() != null)) {
                    startActivity(new Intent(ConfigurationActivity.this, WelcomeActivity.class));


                    Intent intent = new Intent(ConfigurationActivity.this, WelcomeActivity.class);
                    intent.putExtra("character", playerName.getText().toString());
                    intent.putExtra("difficulty", difficultyLevel.getSelectedItem().toString());
                    intent.putExtra("Pilot", skillTypeOne.getSelectedItem().toString());
                    intent.putExtra("Fighter", skillTypeTwo.getSelectedItem().toString());
                    intent.putExtra("Trader", skillTypeThree.getSelectedItem().toString());
                    intent.putExtra("Engineer", skillTypeFour.getSelectedItem().toString());
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
//        Integer one = (Integer)skillTypeOne.getSelectedItem();
//        Integer two = (Integer)skillTypeTwo.getSelectedItem();
//        Integer three = (Integer)skillTypeThree.getSelectedItem();
//        Integer four = (Integer)skillTypeFour.getSelectedItem();

//        startButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Integer one = (Integer)skillTypeOne.getSelectedItem();
//                Integer two = (Integer)skillTypeTwo.getSelectedItem();
//                Integer three = (Integer)skillTypeThree.getSelectedItem();
//                Integer four = (Integer)skillTypeFour.getSelectedItem();
//                if ((one + two + three + four) == 16) {
//                    Toast.makeText(this, "yay", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });



//        if ((one + two + three + four) == 16) {
//
//        }

//        skillTypeOne.setSelection(Player.findPosition(player.getPoints()));
//        skillTypeTwo.setSelection(Player.findPosition(player.getPoints()));
//        skillTypeThree.setSelection(Player.findPosition(player.getPoints()));
//        skillTypeFour.setSelection(Player.findPosition(player.getPoints()));

//        if (skillTypeOne.getSelectedItemPosition() + skillTypeTwo.getSelectedItemPosition() + skillTypeThree.getSelectedItemPosition() + skillTypeFour.getSelectedItemPosition() == 16) {
//            startButton.setText("Yes");
//        } else {
//            startButton.setText("No");
//        }

    }
//
//    public void onClick(View view) {
//        Integer one = (Integer)skillTypeOne.getSelectedItem();
//        Integer two = (Integer)skillTypeTwo.getSelectedItem();
//        Integer three = (Integer)skillTypeThree.getSelectedItem();
//        Integer four = (Integer)skillTypeFour.getSelectedItem();
//        if ((one + two + three + four) == 16) {
//            Toast.makeText(this, "yay", Toast.LENGTH_SHORT).show();
//            player.setName(playerName.getText().toString());
//            player.setDifficulty((Difficulty) difficultyLevel.getSelectedItem());
//            player.setPilotPoints((Integer)skillTypeOne.getSelectedItem());
//            player.setFighterPoints((Integer)skillTypeTwo.getSelectedItem());
//            player.setTraderPoints((Integer)skillTypeThree.getSelectedItem());
//            player.setEngineerPoints((Integer)skillTypeFour.getSelectedItem());
//        } else {
//            Toast.makeText(this, "Can't create player: Make sure the points add up to 16!", Toast.LENGTH_SHORT).show();
//        }
//    }


    /**
     * Button handler for the add new student button
     *
     * @param view the button that was pressed
     */
    public void onAddPressed(View view) {
        //Log.d("Edit", "Add/Update Student Pressed");



        player.setName(playerName.getText().toString());
        player.setDifficulty((Difficulty) difficultyLevel.getSelectedItem());

        Log.d("Edit", "Got new student data: " + player);

        //do the right thing depending on whether this is a new student or an edit

        //finish();
    }

}
