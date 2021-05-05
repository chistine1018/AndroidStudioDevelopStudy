package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherGridViewActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    GridView gridView;
    ImageSwitcher imageSwitcher;
    Integer integers[] = {R.drawable.paper, R.drawable.stone, R.drawable.scissors, R.drawable.paper, R.drawable.stone, R.drawable.scissors, R.drawable.paper, R.drawable.stone, R.drawable.scissors};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_grid_view);
        initView();
        imageSwitcher.setFactory(this);
//        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
//        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        ImageAdapter imageAdapter = new ImageAdapter(this, integers);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setBackgroundColor(Color.WHITE);
        return v;
    }

    public void initView() {
        gridView = findViewById(R.id.gridView);
        imageSwitcher = findViewById(R.id.image_switcher);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            int iRan = (int) (Math.random() * 3 + 1);
            switch (iRan) {
                case 1:
                    TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 300);
                    translateAnimation.setInterpolator(new LinearInterpolator());
                    translateAnimation.setDuration(3000);
                    imageSwitcher.setInAnimation(translateAnimation);
                    imageSwitcher.setOutAnimation(translateAnimation);
//                    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherGridViewActivity.this, R.anim.alpha_in));
//                    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherGridViewActivity.this, R.anim.alpha_out));
                    break;
                case 2:
                    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherGridViewActivity.this, R.anim.scale_rotate_in));
                    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherGridViewActivity.this, R.anim.scale_rotate_out));
                    break;
                case 3:
                    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherGridViewActivity.this, R.anim.trans_in));
                    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherGridViewActivity.this, R.anim.trans_out));
                    break;
            }
            imageSwitcher.setImageResource(integers[position]);
        }
    };
}