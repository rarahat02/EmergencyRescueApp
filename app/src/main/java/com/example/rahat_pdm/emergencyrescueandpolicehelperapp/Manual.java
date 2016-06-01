package com.example.rahat_pdm.emergencyrescueandpolicehelperapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Manual extends AppCompatActivity {

    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        tt = (TextView) findViewById(R.id.textView10);

        Typeface font = Typeface.createFromAsset(getAssets(), "siyamrupali.ttf");
        tt.setTypeface(font);
    }
}
