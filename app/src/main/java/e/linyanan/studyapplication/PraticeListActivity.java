package e.linyanan.studyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PraticeListActivity extends ExpandableListActivity {
    TextView tvResult;
    private static final String ITEM_NAME = "Item Name";
    private static final String ITEM_SUBNAME = "Item Subname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list);
        tvResult = findViewById(R.id.expand_list_txt_result);
        List<Map<String, String>> groupList = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childList2D = new ArrayList<List<Map<String, String>>>();

        for (int i = 0; i < 5; i++) {
            Map<String, String> group = new HashMap<String, String>();
            group.put(ITEM_NAME, "選項群組" + i);
            group.put(ITEM_SUBNAME, "說明" + i);
            groupList.add(group);

            List<Map<String, String>> childGroup = new ArrayList<Map<String, String>>();
            for (int j = 0; j < 2; j++) {
                Map<String, String> child = new HashMap<String, String>();
                child.put(ITEM_NAME, "選項群組" + i);
                child.put(ITEM_SUBNAME, "說明" + i);
                childGroup.add(child);
            }
            childList2D.add(childGroup);
        }

        ExpandableListAdapter expandableListAdapter = new SimpleExpandableListAdapter(this, groupList, android.R.layout.simple_expandable_list_item_2,
                new String[]{ITEM_NAME, ITEM_SUBNAME}, new int[]{android.R.id.text1, android.R.id.text2}, childList2D, android.R.layout.simple_expandable_list_item_2,
                new String[]{ITEM_NAME, ITEM_SUBNAME}, new int[]{android.R.id.text1, android.R.id.text2});

        setListAdapter(expandableListAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        String s = "選擇：群組" + groupPosition + ",選項" + childPosition + ",ID" + id;
        tvResult.setText(s);
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }
}