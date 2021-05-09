package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import e.linyanan.studyapplication.Fragment.FragmentActivity;
import e.linyanan.studyapplication.FragmentManager.FragmentManagerActivity;

public class NormalActivity extends AppCompatActivity {
    private EditText mEditSex;
    private EditText mEditAge;
    private TextView mTvResult;
    private Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(NormalActivity.this, ListActivity.class);
        startActivity(intent);
        initView();
        mBtnOK.setOnClickListener(OKListener);
    }

    private View.OnClickListener OKListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strSex = mEditSex.getText().toString();
            int iAge = Integer.parseInt(mEditAge.getText().toString());
//            String strSug = getString(R.string.suggestion);
            String strSug = "";
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
        mEditAge = findViewById(R.id.spinner_activity_editAge);
        mTvResult = findViewById(R.id.tvResult);
        mBtnOK = findViewById(R.id.btn_OK);
    }
}
