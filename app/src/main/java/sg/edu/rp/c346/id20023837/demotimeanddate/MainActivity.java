package sg.edu.rp.c346.id20023837.demotimeanddate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.TextView);
        dp = findViewById(R.id.DatePicker);
        tp = findViewById(R.id.TimePicker);
        btnDisplayDate = findViewById(R.id.Button);
        btnDisplayTime = findViewById(R.id.Button2);
        btnReset = findViewById(R.id.resetBtn);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Time is ";
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                if (minute < 10) {
                    msg = msg + hour + ":0" + minute;

                }
                else {
                    msg = msg + hour + ":" + minute;
                }

                tvDisplay.setText(msg);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Date is ";
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                msg = msg + day + "/" + month + "/" + year;
                tvDisplay.setText(msg);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,0,1);
            }
        });

    }
}