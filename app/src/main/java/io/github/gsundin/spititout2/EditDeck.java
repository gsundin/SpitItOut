package io.github.gsundin.spititout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class EditDeck extends AppCompatActivity {

    private Switch normalDeckSwitch;
    private Switch nsfwDeckSwitch;
    private Switch peopleDeckSwitch;
    private Switch customDeckSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_deck);

        normalDeckSwitch = findViewById(R.id.normalDeckSwitch);
        nsfwDeckSwitch = findViewById(R.id.nsfwDeckSwitch);
        peopleDeckSwitch = findViewById(R.id.peopleDeckSwitch);
        customDeckSwitch = findViewById(R.id.customDeckSwitch);

        initializeDeckSettings();

        normalDeckSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (normalDeckSwitch.isChecked() == true)
                MainActivity.deckPaths[1][0] = "1";
            else
                MainActivity.deckPaths[1][0] = "0";
            }
        });

        nsfwDeckSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nsfwDeckSwitch.isChecked() == true)
                    MainActivity.deckPaths[1][1] = "1";
                else
                    MainActivity.deckPaths[1][1] = "0";
            }
        });

        peopleDeckSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (peopleDeckSwitch.isChecked() == true)
                    MainActivity.deckPaths[1][2] = "1";
                else
                    MainActivity.deckPaths[1][2] = "0";
            }
        });

        customDeckSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customDeckSwitch.isChecked() == true)
                    MainActivity.deckPaths[1][3] = "1";
                else
                    MainActivity.deckPaths[1][3] = "0";
            }
        });
    }

    private void initializeDeckSettings() {
        if (MainActivity.deckPaths[1][0] == "1")
            normalDeckSwitch.setChecked(true);
        else
            normalDeckSwitch.setChecked(false);

        if (MainActivity.deckPaths[1][1] == "1")
            nsfwDeckSwitch.setChecked(true);
        else
            nsfwDeckSwitch.setChecked(false);

        if (MainActivity.deckPaths[1][2] == "1")
            peopleDeckSwitch.setChecked(true);
        else
            peopleDeckSwitch.setChecked(false);

        if (MainActivity.deckPaths[1][3] == "1")
            customDeckSwitch.setChecked(true);
        else
            customDeckSwitch.setChecked(false);
    }
}
