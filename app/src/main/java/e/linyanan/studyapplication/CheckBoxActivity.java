package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mChkBoxMusic, mChkBoxSing, mChkBoxDance, mChkBoxTravel, mChkBoxReading, mChkBoxWriting,
            mChkBoxClimbing, mChkBoxSwim, mChkBoxExercise, mChkBoxFitness, mChkBoxPhoto, mChkBoxEating,
            mChkBoxPainting, mChkBoxChat, mChkBoxPlayComputer;
    private Button mBtnOK;
    private TextView mTvSelectResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        initView();
        mBtnOK.setOnClickListener(onClickListener);
    }

    private void initView() {
        mChkBoxMusic = findViewById(R.id.chkBoxMusic);
        mChkBoxSing = findViewById(R.id.chkBoxSing);
        mChkBoxDance = findViewById(R.id.chkBoxDance);
        mChkBoxTravel = findViewById(R.id.chkBoxTravel);
        mChkBoxReading = findViewById(R.id.chkBoxReading);
        mChkBoxWriting = findViewById(R.id.chkBoxWriting);
        mChkBoxClimbing = findViewById(R.id.chkBoxClimbing);
        mChkBoxSwim = findViewById(R.id.chkBoxSwim);
        mChkBoxExercise = findViewById(R.id.chkBoxExercise);
        mChkBoxFitness = findViewById(R.id.chkBoxFitness);
        mChkBoxPhoto = findViewById(R.id.chkBoxPhoto);
        mChkBoxEating = findViewById(R.id.chkBoxEating);
        mChkBoxPainting = findViewById(R.id.chkBoxPainting);
        mChkBoxChat = findViewById(R.id.chkBoxChat);
        mChkBoxPlayComputer = findViewById(R.id.chkBoxPlayComputer);
        mTvSelectResult = findViewById(R.id.tv_select_result);
        mBtnOK = findViewById(R.id.btn_OK);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String s = getString(R.string.your_hobby) + "\n";
            if (mChkBoxMusic.isChecked()) {
                s += mChkBoxMusic.getText().toString() + "\n";
            }
            if (mChkBoxSing.isChecked()) {
                s += mChkBoxSing.getText().toString() + "\n";
            }
            if (mChkBoxDance.isChecked()) {
                s += mChkBoxDance.getText().toString() + "\n";
            }
            if (mChkBoxTravel.isChecked()) {
                s += mChkBoxTravel.getText().toString() + "\n";
            }
            if (mChkBoxReading.isChecked()) {
                s += mChkBoxReading.getText().toString() + "\n";
            }
            if (mChkBoxWriting.isChecked()) {
                s += mChkBoxWriting.getText().toString() + "\n";
            }
            if (mChkBoxClimbing.isChecked()) {
                s += mChkBoxClimbing.getText().toString() + "\n";
            }
            if (mChkBoxSwim.isChecked()) {
                s += mChkBoxSwim.getText().toString() + "\n";
            }
            if (mChkBoxExercise.isChecked()) {
                s += mChkBoxExercise.getText().toString() + "\n";
            }
            if (mChkBoxFitness.isChecked()) {
                s += mChkBoxFitness.getText().toString() + "\n";
            }
            if (mChkBoxPhoto.isChecked()) {
                s += mChkBoxPhoto.getText().toString() + "\n";
            }
            if (mChkBoxEating.isChecked()) {
                s += mChkBoxEating.getText().toString() + "\n";
            }
            if (mChkBoxPainting.isChecked()) {
                s += mChkBoxPainting.getText().toString() + "\n";
            }
            if (mChkBoxChat.isChecked()) {
                s += mChkBoxChat.getText().toString() + "\n";
            }
            if (mChkBoxPlayComputer.isChecked()) {
                s += mChkBoxPlayComputer.getText().toString() + "\n";
            }
            final int index = s.lastIndexOf("\n");
            if (index > 0) {
                s=s.substring(0, index);
            }
            mTvSelectResult.setText(s);
        }
    };
}