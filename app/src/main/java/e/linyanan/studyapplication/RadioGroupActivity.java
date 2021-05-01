package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioGroupActivity extends AppCompatActivity {
    private TextView mTvResult;
    private Button mBtnOK;
    private RadioGroup mRadioGroupSex, mRadioGroupAge;
    private RadioButton mRadioBtnMale, mRadioBtnFemale, mRadioBtnAgeRange1, mRadioBtnAgeRange2, mRadioBtnAgeRange3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        initView();
        mRadioGroupAge.setOnCheckedChangeListener(onCheckedChangeListener);
        mBtnOK.setOnClickListener(onClickListener);
    }

    public void initView() {
        mBtnOK = findViewById(R.id.btn_OK);
        mTvResult = findViewById(R.id.tvResult);
        mRadioGroupSex = findViewById(R.id.radGroupSex);
        mRadioGroupAge = findViewById(R.id.radGroupAge);
        mRadioBtnAgeRange1 = findViewById(R.id.radBtnRange1);
        mRadioBtnAgeRange2 = findViewById(R.id.radBtnRange2);
        mRadioBtnAgeRange3 = findViewById(R.id.radBtnRange3);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strResult = "Suggest : ";
            switch (mRadioGroupAge.getCheckedRadioButtonId()) {
                case R.id.radBtnRange1:
                    strResult += getString(R.string.suggestion_not_hurry);
                    break;
                case R.id.radBtnRange2:
                    strResult += getString(R.string.suggestion_begin_find_couple);
                    break;
                case R.id.radBtnRange3:
                    strResult += getString(R.string.suggestion_married);
                    break;
            }
            mTvResult.setText(strResult);

        }
    };
    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.radBtnMale) {
                mRadioBtnAgeRange1.setText(R.string.male_age_range1);
                mRadioBtnAgeRange2.setText(R.string.male_age_range2);
                mRadioBtnAgeRange3.setText(R.string.male_age_range3);
            } else {
                mRadioBtnAgeRange1.setText(R.string.female_age_range1);
                mRadioBtnAgeRange2.setText(R.string.female_age_range2);
                mRadioBtnAgeRange3.setText(R.string.female_age_range3);
            }

        }
    };
}