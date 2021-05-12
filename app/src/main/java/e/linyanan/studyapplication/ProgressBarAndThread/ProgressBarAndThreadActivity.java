package e.linyanan.studyapplication.ProgressBarAndThread;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

import e.linyanan.studyapplication.R;

public class ProgressBarAndThreadActivity extends AppCompatActivity {
    Button mBtnProgressStart;
    ProgressDialog progressDlg;
    private static class StaticHandler extends Handler {
        private final WeakReference<ProgressBarAndThreadActivity> mActivity;

        public StaticHandler(ProgressBarAndThreadActivity activity) {
            mActivity = new WeakReference<ProgressBarAndThreadActivity>(activity);
        }
    }

    public final StaticHandler staticHandler = new StaticHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_and_thread);
        mBtnProgressStart=findViewById(R.id.btn_progress_start);
        mBtnProgressStart.setOnClickListener(onClickListener);


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final ProgressBar progressBar=findViewById(R.id.progress_bar);

            progressDlg = new ProgressDialog(ProgressBarAndThreadActivity.this);
            progressDlg.setTitle("執行中");
            progressDlg.setMessage("請稍等...");
            progressDlg.setIcon(android.R.drawable.ic_dialog_info);
            progressDlg.setCancelable(false);
            progressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDlg.setMax(100);
            progressDlg.show();
            MyThread myThread=new MyThread();
            myThread.setmHandler(staticHandler);
//            myThread.setmProgressBar(progressBar);
            myThread.setProgressBarDialog(progressDlg);
            myThread.start();
        }
    };
}