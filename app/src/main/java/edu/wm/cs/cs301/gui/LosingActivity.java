package edu.wm.cs.cs301.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LosingActivity extends AppCompatActivity implements View.OnClickListener {
    TextView distance;
    TextView battery;
    TextView batteryText;
    Button backButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.losing);

        distance = (TextView) findViewById(R.id.distance);
        battery = (TextView) findViewById(R.id.battery);
        batteryText = (TextView) findViewById(R.id.batConsum);
        backButton = (Button) findViewById(R.id.button);

        distance.setText(String.valueOf(MazeObject.getDistance()) + " spaces");

        if (MazeObject.getDriver() != null && !MazeObject.getDriver().equals("Manual")) {
            //battery.setText(String.valueOf(MazeObject.getBattery()));
            battery.setVisibility(View.VISIBLE);
            batteryText.setVisibility(View.VISIBLE);
        }

        backButton.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button:
                Intent back = new Intent(this, AMazeActivity.class);
                startActivity(back);
        }
    }
}
