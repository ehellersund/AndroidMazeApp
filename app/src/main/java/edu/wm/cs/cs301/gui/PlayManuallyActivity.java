package edu.wm.cs.cs301.gui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.wm.cs.cs301.generation.Maze;

public class PlayManuallyActivity extends AppCompatActivity {
    MazePanel mazePanel;
    Maze maze = MazeObject.getMaze();

    int moves = 0;
    int jumps = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);

        //mazePanel = (MazePanel) findViewById(R.id.mazePanel);



    }

}
