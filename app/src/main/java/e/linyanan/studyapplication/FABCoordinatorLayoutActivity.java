package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
            mTvMsg.setText("你按了，FAB");
        }
    };
}