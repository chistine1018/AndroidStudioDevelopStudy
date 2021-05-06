package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ObjectAnimationActivity extends AppCompatActivity {
    private LinearLayout mLinearLayoutRoot;
    private Button mBtnRorate, mBtnTransparent, mBtnDrop, mBtnScale, mBtnShift, mBtnColor;
    private TextView mTvResult;
    private float y, yEnd;
    private boolean isFallingFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
        initView();
        mBtnRorate.setOnClickListener(onClickListener);
        mBtnTransparent.setOnClickListener(onClickListener);
        mBtnDrop.setOnClickListener(onClickListener);
        mBtnScale.setOnClickListener(onClickListener);
        mBtnShift.setOnClickListener(onClickListener);
        mBtnColor.setOnClickListener(onClickListener);
    }

    public void initView() {
        mLinearLayoutRoot = findViewById(R.id.ilnLayRoot);
        mBtnRorate = findViewById(R.id.btn_rorate);
        mBtnTransparent = findViewById(R.id.btn_transparent);
        mBtnDrop = findViewById(R.id.btn_drop);
        mTvResult = findViewById(R.id.tv_result);
        mBtnScale = findViewById(R.id.btn_scale);
        mBtnShift = findViewById(R.id.btn_shift);
        mBtnColor = findViewById(R.id.btn_color);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_rorate:
                    ObjectAnimator animRorate = ObjectAnimator.ofFloat(mTvResult, "rotation", 0, 360);
                    animRorate.setDuration(3000);
                    animRorate.setRepeatCount(1);
                    animRorate.setRepeatMode(ObjectAnimator.REVERSE);
                    animRorate.setInterpolator(new AccelerateDecelerateInterpolator());
                    animRorate.start();
                    break;
                case R.id.btn_transparent:
                    ObjectAnimator animAlpha = ObjectAnimator.ofFloat(mTvResult, "alpha", 1, 0);
                    animAlpha.setDuration(2000);
                    animAlpha.setRepeatCount(1);
                    animAlpha.setRepeatMode(ObjectAnimator.REVERSE);
                    animAlpha.setInterpolator(new LinearInterpolator());
                    animAlpha.start();
                    break;
                case R.id.btn_drop:
                    if (isFallingFirst) {
                        y = mTvResult.getY();
                        yEnd = mLinearLayoutRoot.getHeight() - mTvResult.getHeight();
                        isFallingFirst = false;
                    }
                    ObjectAnimator animDrop = ObjectAnimator.ofFloat(mTvResult, "y", y, yEnd);
                    animDrop.setDuration(2000);
                    animDrop.setRepeatCount(ObjectAnimator.INFINITE);
                    animDrop.setInterpolator(new BounceInterpolator());
                    animDrop.start();
                    break;
                case R.id.btn_scale:
                    ValueAnimator animScale = ValueAnimator.ofInt(0, 35);
                    animScale.setDuration(4000);
                    animScale.setRepeatCount(1);
                    animScale.setRepeatMode(ObjectAnimator.REVERSE);
                    animScale.setInterpolator(new LinearInterpolator());
                    animScale.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int val = (Integer) valueAnimator.getAnimatedValue();
                            mTvResult.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15 + val);
                        }
                    });
                    animScale.start();
                    break;
                case R.id.btn_shift:
                    float x, xEnd1, xEnd2;
                    x = mTvResult.getY();
                    xEnd1 = 0;
                    xEnd2 = mLinearLayoutRoot.getWidth() - mTvResult.getWidth();

                    ObjectAnimator animShift1 = ObjectAnimator.ofFloat(mTvResult, "x", x, xEnd1);
                    animShift1.setDuration(2000);
                    animShift1.setInterpolator(new AccelerateDecelerateInterpolator());

                    ObjectAnimator animShift2 = ObjectAnimator.ofFloat(mTvResult, "x", xEnd1, xEnd2);
                    animShift2.setDuration(3000);
                    animShift2.setInterpolator(new AccelerateDecelerateInterpolator());

                    ObjectAnimator animShift3 = ObjectAnimator.ofFloat(mTvResult, "x", xEnd2, x);
                    animShift2.setDuration(2000);
                    animShift2.setInterpolator(new AccelerateDecelerateInterpolator());

                    AnimatorSet animationSet = new AnimatorSet();
                    animationSet.playSequentially(animShift1, animShift2, animShift3);
                    animationSet.start();
                    break;
                case R.id.btn_color:
                    int iBackColorRedVal, iBackColorRedEnd;
                    final int iBackColor = ((ColorDrawable) (mLinearLayoutRoot.getBackground())).getColor();
                    iBackColorRedVal = (iBackColor & 0x00FF0000) >> 16;
                    if (iBackColorRedVal > 127) {
                        iBackColorRedEnd = 0;
                    } else
                        iBackColorRedEnd = 255;

                    ValueAnimator animColor = ValueAnimator.ofInt(iBackColorRedVal, iBackColorRedEnd);
                    animColor.setDuration(3000);
                    animColor.setInterpolator(new LinearInterpolator());
                    animColor.start();
                    animColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int val = (Integer) valueAnimator.getAnimatedValue();
                            mLinearLayoutRoot.setBackgroundColor(iBackColor & 0xFF00FFFF | val << 16);
                        }
                    });
                    break;
            }

        }
    };
};
