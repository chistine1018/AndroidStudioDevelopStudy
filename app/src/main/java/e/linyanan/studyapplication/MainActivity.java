package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText mEditSex;
    public EditText mEditAge;
    public TextView mTvResult;
    public Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtnOK.setOnClickListener(OKListener);

    }

    private View.OnClickListener OKListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strSex = mEditSex.getText().toString();
            int iAge = Integer.parseInt(mEditAge.getText().toString());
            String strSug = getString(R.string.suggestion);
            if (strSex.equals(getString(R.string.sex_male)))
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

    public void initView() {
        mEditSex = findViewById(R.id.editSex);
        mEditAge = findViewById(R.id.editAge);
        mTvResult = findViewById(R.id.tvResult);
        mBtnOK = findViewById(R.id.btn_OK);
    }
}
