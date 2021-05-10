package e.linyanan.studyapplication.SeekBarAndRatingBar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import e.linyanan.studyapplication.R;

public class SeekBarAndRatingBarActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private RatingBar ratingBar;
    private TextView mSeekBarProgress, mRatingBarValue, mRatingBarProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_and_rating_bar);
        initView();
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
    }

    public void initView() {
        seekBar = findViewById(R.id.seek_bar);
        ratingBar = findViewById(R.id.rating_bar);
        mSeekBarProgress = findViewById(R.id.txtSeekBarProgress);
        mRatingBarValue = findViewById(R.id.txtRatingBarValue);
        mRatingBarProgress = findViewById(R.id.txtRatingBarProgress);
    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            String s = getString(R.string.seek_bar_progress);
            mSeekBarProgress.setText(s + String.valueOf(i));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            String s = getString(R.string.rating_bar_value);
            mRatingBarValue.setText(s + String.valueOf(v));
            s = getString(R.string.rating_bar_progress);
            mRatingBarProgress.setText(s + String.valueOf(ratingBar.getProgress()));
        }
    };
}