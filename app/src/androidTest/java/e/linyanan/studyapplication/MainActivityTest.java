package e.linyanan.studyapplication;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<NormalActivity> {
    public MainActivityTest() {
        super(NormalActivity.class);
    }

    private NormalActivity mNormal;
    private EditText mEdtSex, mEdtAge;
    private Button mBtnOk;
    private TextView mTvResult;


    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());


        mNormal = (NormalActivity) getActivity();
        mEdtSex = (EditText) mNormal.findViewById(R.id.editSex);
        mEdtAge = (EditText) mNormal.findViewById(R.id.editAge);
        mBtnOk = (Button) mNormal.findViewById(R.id.btn_OK);
        mTvResult = (TextView) mNormal.findViewById(R.id.tvResult);
    }

    @Test
    public void maleAge25() {
        mNormal.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mEdtSex.setText("男");
                mEdtAge.setText("25");
                mBtnOk.performClick();
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(mNormal.getString(R.string.suggestion_begin_find_couple), mTvResult.getText().toString());

    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
