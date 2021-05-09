package e.linyanan.studyapplication.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import e.linyanan.studyapplication.R;

public class FMGameResultFragment extends Fragment {
    private EditText mEdtCountSet, mEdtCountPlayerWin, mEdtCountComWin, mEdtDraw;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_fragment_game_result, container, false);
    }

    public void FMGameResultFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();

        mEdtCountSet = getActivity().findViewById(R.id.fm_edt_count_set);
        mEdtCountPlayerWin = getActivity().findViewById(R.id.fm_edt_count_player_win);
        mEdtCountComWin = getActivity().findViewById(R.id.fm_edt_count_com_win);
        mEdtDraw = getActivity().findViewById(R.id.fm_edt_count_draw);
        mEdtCountSet.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountSet));
        mEdtCountPlayerWin.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountPlayerWin));
        mEdtCountComWin.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountComWin));
        mEdtDraw.setText(String.valueOf(((FragmentManagerActivity) getActivity()).miCountDraw));
        ((FragmentManagerActivity) getActivity()).mGameResultType = FMMainFragment.GameResultType.TYPE_1;
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