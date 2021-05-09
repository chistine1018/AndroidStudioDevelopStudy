package e.linyanan.studyapplication.Fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import e.linyanan.studyapplication.R;

public class MainFragment extends Fragment {
    private ImageButton mImgBtnScissors, mImgBtnStone, mImgBtnPaper;
    private ImageView mIvComPlay;
    private TextView mTxtResult;

    private EditText mEdtCountSet, mEdtCountPlayerWin, mEdtCountComWin, mEdtDraw;

    private int mCountSet = 0,
            mCountPlayerWin = 0,
            mCountComWin = 0,
            mDraw = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    public void initView() {
        mImgBtnScissors = getView().findViewById(R.id.mora_imgbtn_Scissors);
        mImgBtnPaper = getView().findViewById(R.id.mora_imgbtn_Paper);
        mImgBtnStone = getView().findViewById(R.id.mora_imgbtn_Stone);
        mIvComPlay = getView().findViewById(R.id.mora_img_ComPlay);
        mTxtResult = getView().findViewById(R.id.mora_tv_Result);

        mEdtCountSet = getActivity().findViewById(R.id.edt_count_set);
        mEdtCountPlayerWin = getActivity().findViewById(R.id.edt_count_player_win);
        mEdtCountComWin = getActivity().findViewById(R.id.edt_count_com_win);
        mEdtDraw = getActivity().findViewById(R.id.edt_count_draw);
        mImgBtnScissors.setOnClickListener(onClickListener);
        mImgBtnStone.setOnClickListener(onClickListener);
        mImgBtnPaper.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mCountSet++;
            Log.i("TAG", "onClick: "+mCountSet);
            mEdtCountSet.setText(String.valueOf(mCountSet));
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
                mDraw++;
                mEdtDraw.setText(String.valueOf(mDraw));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                mCountPlayerWin++;
                mEdtCountPlayerWin.setText(String.valueOf(mCountPlayerWin));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                mCountComWin++;
                mEdtCountComWin.setText(String.valueOf(mCountComWin));
            }
        } else if (iComPlay == 2) {
            mIvComPlay.setImageResource(R.drawable.stone);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                mCountComWin++;
                mEdtCountComWin.setText(String.valueOf(mCountComWin));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
                mDraw++;
                mEdtDraw.setText(String.valueOf(mDraw));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                mCountPlayerWin++;
                mEdtCountPlayerWin.setText(String.valueOf(mCountPlayerWin));
            }
        } else if (iComPlay == 3) {
            mIvComPlay.setImageResource(R.drawable.paper);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                mCountPlayerWin++;
                mEdtCountPlayerWin.setText(String.valueOf(mCountPlayerWin));
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                mCountComWin++;
                mEdtCountComWin.setText(String.valueOf(mCountComWin));
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
                mDraw++;
                mEdtDraw.setText(String.valueOf(mDraw));
            }
        }
    }
}