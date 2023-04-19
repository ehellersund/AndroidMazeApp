package edu.wm.cs.cs301.gui;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class GeneratingActivity extends AppCompatActivity implements Runnable {

    RadioGroup driver;
    RadioButton driverButton;
    boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating);

        driver = findViewById(R.id.driverGroup);

    }

    @Override
    protected void onStart() {
        super.onStart();

        progressBar();

        switchToPlaying();
    }

    //Begins running the thread for the progressbar to run
    private void progressBar() {
        Thread barThread = new Thread(this);
        barThread.start();
    }

    //Switches to manual or animation activity
    private void switchToPlaying() {

    }

    //Separated the progress bar into a thread so it doesn't slow everything else down
    @Override
    public void run() {
        ProgressBar bar = findViewById(R.id.progressBar);
        int barProgress = 0;

        while (barProgress <= 100) {
            bar.setProgress(barProgress);
            barProgress += 1;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        loaded = true;
    }
}
