package e.linyanan.studyapplication.CustomDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import e.linyanan.studyapplication.R;

public class CustomDialogActivity extends AppCompatActivity {
    Button mBtnLogin, mBtnOk, mBtnCancel;
    TextView tvResult;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnLogin = findViewById(R.id.btn_login);
        tvResult = findViewById(R.id.txt_result);
        mDialog = new Dialog(CustomDialogActivity.this);
        mDialog.setCancelable(false);
        mDialog.setContentView(R.layout.my_dialog);
        mBtnOk = mDialog.findViewById(R.id.btn_OK);
        mBtnCancel = mDialog.findViewById(R.id.btn_cancel);
        mBtnLogin.setOnClickListener(onClickListener);
        mBtnOk.setOnClickListener(onClickListener);
        mBtnCancel.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_login) {
                tvResult.setText("");
                mDialog.show();
            } else if (view.getId() == R.id.btn_OK) {
                EditText editTextUsername = mDialog.findViewById(R.id.edt_username);
                EditText editTextUserPassword = mDialog.findViewById(R.id.edt_user_password);
                tvResult.setText("你輸的使用者名稱：" + editTextUsername.getText().toString() + "密碼：" + editTextUserPassword.getText().toString());
                mDialog.cancel();
            } else if (view.getId() == R.id.btn_cancel) {
                tvResult.setText("你按下了取消按鈕");
                mDialog.cancel();

            }

        }
    };
}