package e.linyanan.studyapplication.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

import e.linyanan.studyapplication.R;

public class IntentActivity extends AppCompatActivity {
    Button mBtnWWW, mBtnPhoto, mBtnMP3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        mBtnWWW = findViewById(R.id.btn_www);
        mBtnMP3 = findViewById(R.id.btn_mp3);
        mBtnPhoto = findViewById(R.id.btn_photo);

        mBtnWWW.setOnClickListener(onClickListener);
        mBtnMP3.setOnClickListener(onClickListener);
        mBtnPhoto.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_www) {
                Uri uri = Uri.parse("https://blog.csdn.net/u012842688/article/details/50785940");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            } else if (view.getId() == R.id.btn_mp3) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                String mp3File = Environment.getExternalStorageDirectory().getPath() + File.separator + "yt1s.com\\ -\\ 薛之謙\\ Joker\\ Xue一半官方完整版\\ MV.mp3";
                File file = new File(mp3File);
                intent.setDataAndType(Uri.fromFile(file), "audio/*");
                startActivity(intent);
            } else if (view.getId() == R.id.btn_photo) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String mp3File = Environment.getExternalStorageDirectory().getPath() + File.separator + "mars.jpg";
                File file = new File(mp3File);
                intent.setDataAndType(Uri.fromFile(file), "image/*");
                startActivity(intent);
            }
        }
    };
}