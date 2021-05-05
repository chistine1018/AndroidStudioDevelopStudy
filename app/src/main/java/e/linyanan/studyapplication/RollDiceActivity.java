package e.linyanan.studyapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class RollDiceActivity extends AppCompatActivity {
    Button mBtnRollDice;
    TextView tvRollResult;
    ImageView ivRollDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);
        initView();
        mBtnRollDice.setOnClickListener(onClickListener);
    }

    public void initView() {
        mBtnRollDice = findViewById(R.id.btn_roll_dice);
        tvRollResult = findViewById(R.id.tv_roll_result);
        ivRollDice = findViewById(R.id.img_Rolling_Dice);
    }

    private static class StaticHandler extends Handler {
        private WeakReference<RollDiceActivity> mActivity;

        public StaticHandler(RollDiceActivity activity) {
            mActivity = new WeakReference<RollDiceActivity>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            RollDiceActivity rollDiceActivity = mActivity.get();
            if (rollDiceActivity == null)
                return;
            String s = rollDiceActivity.getString(R.string.roll_result);
            int iRan = (int) (Math.random() * 6 + 1);
            rollDiceActivity.tvRollResult.setText(s + iRan);
            switch (iRan) {
                case 1:
                    rollDiceActivity.ivRollDice.setImageResource(R.drawable.rolldiceone);
                    break;
                case 2:
                    rollDiceActivity.ivRollDice.setImageResource(R.drawable.rolldicetwo);
                    break;
                case 3:
                    rollDiceActivity.ivRollDice.setImageResource(R.drawable.rolldicethree);
                    break;
                case 4:
                    rollDiceActivity.ivRollDice.setImageResource(R.drawable.rolldicefour);
                    break;
                case 5:
                    rollDiceActivity.ivRollDice.setImageResource(R.drawable.rolldicefive);
                    break;
                case 6:
                    rollDiceActivity.ivRollDice.setImageResource(R.drawable.rolldicesix);
                    break;
            }
            rollDiceActivity.mBtnRollDice.setEnabled(true);
        }
    }

    StaticHandler staticHandler = new StaticHandler(RollDiceActivity.this);

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mBtnRollDice.setEnabled(false);
            Resources res = getResources();
            AnimationDrawable animationDrawable = (AnimationDrawable) res.getDrawable(R.drawable.anim_roll_dice);
            ivRollDice.setImageDrawable(animationDrawable);
            animationDrawable.start();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    animationDrawable.stop();
//                    staticHandler.sendMessage(staticHandler.obtainMessage());
//                }
//            }).start();
            staticHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationDrawable.stop();
                    staticHandler.sendMessage(staticHandler.obtainMessage());
                }
            },2000);
        }
    };
}