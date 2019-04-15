package edu.gatech.cs2340.lab3newcomponents.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.gatech.cs2340.lab3newcomponents.R;
import android.support.annotation.NonNull;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText createUserName;
    private EditText createPass;
    private EditText confirmPass;
    private FirebaseAuth mAuth;
    private static final String TAG = "Auth status:";

    @Override
    protected void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.create_account);

        createUserName = findViewById(R.id.createUserName);
        createPass = findViewById(R.id.createPassword);
        confirmPass = findViewById(R.id.confirmPassword);

        Button createAccountButton = findViewById(R.id.createButton);


        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize Firebase Auth
                mAuth = FirebaseAuth.getInstance();


                if ((createUserName.getText() != null) && (createPass.getText() != null) && (confirmPass.getText() != null) &&
                        (createPass.getText().toString().equals(confirmPass.getText().toString()))) {

                    mAuth.createUserWithEmailAndPassword(createUserName.getText().toString(), createPass.getText().toString())
                            .addOnCompleteListener(CreateAccountActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //why is task not true when it is supposed to be true?
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        startActivity(new Intent(CreateAccountActivity.this, GameListActivity.class));
                                        Intent intent = new Intent(CreateAccountActivity.this, GameListActivity.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(CreateAccountActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Error in Creating Account. Inputs must be valid");

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
