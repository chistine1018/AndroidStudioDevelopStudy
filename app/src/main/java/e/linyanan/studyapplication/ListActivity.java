package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends android.app.ListActivity {
    private TextView tvResult;
    List<Map<String, Object>> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        tvResult = findViewById(R.id.list_txt_result);
        mList = new ArrayList<Map<String, Object>>();
        String[] listFromResource = getResources().getStringArray(R.array.weekday);
        for (int i = 0; i < listFromResource.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", android.R.drawable.ic_menu_my_calendar);
            item.put("txtView", listFromResource[i]);
            mList.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, mList, R.layout.list_item, new String[]{"imgView", "txtView"}, new int[]{R.id.image_view, R.id.txtView});
        setListAdapter(adapter);
        ListView listView = getListView();
        listView.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String s = ((TextView) view.findViewById(R.id.txtView)).getText().toString();
            tvResult.setText(s);
        }
    };
}