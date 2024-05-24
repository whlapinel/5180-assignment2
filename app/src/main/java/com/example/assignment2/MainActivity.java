package com.example.assignment2;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public int red = 64;
    public int green = 128;
    public int blue = 0;
    public SeekBar redBar;
    public SeekBar greenBar;
    public SeekBar blueBar;

    TextView redText;
    TextView greenText;
    TextView blueText;
    ImageView colorView;

    Button whiteButton;
    Button blackButton;
    Button blueButton;
    Button resetButton;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        redBar = findViewById(R.id.seekBarRed);
        greenBar = findViewById(R.id.seekBarGreen);
        blueBar = findViewById(R.id.seekBarBlue);

        redText = findViewById(R.id.redText);
        greenText = findViewById(R.id.greenText);
        blueText = findViewById(R.id.blueText);

        redBar.setProgress(red);
        greenBar.setProgress(green);
        blueBar.setProgress(blue);

        redText.setText(String.valueOf(red));
        greenText.setText(String.valueOf(green));
        blueText.setText(String.valueOf(blue));

        whiteButton = findViewById(R.id.whiteButton);
        blackButton = findViewById(R.id.blackButton);
        blueButton = findViewById(R.id.blueButton);
        resetButton = findViewById(R.id.resetButton);

        colorView = findViewById(R.id.colorView);

        colorView.setBackgroundColor(Color.rgb(red, green, blue));





        Log.d(TAG, "onCreate: " + redBar.isIndeterminate());

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                redText.setText(String.valueOf(red));
                colorView.setBackgroundColor(Color.rgb(red, green, blue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                greenText.setText(String.valueOf(green));
                colorView.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                blueText.setText(String.valueOf(blue));
                colorView.setBackgroundColor(Color.rgb(red, green, blue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        whiteButton.setOnClickListener(v -> {
            red = 255;
            green = 255;
            blue = 255;
            redBar.setProgress(red);
            greenBar.setProgress(green);
            blueBar.setProgress(blue);
            colorView.setBackgroundColor(Color.rgb(red, green, blue));
        });

        blackButton.setOnClickListener(v -> {
            red = 0;
            green = 0;
            blue = 0;
            redBar.setProgress(red);
            greenBar.setProgress(green);
            blueBar.setProgress(blue);
            colorView.setBackgroundColor(Color.rgb(red, green, blue));
        });

        blueButton.setOnClickListener(v -> {
            red = 0;
            green = 0;
            blue = 255;
            redBar.setProgress(red);
            greenBar.setProgress(green);
            blueBar.setProgress(blue);
            colorView.setBackgroundColor(Color.rgb(red, green, blue));
        });

        resetButton.setOnClickListener(v -> {
            red = 64;
            green = 128;
            blue = 0;
            redBar.setProgress(red);
            greenBar.setProgress(green);
            blueBar.setProgress(blue);
            colorView.setBackgroundColor(Color.rgb(red, green, blue));
        });


    }

}