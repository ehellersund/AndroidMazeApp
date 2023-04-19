package edu.wm.cs.cs301.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GeneratingActivity extends AppCompatActivity implements Runnable {

    RadioGroup driver;
    RadioGroup robot;
    RadioButton driverButton;
    RadioButton robotButton;
    boolean loaded = false; //Signifies maze is loaded
    boolean selectedDriver = false; //Signifies user has selected a driver
    boolean selectedRobot = false; //Signifies user has selected a robot

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating);

        driver = findViewById(R.id.driverGroup);
        robot = findViewById(R.id.robotGroup);

    }

    @Override
    protected void onStart() {
        super.onStart();

        progressBar();
    }

    //Selection of driver
    public void checkButton(View v) {
        int id = driver.getCheckedRadioButtonId();
        driverButton = findViewById(id);

        Toast.makeText(this, "Selected " + driverButton.getText(), Toast.LENGTH_SHORT).show();
        selectedDriver = true;

        if (loaded == true) {
            switchToPlaying();
        }
    }

    //Selection of robot quality
    public void checkButton2(View v) {
        int id2 = robot.getCheckedRadioButtonId();
        robotButton = findViewById(id2);

        Toast.makeText(this, "Selected " + robotButton.getText() + " quality", Toast.LENGTH_SHORT).show();
        selectedRobot = true;

        if (loaded == true) {
            switchToPlaying();
        }
    }

    //Begins running the thread for the progressbar to run
    private void progressBar() {
        Thread barThread = new Thread(this);
        barThread.start();
    }

    //Switches to manual or animation activity
    private void switchToPlaying() {
        if (selectedDriver == true && loaded == true) {
            if (driverButton.getText().equals("Manual")) {
                System.out.println("Manual selected");
                Intent man = new Intent(this, PlayManuallyActivity.class);
                startActivity(man);
            }
            else if (selectedRobot == false) {
                System.out.println("Robot driver selected but no robot quality selected");
                //"You must select a robot quality!"
            }
            else {
                System.out.println("Robot driver selected");
                Intent anim = new Intent(this, PlayAnimationActivity.class);
                startActivity(anim);
            }
        }
        else {
            System.out.println("Maze loaded but still waiting on user selection");
        }
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
        switchToPlaying();
    }
}
