package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageButtonImageViewActivity extends AppCompatActivity {
    private ImageButton mImgBtnScissors, mImgBtnStone, mImgBtnPaper;
    private ImageView mIvComPlay;
    private TextView mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button_image_view);
        initView();
        mImgBtnScissors.setOnClickListener(onClickListener);
        mImgBtnStone.setOnClickListener(onClickListener);
        mImgBtnPaper.setOnClickListener(onClickListener);
    }

    public void initView() {
        mImgBtnScissors = findViewById(R.id.mora_imgbtn_Scissors);
        mImgBtnPaper = findViewById(R.id.mora_imgbtn_Paper);
        mImgBtnStone = findViewById(R.id.mora_imgbtn_Stone);
        mIvComPlay = findViewById(R.id.mora_img_ComPlay);
        mTxtResult = findViewById(R.id.mora_tv_Result);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mora_imgbtn_Scissors:
                    JudgeResult(1);
                    break;
                case R.id.mora_imgbtn_Paper:
                    JudgeResult(3);
                    break;
                case R.id.mora_imgbtn_Stone:
                    JudgeResult(2);
                    break;


            }
        }
    };

    public void JudgeResult(int MyPlay) {
        int iComPlay = (int) (Math.random() * 3 + 1);
        if (iComPlay == 1) {
            mIvComPlay.setImageResource(R.drawable.scissors);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
        } else if (iComPlay == 2) {
            mIvComPlay.setImageResource(R.drawable.stone);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
        } else if (iComPlay == 3) {
            mIvComPlay.setImageResource(R.drawable.paper);
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