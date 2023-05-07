package edu.wm.cs.cs301.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.wm.cs.cs301.generation.Maze;

public class PlayManuallyActivity extends AppCompatActivity implements View.OnClickListener{
    MazePanel mazePanel;
    Maze maze = MazeObject.getMaze();

    Button forward;
    Button left;
    Button right;

    Button jump;
    ToggleButton showMap;
    ToggleButton showWalls;
    ToggleButton showSolution;
    SeekBar mapScale;


    int moves = 0;
    int jumps = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);

        mazePanel = (MazePanel) findViewById(R.id.mazePanel);

        forward = (Button) findViewById(R.id.FORWARD);
        left = (Button) findViewById(R.id.LEFT);
        right = (Button) findViewById(R.id.RIGHT);
        jump = (Button) findViewById(R.id.JUMP);

        showMap = (ToggleButton) findViewById(R.id.mapshow);
        showWalls = (ToggleButton) findViewById(R.id.wallshow);
        showSolution = (ToggleButton) findViewById(R.id.solutionshow);
        mapScale = (SeekBar) findViewById(R.id.seekBar);

        forward.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        jump.setOnClickListener(this);

        showMap.setOnClickListener(this);
        showWalls.setOnClickListener(this);
        showSolution.setOnClickListener(this);
        mapScale.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.FORWARD:
                moves += 1;
                System.out.println("forward");
                break;
            case R.id.LEFT:
                System.out.println("left");
                break;
            case R.id.RIGHT:
                System.out.println("right");
                break;
            case R.id.JUMP:
                jumps += 1;
                System.out.println("jump");
                break;
            case R.id.mapshow:
                System.out.println("show map");
                break;
            case R.id.wallshow:
                System.out.println("show walls");
                break;
            case R.id.solutionshow:
                System.out.println("show solution");
                break;
            case R.id.seekBar:
                System.out.println("map scale");
                break;
            default:
                System.out.println("Default case triggered on ID: " + view.getId()) ;
                break;
        }
    }

}
