package edu.wm.cs.cs301.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.wm.cs.cs301.generation.Maze;

public class PlayManuallyActivity extends AppCompatActivity implements View.OnClickListener{
    MazePanel mazePanel;
    Maze maze = MazeObject.getMaze();

    Button forward;
    Button backward;
    Button left;
    Button right;

    Button jump;
    ToggleButton showMap;
    ToggleButton showWalls;
    ToggleButton showSolution;
    SeekBar mapScale;


    int moves = 0;
    int jumps = 0;

    StatePlaying game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);

        mazePanel = (MazePanel) findViewById(R.id.mazePanel);

        forward = (Button) findViewById(R.id.FORWARD);
        backward = (Button) findViewById(R.id.BACKWARD);
        left = (Button) findViewById(R.id.LEFT);
        right = (Button) findViewById(R.id.RIGHT);
        jump = (Button) findViewById(R.id.JUMP);

        showMap = (ToggleButton) findViewById(R.id.mapshow);
        showWalls = (ToggleButton) findViewById(R.id.wallshow);
        showSolution = (ToggleButton) findViewById(R.id.solutionshow);
        mapScale = (SeekBar) findViewById(R.id.seekBar);

        forward.setOnClickListener(this);
        backward.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        jump.setOnClickListener(this);

        showMap.setOnClickListener(this);
        showWalls.setOnClickListener(this);
        showSolution.setOnClickListener(this);
        mapScale.setOnClickListener(this);

        game = new StatePlaying();
        game.setMaze(MazeObject.getMaze());
        game.start(mazePanel);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.FORWARD:
                moves += 1;
                game.handleUserInput(Constants.UserInput.UP, 0);
                if (game.isOutside(game.px, game.py)) {
                    Intent win = new Intent(this, WinningActivity.class);
                    startActivity(win);
                }
                break;
            case R.id.BACKWARD:
                moves += 1;
                game.handleUserInput(Constants.UserInput.DOWN, 0);
                if (game.isOutside(game.px, game.py)) {
                    Intent win = new Intent(this, WinningActivity.class);
                    startActivity(win);
                }
                break;
            case R.id.LEFT:
                game.handleUserInput(Constants.UserInput.LEFT, 0);
                break;
            case R.id.RIGHT:
                game.handleUserInput(Constants.UserInput.RIGHT, 0);
                break;
            case R.id.JUMP:
                jumps += 1;
                game.handleUserInput(Constants.UserInput.JUMP, 0);
                if (game.isOutside(game.px, game.py)) {
                    Intent win = new Intent(this, WinningActivity.class);
                    startActivity(win);
                }
                break;
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

}
