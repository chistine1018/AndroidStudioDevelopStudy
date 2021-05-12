package e.linyanan.studyapplication.DateandTimePicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import e.linyanan.studyapplication.R;

public class DateAndTimePickerActivity extends AppCompatActivity {
    Button mBtnDatePicker, mBtnTimePicker;
    TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time_picker);
        mBtnDatePicker = findViewById(R.id.btn_date_picker);
        mBtnTimePicker = findViewById(R.id.btn_time_picker);
        mTvResult = findViewById(R.id.txt_result);
        mBtnTimePicker.setOnClickListener(onClickListener);
        mBtnDatePicker.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_date_picker) {
                mTvResult.setText("");
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(DateAndTimePickerActivity.this, dateSetListener, calendar.get(Calendar.YEAR)
                        , calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.setTitle("選擇日期");
                datePickerDialog.setMessage("請選擇適合您的日期");
                datePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
                datePickerDialog.setCancelable(false);

                datePickerDialog.show();
            } else if (view.getId() == R.id.btn_time_picker) {
                mTvResult.setText("");
                Calendar calendar = Calendar.getInstance();

                TimePickerDialog timePickerDialog = new TimePickerDialog(DateAndTimePickerActivity.this, onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                timePickerDialog.setTitle("選擇時間");
                timePickerDialog.setMessage("請選擇時間");
                timePickerDialog.setIcon(android.R.drawable.ic_dialog_info);

                timePickerDialog.show();
            }
        }
    };

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            mTvResult.setText("您選擇的日期是" + Integer.toString(i) + "年" + Integer.toString(i1 + 1) + "月" + Integer.toString(i2) + "日");
        }
    };

    private TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            mTvResult.setText("您選擇的時間是" + Integer.toString(i) + "時" + Integer.toString(i1) + "分");

        }
    };
}