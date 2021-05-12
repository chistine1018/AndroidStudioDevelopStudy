package e.linyanan.studyapplication.ProgressBarAndThread;

import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Calendar;

public class MyThread extends Thread {

    private Handler mHandler;
    private ProgressBar mProgressBar;
    private ProgressDialog mProgressDialog;

    @Override
    public void run() {
        super.run();
        Calendar begin = Calendar.getInstance();
        do {
            Calendar now = Calendar.getInstance();
            final int iDiffSec = 2 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE) + now.get(Calendar.SECOND) - begin.get(Calendar.SECOND));
            if (iDiffSec * 2 > 100) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mProgressDialog.setProgress(100);
                    }
                });
                break;
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mProgressDialog.setProgress(iDiffSec * 2);
                }
            });

            if (iDiffSec * 4 < 100) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mProgressDialog.setSecondaryProgress(iDiffSec * 4);
                    }
                });
            } else {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mProgressDialog.setSecondaryProgress(100);
                    }
                });
            }
        } while (true);
        mProgressDialog.dismiss();
    }

    void setmHandler(android.os.Handler h) {
        this.mHandler = h;
    }

    void setmProgressBar(ProgressBar progressBar) {
        this.mProgressBar = progressBar;
    }

    void setProgressBarDialog(ProgressDialog progressDialog) {
        this.mProgressDialog = progressDialog;
    }

}
