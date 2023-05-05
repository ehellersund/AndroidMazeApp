package edu.wm.cs.cs301.gui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PlayManuallyActivity extends AppCompatActivity {
    MazePanel mazePanel;

    int moves = 0;
    int jumps = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual);

        //mazePanel = (MazePanel) findViewById(R.id.mazePanel);



    }

}
