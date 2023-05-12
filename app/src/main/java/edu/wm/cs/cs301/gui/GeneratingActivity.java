package edu.wm.cs.cs301.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.wm.cs.cs301.generation.Maze;
import edu.wm.cs.cs301.generation.MazeFactory;
import edu.wm.cs.cs301.generation.Order;
import edu.wm.cs.cs301.generation.SingleRandom;

public class GeneratingActivity extends AppCompatActivity implements Order { //Runnable
    int difficulty;
    String maze;            //builder pre-conversion from previous activity
    Order.Builder builder;  //builder post-conversion from previous activity
    boolean hasRooms;
    int seed;

    RadioGroup driver;
    RadioGroup robot;
    RadioButton driverButton;
    RadioButton robotButton;
    boolean loaded = false; //Signifies maze is loaded
    boolean selectedDriver = false; //Signifies user has selected a driver
    boolean selectedRobot = false; //Signifies user has selected a robot

    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating);

        Intent intent = getIntent();
        difficulty = intent.getIntExtra(AMazeActivity.DIFFICULTY, 0);     //aka level
        maze = intent.getStringExtra(AMazeActivity.MAZE);                           //aka builder pre-conversion
        hasRooms = intent.getBooleanExtra(AMazeActivity.ROOMS, true);    //aka perfect

        driver = findViewById(R.id.driverGroup);
        robot = findViewById(R.id.robotGroup);

        bar = findViewById(R.id.progressBar); //progress bar

        seed = SingleRandom.getRandom().nextIntWithinInterval(0, 1000000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //progressBar();
        System.out.println(difficulty);
        System.out.println(maze);
        System.out.println(hasRooms);

        generate(maze);
        System.out.println(seed);
    }

    private void generate(String preOrder) {
        switch(preOrder) {
        case "DFS":
            builder = Builder.DFS;
            break;
        case "PRIM":
            builder = Builder.Prim;
            break;
        case "BORUVKA":
        default:
            builder = Builder.DFS;
            break;
        }
        MazeFactory fac = new MazeFactory();
        fac.order(this);
    }

    //Selection of driver
    public void checkButton(View v) {
        int id = driver.getCheckedRadioButtonId();
        driverButton = findViewById(id);

        Toast.makeText(this, "Selected " + driverButton.getText(), Toast.LENGTH_SHORT).show();
        MazeObject.setDriver((String) driverButton.getText());
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
        MazeObject.setQuality((String) robotButton.getText());
        selectedRobot = true;

        if (loaded == true) {
            switchToPlaying();
        }
    }

    /*
    //Begins running the thread for the progressbar to run
    private void progressBar() {
        Thread barThread = new Thread(this);
        barThread.start();
    }
     */

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

    /*
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
     */

    @Override
    public int getSkillLevel() {
        return difficulty;
    }

    @Override
    public Builder getBuilder() {
        return builder;
    }

    @Override
    public boolean isPerfect() {
        return hasRooms;
    }

    @Override
    public int getSeed() {
        return seed;
    }

    @Override
    public void deliver(Maze mazeConfig) {
        MazeObject.setMaze(mazeConfig);
        //System.out.println("Delivered maze");
    }

    @Override
    public void updateProgress(int percentage) {
        bar.setProgress(percentage);
        if (percentage>=100) {
            loaded = true;
            switchToPlaying();
        }
    }
}
