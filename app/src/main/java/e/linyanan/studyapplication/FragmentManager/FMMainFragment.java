package e.linyanan.studyapplication.FragmentManager;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import javax.security.auth.callback.Callback;

import e.linyanan.studyapplication.R;

public class FMMainFragment extends Fragment {
    private ImageButton mImgBtnScissors, mImgBtnStone, mImgBtnPaper;
    private ImageView mIvComPlay;
    private TextView mTxtResult;


    public enum GameResultType {
        TYPE_1, TYPE_2, HIDE;
    }

    public interface CallBack {
        void updateGameResult(int iCountSet, int iCountPlayerWin, int iCountComWin, int iCountDraw);

        void enableGameResult(GameResultType type);
    }

    private CallBack mCallback;
    public int mCountSet = 0,
            mCountPlayerWin = 0,
            mCountComWin = 0,
            mDraw = 0;

    private Button mBtnShowResult1, mBtnShowResult2, mHideResult;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mCallback = (CallBack) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_fragment_main, container, false);
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

        mBtnShowResult1 = getView().findViewById(R.id.btn_show_result1);
        mBtnShowResult2 = getView().findViewById(R.id.btn_show_result2);
        mHideResult = getView().findViewById(R.id.btn_hide_result);

        mBtnShowResult1.setOnClickListener(onClickListener);
        mBtnShowResult2.setOnClickListener(onClickListener);
        mHideResult.setOnClickListener(onClickListener);

        mImgBtnScissors.setOnClickListener(onClickListener);
        mImgBtnStone.setOnClickListener(onClickListener);
        mImgBtnPaper.setOnClickListener(onClickListener);

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
                case R.id.btn_show_result1:
                    mCallback.enableGameResult(GameResultType.TYPE_1);
                    break;
                case R.id.btn_show_result2:
                    mCallback.enableGameResult(GameResultType.TYPE_2);
                    break;
                case R.id.btn_hide_result:
                    mCallback.enableGameResult(GameResultType.HIDE);
                    break;
            }
        }
    };

    public void JudgeResult(int MyPlay) {
        mCountSet++;
        int iComPlay = (int) (Math.random() * 3 + 1);
        if (iComPlay == 1) {
            mIvComPlay.setImageResource(R.drawable.scissors);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
                mDraw++;
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                mCountPlayerWin++;
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                mCountComWin++;
            }
        } else if (iComPlay == 2) {
            mIvComPlay.setImageResource(R.drawable.stone);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                mCountComWin++;
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
                mDraw++;
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                mCountPlayerWin++;
            }
        } else if (iComPlay == 3) {
            mIvComPlay.setImageResource(R.drawable.paper);
            if (MyPlay == 1) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
                mCountPlayerWin++;
            } else if (MyPlay == 2) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
                mCountComWin++;
            } else if (MyPlay == 3) {
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
                mDraw++;
            }
        }
        mCallback.updateGameResult(mCountSet, mCountPlayerWin, mCountComWin, mDraw);
    }
}