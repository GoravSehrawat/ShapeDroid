package com.example.bsw123.shapedroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Rectangle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;

/**
 * Skeleton of an Android Things activity.
 * <p>
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 * <p>
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 * <p>
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 * @see <a href="https://github.com/androidthings/contrib-drivers#readme">https://github.com/androidthings/contrib-drivers#readme</a>
 */
public class MainActivity extends Activity {
    private FrameLayout frame;
    private Button showButton;
    private SeekBar slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = (FrameLayout) findViewById(R.id.parent_of_shape);
        final MakeShape ref=new MakeShape(this);
        frame.addView(ref);
        slider=(SeekBar)findViewById(R.id.setHeight);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                 ref.setDimensions(300,440);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub


            }
        });
            showButton = (Button) findViewById(R.id.button);
        showButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("Coordinates Are:");
                alert.setMessage(ref.print());
                alert.setButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                    }
                });
                alert.show();
            }
        });

//        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.parent_of_shape).addView(new MakeShape(this));
        //setContentView(new MakeShape(this));
    }
}