package e.linyanan.studyapplication.AlertDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import e.linyanan.studyapplication.R;

public class AlertDialogActivity extends AppCompatActivity {
    Button mBtnAlertDialog, mBtnAlertDialogBuilder;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        mBtnAlertDialog = findViewById(R.id.btn_alert_dialog);
        mBtnAlertDialogBuilder = findViewById(R.id.btn_alert_dialog_builder);
        tvResult = findViewById(R.id.txt_result);
        mBtnAlertDialog.setOnClickListener(onClickListener);
        mBtnAlertDialogBuilder.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_alert_dialog) {
                tvResult.setText("");
                MyAlertDialog myAlertDialog = new MyAlertDialog(AlertDialogActivity.this);
                myAlertDialog.setTitle("AlertDialog");
                myAlertDialog.setMessage("AlertDialog的使用方式是要建立一個繼承它的class");
                myAlertDialog.setIcon(android.R.drawable.ic_dialog_info);
                myAlertDialog.setCancelable(false);
                myAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", altPosOnClickListener);
                myAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", altNegOnClickListener);
                myAlertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Cancel", altNeuOnClickListener);
                myAlertDialog.show();
            } else if (view.getId() == R.id.btn_alert_dialog_builder) {
                tvResult.setText("");
                AlertDialog.Builder myAlertDialogBuilder = new AlertDialog.Builder(AlertDialogActivity.this);
                myAlertDialogBuilder.setTitle("AlertDialog");
                myAlertDialogBuilder.setMessage("由AlertDialogBuilder所產生");
                myAlertDialogBuilder.setIcon(android.R.drawable.ic_dialog_info);
                myAlertDialogBuilder.setCancelable(false);
                myAlertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvResult.setText("你啟動了AlertDialogBuilder然後按下了Yes");
                    }
                });
                myAlertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvResult.setText("你啟動了AlertDialogBuilder然後按下了No");
                    }
                });
                myAlertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvResult.setText("你啟動了AlertDialogBuilder然後按下了Cancel");
                    }
                });
                myAlertDialogBuilder.show();
            }
        }
    };
    private DialogInterface.OnClickListener altPosOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            tvResult.setText("你啟動了AlertDialog然後按下了Yes");
        }
    };
    private DialogInterface.OnClickListener altNegOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            tvResult.setText("你啟動了AlertDialog然後按下了No");
        }
    };
    private DialogInterface.OnClickListener altNeuOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            tvResult.setText("你啟動了AlertDialog然後按下了Cancel");
        }
    };
}