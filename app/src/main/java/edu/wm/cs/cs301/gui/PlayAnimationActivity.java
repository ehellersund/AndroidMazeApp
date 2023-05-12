package edu.wm.cs.cs301.gui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.wm.cs.cs301.generation.Maze;

public class PlayAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    MazePanel mazePanel;
    Maze maze = MazeObject.getMaze();

    int moves = 0;
    int jumps = 0;

    ToggleButton showMap;
    ToggleButton showWalls;
    ToggleButton showSolution;
    SeekBar mapScale;
    StatePlaying game;

    private static Context winContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);

        mazePanel = (MazePanel) findViewById(R.id.animmazePanel);
        showMap = (ToggleButton) findViewById(R.id.animmapshow);
        showWalls = (ToggleButton) findViewById(R.id.animwallshow);
        showSolution = (ToggleButton) findViewById(R.id.animsolutionshow);
        mapScale = (SeekBar) findViewById(R.id.animseekBar);

        showMap.setOnClickListener(this);
        showWalls.setOnClickListener(this);
        showSolution.setOnClickListener(this);
        mapScale.setOnClickListener(this);

        winContext = this;

        game = new StatePlaying();
        game.setMaze(MazeObject.getMaze());

        //Setting driver
        switch(MazeObject.getDriver()) {
            case "Wizard":
                game.setDriver(RobotDriver.Driver.Wizard);
                break;
            case "WallFollower":
                game.setDriver(RobotDriver.Driver.WallFollower);
                break;
            case "Manual":
            default:
                //Invalid driver somehow TODO: add log
                game.setDriver(RobotDriver.Driver.Wizard);
                break;
        }

        switch(MazeObject.getQuality()) {
            case "Premium":
                game.setSensorConf("1111");
                break;
            case "Mediocre":
                game.setSensorConf("1001");
                break;
            case "So-so":
                game.setSensorConf("0110");
                break;
            case "Shaky":
                game.setSensorConf("0000");
                break;
            default:
                //Invalid driver somehow TODO: add log
                game.setSensorConf("1111");
                break;
        }

        game.start(mazePanel);
        game.robotGo();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.mapshow:
                game.handleUserInput(Constants.UserInput.TOGGLEFULLMAP, 0);
                break;
            case R.id.wallshow:
                game.handleUserInput(Constants.UserInput.TOGGLELOCALMAP, 0);
                break;
            case R.id.solutionshow:
                game.handleUserInput(Constants.UserInput.TOGGLESOLUTION, 0);
                break;
            case R.id.seekBar:
                System.out.println("map scale (bad imp)");
                break;
            //TODO: seekbar
            default:
                System.out.println("Default case triggered on ID: " + view.getId()) ;
                break;
        }
    }
    public static void win() {
        Intent win = new Intent(winContext, WinningActivity.class);
        winContext.startActivity(win);
    }
}