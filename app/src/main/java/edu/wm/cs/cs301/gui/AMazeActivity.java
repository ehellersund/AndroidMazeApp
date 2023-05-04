package edu.wm.cs.cs301.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class AMazeActivity extends AppCompatActivity {
    public static final String DIFFICULTY = "edu.wm.cs.cs301.DIFFICULTY";
    public static final String MAZE = "edu.wm.cs.cs301.MAZE"; //pre conversion to Order.Builder
    public static final String ROOMS = "edu.wm.cs.cs301.ROOMS";
    private Button explore;
    private Button revisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.mazeSelector);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mazes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        explore = (Button) findViewById(R.id.explore);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToGenerating();
            }
        });
    }

        public void switchToGenerating() {
            EditText difficultySetting = (EditText) findViewById(R.id.editTextNumber);
            int difficulty = Integer.parseInt(difficultySetting.getText().toString());

            Spinner mazeType = (Spinner) findViewById(R.id.mazeSelector);
            String maze = mazeType.getItemAtPosition(mazeType.getSelectedItemPosition()).toString();

            ToggleButton rooms = (ToggleButton) findViewById(R.id.includeRooms);
            Boolean hasRooms = rooms.isChecked();

            Intent intent = new Intent(this, GeneratingActivity.class);
            intent.putExtra(DIFFICULTY, difficulty);
            intent.putExtra(MAZE, maze);
            intent.putExtra(ROOMS, hasRooms);
            startActivity(intent);
        }

        public void win() {
            Intent win = new Intent(this, WinningActivity.class);
            startActivity(win);
        }

}
