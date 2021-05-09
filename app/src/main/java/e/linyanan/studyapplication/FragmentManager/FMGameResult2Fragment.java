package e.linyanan.studyapplication.FragmentManager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import e.linyanan.studyapplication.Fragment.MainFragment;
import e.linyanan.studyapplication.R;

public class FMGameResult2Fragment extends Fragment {
    private EditText mEdtCountSet, mEdtCountPlayerWin, mEdtCountComWin, mEdtDraw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_fragment_game_result2, container, false);
    }

    public void  FMGameResult2Fragment() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mEdtCountSet = (EditText) getActivity().findViewById(R.id.game2_edt_count_set);
        mEdtCountPlayerWin =(EditText) getActivity().findViewById(R.id.game2_edt_count_player_win_set);
        mEdtCountComWin =(EditText) getActivity().findViewById(R.id.game2_edt_count_com_win_set);
        mEdtDraw =(EditText) getActivity().findViewById(R.id.game2_edt_count_draw_set);
        mEdtCountSet.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountSet));
        mEdtCountPlayerWin.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountPlayerWin));
        mEdtCountComWin.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountComWin));
        mEdtDraw.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountDraw));
        ((FragmentManagerActivity) getActivity()).mGameResultType = FMMainFragment.GameResultType.TYPE_2;
        ((FragmentManagerActivity) getActivity()).fragmResult = this;
        getActivity().findViewById(R.id.frame_lay).setVisibility(View.VISIBLE);

    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().findViewById(R.id.frame_lay).setVisibility(View.GONE);
    }

    public void updateGameResult(int iCountSet, int iCountPlayerWin, int iCountComWin, int iCountDraw) {
            mEdtCountSet.setText(String.valueOf(iCountSet));
            mEdtCountPlayerWin.setText(String.valueOf(iCountPlayerWin));
            mEdtCountComWin.setText(String.valueOf(iCountComWin));
            mEdtDraw.setText(String.valueOf(iCountDraw));
    }
}