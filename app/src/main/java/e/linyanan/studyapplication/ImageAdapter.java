package e.linyanan.studyapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageAdapter extends BaseAdapter {
    Context mContext;
    Integer[] mIntegers;

    public ImageAdapter(Context mContext, Integer[] integers) {
        this.mContext = mContext;
        this.mIntegers = integers;
    }

    @Override
    public int getCount() {
        return mIntegers.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ImageView v;
        if (convertView == null) {
            v = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            v.setLayoutParams(new GridLayout.LayoutParams(params));
            v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            v = (ImageView) convertView;
        }
        v.setImageResource(mIntegers[i]);
        return v;
    }
}
