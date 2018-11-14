package io.github.gsundin.spititout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartMenu extends AppCompatActivity {

    private Button startButton;
    private Button optionsButton;
    private Button editDeckButton;
    private Button addCardsButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);

        startButton = findViewById(R.id.startGameButton);
        optionsButton = findViewById(R.id.optionsButton);
        editDeckButton = findViewById(R.id.editDeckButton);
        addCardsButton = findViewById(R.id.addCardsButton);
        exitButton = findViewById(R.id.quitButton);

        if (MainActivity.deckPaths[1][0] == null)
            MainActivity.deckPaths[1][0] = "1";
        if (MainActivity.deckPaths[1][1] == null)
            MainActivity.deckPaths[1][1] = "0";
        if (MainActivity.deckPaths[1][2] == null)
            MainActivity.deckPaths[1][2] = "0";
        if (MainActivity.deckPaths[1][3] == null)
            MainActivity.deckPaths[1][3] = "0";

        //Start game
        final Intent startIntent = new Intent(this, MainActivity.class);
        final Intent optionsIntent = new Intent(this, Options.class);
        final Intent editDeckIntent = new Intent(this, EditDeck.class);
        final Intent addCardsIntent = new Intent(this, AddCards.class);
        final MediaPlayer buttonNoise = MediaPlayer.create(this, R.raw.beep_peep_little);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonNoise.start();
                startActivity(startIntent);
            }
        });

        //Go to settings
        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonNoise.start();
                startActivity(optionsIntent);
            }
        });

        //Edit the deck of cards
        editDeckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonNoise.start();
                startActivity(editDeckIntent);
            }
        });

        //Add custom cards to the deck
        addCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonNoise.start();
                startActivity(addCardsIntent);
            }
        });

        //Quit out of the app
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buttonNoise.start();
                System.exit(0);
            }
        });
    }
}
