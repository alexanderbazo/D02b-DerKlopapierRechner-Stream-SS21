package de.ur.mi.android.demos.derklopapier_rechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private TextView currentRollCount;
    private TextView currentNumberOfPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        currentRollCount = findViewById(R.id.roll_input_textview);
        currentNumberOfPeople = findViewById(R.id.person_input_textview);
        Button startResultActivityButton = findViewById(R.id.calculate_stats_button);
        startResultActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResultButtonClicked();
            }
        });
        initSeekBar(R.id.roll_input_seekbar, 0, 50, 5, this);
        initSeekBar(R.id.person_input_seekbar, 1, 10, 3, this);
    }

    private SeekBar initSeekBar(int id, int min, int max, int value, SeekBar.OnSeekBarChangeListener listener) {
        SeekBar seekBar = findViewById(id);
        seekBar.setOnSeekBarChangeListener(listener);
        seekBar.setMin(min);
        seekBar.setMax(max);
        seekBar.setProgress(value);
        return seekBar;
    }

    private void onRollCountChanged(int value) {
        currentRollCount.setText(String.valueOf(value));
    }

    private void onPeopleCountChanged(int value) {
        currentNumberOfPeople.setText(String.valueOf(value));
    }

    /**
     * Get current values from TextViews and start Intent to next Activity
     */
    private void onResultButtonClicked() {
        int numberOfRolls = Integer.parseInt(currentRollCount.getText().toString());
        int numberOfPeople = Integer.parseInt(currentNumberOfPeople.getText().toString());

        // @TODO Put values in Intent
        // @TODO Start next activity
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.roll_input_seekbar:
                onRollCountChanged(progress);
                break;
            case R.id.person_input_seekbar:
                onPeopleCountChanged(progress);
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}