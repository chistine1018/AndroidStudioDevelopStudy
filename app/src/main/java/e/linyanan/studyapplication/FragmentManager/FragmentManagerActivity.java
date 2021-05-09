package e.linyanan.studyapplication.FragmentManager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import e.linyanan.studyapplication.R;

public class FragmentManagerActivity extends AppCompatActivity implements FMMainFragment.CallBack {
    private final static String TAG = "Result";
    private int mTagCount = 0;

    public FMMainFragment.GameResultType mGameResultType;
    public Fragment fragmResult;
    public int miCountSet = 0, miCountPlayerWin = 0, miCountComWin = 0, miCountDraw = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_activity_fragment);
    }

    @Override
    public void updateGameResult(int iCountSet, int iCountPlayerWin, int iCountComWin, int iCountDraw) {
        this.miCountSet = iCountSet;
        this.miCountPlayerWin = iCountPlayerWin;
        this.miCountComWin = iCountComWin;
        this.miCountDraw = iCountDraw;
        if (findViewById(R.id.frame_lay).isShown()) {
            switch (mGameResultType) {
                case TYPE_1:
                    ((FMGameResultFragment) fragmResult).updateGameResult(iCountSet, iCountPlayerWin, iCountComWin, iCountDraw);
                    break;
                case TYPE_2:
                    ((FMGameResult2Fragment) fragmResult).updateGameResult(iCountSet, iCountPlayerWin, iCountComWin, iCountDraw);
                    break;
            }
        }
    }

    @Override
    public void enableGameResult(FMMainFragment.GameResultType type) {
        FragmentTransaction fragTran;
        String sFragTag;
        switch (type) {
            case TYPE_1:
                FMGameResultFragment frag = new FMGameResultFragment();
                fragTran = getSupportFragmentManager().beginTransaction();
                mTagCount++;
                sFragTag = TAG + mTagCount;
                fragTran.replace(R.id.frame_lay, frag, sFragTag);
                fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTran.addToBackStack(null);
                fragTran.commit();
                break;
            case TYPE_2:
                FMGameResult2Fragment frag2 = new FMGameResult2Fragment();
                fragTran = getSupportFragmentManager().beginTransaction();
                mTagCount++;
                sFragTag = TAG + mTagCount;
                fragTran.replace(R.id.frame_lay, frag2, sFragTag);
                fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTran.addToBackStack(null);
                fragTran.commit();
                break;
            case HIDE:
                FragmentManager fragMgr = getSupportFragmentManager();
                sFragTag = TAG + new Integer(mTagCount).toString();
                Fragment fragGameResult = fragMgr.findFragmentByTag(sFragTag);
                fragTran = fragMgr.beginTransaction();
                fragTran.remove(fragGameResult);
                fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTran.addToBackStack(null);
                fragTran.commit();
                break;
        }
    }
}