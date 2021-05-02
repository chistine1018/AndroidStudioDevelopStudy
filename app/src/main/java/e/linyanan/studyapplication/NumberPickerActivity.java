package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class NumberPickerActivity extends AppCompatActivity {
    private String msSex = "";
    private Button mBtnOK;
    private TextView mTvResult, mTvAge;
    private Spinner mSexSpinner;
    private NumberPicker mAgeNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        initView();
        mBtnOK.setOnClickListener(onClickListener);
        mSexSpinner.setOnItemSelectedListener(onItemSelectedListener);
        mAgeNumberPicker.setOnValueChangedListener(onValueChangeListener);
        mAgeNumberPicker.setMinValue(0);
        mAgeNumberPicker.setMaxValue(90);
        mAgeNumberPicker.setValue(25);
        mSexSpinner.setSelection(1);
    }

    void initView() {
        mBtnOK = findViewById(R.id.number_picker_activity_btn_OK);
        mTvResult = findViewById(R.id.number_picker_activity_tv_result);
        mTvAge = findViewById(R.id.number_picker_activity_tv_pick_age);
        mSexSpinner = findViewById(R.id.number_picker_acitivty_sex_spinner);
        mAgeNumberPicker = findViewById(R.id.number_picker_activity_numberPicker);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int iAge = mAgeNumberPicker.getValue();
            String strSug = getString(R.string.suggestion);
            if (msSex.equals(getString(R.string.sex_male)))
                if (iAge < 28)
                    strSug += getString(R.string.suggestion_not_hurry);
                else if (iAge > 33)
                    strSug += getString(R.string.suggestion_married);
                else
                    strSug += getString(R.string.suggestion_begin_find_couple);
            else if (iAge < 25)
                strSug += getString(R.string.suggestion_not_hurry);
            else if (iAge > 30)
                strSug += getString(R.string.suggestion_married);
            else
                strSug += getString(R.string.suggestion_begin_find_couple);
            mTvResult.setText(strSug);
        }
    };


    private AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            msSex = adapterView.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
            mTvAge.setText(String.valueOf(newValue));
        }
    };
}