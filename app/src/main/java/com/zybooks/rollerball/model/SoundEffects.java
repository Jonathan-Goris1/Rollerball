package com.zybooks.rollerball.model;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.zybooks.rollerball.R;

import java.util.ArrayList;

public class SoundEffects {
    private static SoundEffects mSoundEffects;

    private SoundPool mSoundPool;

    private int mStartGameSoundId;


    private SoundEffects(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            mSoundPool = new SoundPool.Builder()
                    .setAudioAttributes(attributes)
                    .build();
        }
        else {
            mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }



        mStartGameSoundId = mSoundPool.load(context, R.raw.main_menu_music, 1);

        resetTones();
    }

    public static SoundEffects getInstance(Context context) {
        if (mSoundEffects == null) {
            mSoundEffects = new SoundEffects(context);
        }
        return mSoundEffects;
    }

    public void resetTones() {

    }



    public void playMainMusic() {
        mSoundPool.play(mStartGameSoundId, 1.0f, 1.0f, 1, 0, 1);
    }
}

