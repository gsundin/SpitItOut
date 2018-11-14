package io.github.gsundin.spititout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Options extends AppCompatActivity {

    public boolean soundsEnabled;
    public boolean musicEnabled;

    private Switch soundsSwitch;
    private Switch musicSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        soundsSwitch = findViewById(R.id.soundsSwitch);
        musicSwitch = findViewById(R.id.musicSwitch);

        soundsSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundsSwitch.isChecked())
                    soundsEnabled = true;
                else
                    soundsEnabled = false;
            }
        });

        musicSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicSwitch.isChecked())
                    musicEnabled = true;
                else
                    musicEnabled = false;
            }
        });
    }
}
