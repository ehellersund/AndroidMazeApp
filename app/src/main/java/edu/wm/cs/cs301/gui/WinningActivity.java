package edu.wm.cs.cs301.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinningActivity extends AppCompatActivity {
    TextView distance;
    TextView battery;
    TextView batteryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winning);

        distance = (TextView) findViewById(R.id.distance);
        battery = (TextView) findViewById(R.id.battery);
        batteryText = (TextView) findViewById(R.id.batConsum);

        distance.setText(String.valueOf(MazeObject.getDistance()) + " spaces");
        if (MazeObject.getDriver() != null && !MazeObject.getDriver().equals("Manual")) {
            battery.setText(String.valueOf(MazeObject.getBattery()));
            battery.setVisibility(View.VISIBLE);
            batteryText.setVisibility(View.VISIBLE);
        }
    }

}
