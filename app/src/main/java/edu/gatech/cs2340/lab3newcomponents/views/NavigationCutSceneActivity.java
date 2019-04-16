package edu.gatech.cs2340.lab3newcomponents.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import java.io.Serializable;

import edu.gatech.cs2340.lab3newcomponents.R;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;

public class NavigationCutSceneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_cut_scene);
        VideoView simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);
        Uri uriPath = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.spacetravel);
        //simpleVideoView.setRotation(90f);
        simpleVideoView.setVideoURI(uriPath);
        simpleVideoView.start();

        final Serializable st = getIntent().getSerializableExtra("Player");
        final Serializable pt = getIntent().getSerializableExtra("Planet");
        final Player player = (Player) getIntent().getSerializableExtra("Player");
        final Serializable st1 = getIntent().getSerializableExtra("Player1");
        final Serializable st2 = getIntent().getSerializableExtra("Player2");
        final Serializable st3 = getIntent().getSerializableExtra("Player3");
        final Serializable st4 = getIntent().getSerializableExtra("Player4");
        final Serializable st5 = getIntent().getSerializableExtra("Player5");
        final Serializable c = getIntent().getSerializableExtra("Count");

        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent(NavigationCutSceneActivity.this, UniverseMapActivity.class);
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
