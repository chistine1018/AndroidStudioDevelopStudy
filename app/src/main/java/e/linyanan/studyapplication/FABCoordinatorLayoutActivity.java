package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FABCoordinatorLayoutActivity extends AppCompatActivity {
    private TextView mTvMsg;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_b_coordinator_layout);
        initView();
        floatingActionButton.setOnClickListener(onClickListener);
    }

    public void initView() {
        mTvMsg = findViewById(R.id.txtMsg);
        floatingActionButton = findViewById(R.id.fab);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "你按了按鈕", Snackbar.LENGTH_INDEFINITE).setAction("可以選的字串", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(FABCoordinatorLayoutActivity.this, "彥安好帥", Toast.LENGTH_SHORT).show();
                }
            }).setActionTextColor(Color.rgb(0, 255, 0)).show();
//            mTvMsg.setText("你按了，FAB");
        }
    };
}