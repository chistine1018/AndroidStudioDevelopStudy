package e.linyanan.studyapplication.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import e.linyanan.studyapplication.R;

public class AutoCompleteTextViewActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> mAdapterAutoComText;
    private Button mBtnAutoAdd, mBtnAutoClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        mBtnAutoAdd = findViewById(R.id.btn_auto_add);
        mBtnAutoClear = findViewById(R.id.btn_auto_clear);
        autoCompleteTextView = findViewById(R.id.auto_complete_textview);
        mAdapterAutoComText = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);

        autoCompleteTextView.setAdapter(mAdapterAutoComText);

        mBtnAutoAdd.setOnClickListener(onClickListener);
        mBtnAutoClear.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_auto_add) {
            String s = autoCompleteTextView.getText().toString();
            mAdapterAutoComText.add(s);
            autoCompleteTextView.setText("");
            } else if (view.getId() == R.id.btn_auto_clear) {
                mAdapterAutoComText.clear();
            }
        }
    };
}