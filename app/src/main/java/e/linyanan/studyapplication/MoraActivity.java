package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoraActivity extends AppCompatActivity {
    private Button mBtnScissors, mBtnStone, mBtnPaper;
    private TextView mTxtComPlay, mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mora);
        initView();
        mBtnScissors.setOnClickListener(onClickListener);
        mBtnPaper.setOnClickListener(onClickListener);
        mBtnStone.setOnClickListener(onClickListener);

    }

    public void initView() {
        mBtnScissors = findViewById(R.id.mora_btn_Scissors);
        mBtnPaper = findViewById(R.id.mora_btn_Paper);
        mBtnStone = findViewById(R.id.mora_btn_Stone);
        mTxtComPlay = findViewById(R.id.mora_tv_txtComPlay);
        mTxtResult = findViewById(R.id.mora_tv_Result);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mora_btn_Scissors:
                    JudgeResult(1);
                    break;
                case R.id.mora_btn_Paper:
                    JudgeResult(3);
                    break;
                case R.id.mora_btn_Stone:
                    JudgeResult(2);
                    break;


            }
        }
    };

    public void JudgeResult(int MyPlay) {
        int iComPlay = (int) (Math.random() * 3 + 1);
        if (iComPlay == 1) {
            mTxtComPlay.setText(R.string.play_scissors);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
        } else if (iComPlay == 2) {
            mTxtComPlay.setText(R.string.play_stone);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
        } else if (iComPlay == 3) {
            mTxtComPlay.setText(R.string.play_paper);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
        }
    }

}
