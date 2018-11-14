package io.github.gsundin.spititout;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> deck = new ArrayList<>();
    private int currentDeckIndex;
    private Button cardButton;
    private Button timerButton;
    private Button menuButton;
    private CountDownTimer countDown;
    private boolean countDownRunning = false;

    private static int numberOfDecks = 4;
    public static String[][] deckPaths = new String[2][numberOfDecks];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer backNoise = MediaPlayer.create(this, R.raw.button_de_da);
        final MediaPlayer startTimerNoise = MediaPlayer.create(this, R.raw.blop);

        cardButton = findViewById(R.id.cardButton);
        timerButton = findViewById(R.id.timerButton);
        menuButton = findViewById(R.id.menuButton);

        //Initialize deck of cards
        buildDeckRandomly();
        nextCard();

        //Step through deck by tapping cards
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownRunning)
                    countDown.cancel();
                timerButton.setText("5");
                nextCard();
            }
        });

        //Go back to the main menuButton (destroys deck)
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //backNoise.start();
                finish();
            }
        });

        //Start timerButton when button tapped
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDown != null)
                    countDown.cancel();
                startTimerNoise.start();
                startTimer();
            }
        });
    }

    /**
     * Set the cardButton text to the current cardButton in the deck.
     */
    public void nextCard() {
        if (currentDeckIndex >= (deck.size() - 1))
            currentDeckIndex = 0;

        String cardText = deck.get(currentDeckIndex);
        cardButton.setText(cardText);
        currentDeckIndex++;
    }

    /**
     * Build deck in random order from all items currently in deck. This will give a random cardButton
     * order without repeating any cards.
     */
    private void buildDeckRandomly() {

        //Make sure deck is (empty+1) before filling
        deck.clear();
        deck.add("Things You're Always Forgetting");

        //First column of array is paths; second column is include/exclude
        deckPaths[0][0] = "normalDeck.txt";
        deckPaths[0][1] = "nsfwDeck.txt";
        deckPaths[0][2] = "peopleDeck.txt";
        deckPaths[0][3] = "customDeck.txt";

        for (int deckId = 0; deckId < numberOfDecks; deckId++){
            if (deckPaths[1][deckId] != null && deckPaths[1][deckId].equals("1")) {
                try {
                    InputStream ins = getAssets().open(deckPaths[0][deckId]);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        deck.add(line);
                    }
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("styptik", "Uh oh, caught an IO Exception error!");
                }
            }
        }
        //Randomize the cardButton order
        Collections.shuffle(deck);
        //Set initial index to start
        currentDeckIndex = 0;
    }

    private void startTimer() {
        timerButton.setText("5");
        countDownRunning = true;
        countDown = new CountDownTimer(6500, 250) {

            public void onTick(long millisUntilFinished) {
                timerButton.setText(Long.toString((millisUntilFinished - 1000) / 1000));
            }

            public void onFinish() {
                timerButton.setText("5");
            }
        }.start();
    }
}
