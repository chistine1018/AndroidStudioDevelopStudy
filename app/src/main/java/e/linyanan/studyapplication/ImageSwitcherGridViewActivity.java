package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherGridViewActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {
    GridView gridView;
    ImageSwitcher imageSwitcher;
    Integer integers[] = {R.drawable.paper, R.drawable.stone, R.drawable.scissors,R.drawable.paper, R.drawable.stone, R.drawable.scissors,R.drawable.paper, R.drawable.stone, R.drawable.scissors};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_grid_view);
        initView();
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
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
            imageSwitcher.setImageResource(integers[position]);
        }
    };
}