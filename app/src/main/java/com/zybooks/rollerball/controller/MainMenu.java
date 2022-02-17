package com.zybooks.rollerball.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.zybooks.rollerball.R;
import com.zybooks.rollerball.model.SoundEffects;

public class MainMenu extends AppCompatActivity {

    private Button playButton;
    private SoundEffects mSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        playButton = findViewById(R.id.play_button);

        mSound = SoundEffects.getInstance(this);

        mSound.playMainMusic();

        playButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}