package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    private String msSex;
    private EditText mEditAge;
    private TextView mTvResult;
    private Button mBtnOK;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        initView();
        mSpinner.setOnItemSelectedListener(onItemSelectedListener);
        mBtnOK.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int iAge = Integer.parseInt(mEditAge.getText().toString());
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
            try {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
            } catch (Exception e) {
                Toast.makeText(SpinnerActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
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

    public void initView() {
        mEditAge = findViewById(R.id.spinner_activity_editAge);
        mTvResult = findViewById(R.id.spinner_activity_tv_result);
        mBtnOK = findViewById(R.id.spinner_activity_btn_OK);
        mSpinner = findViewById(R.id.sex_spinner);
    }

}