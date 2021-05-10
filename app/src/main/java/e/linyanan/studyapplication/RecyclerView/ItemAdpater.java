package e.linyanan.studyapplication.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import e.linyanan.studyapplication.R;

public class ItemAdpater extends RecyclerView.Adapter<ItemAdpater.ViewHolder> {
    private List<String> mListString;


    public ItemAdpater(List<String> listString) {
        this.mListString = listString;
    }


    @NonNull
    @Override
    public ItemAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdpater.ViewHolder holder, int position) {
        holder.mIv.setImageResource(android.R.drawable.star_on);
        holder.mTv.setText(mListString.get(position));
    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mIv;
        public TextView mTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.recycler_iv);
            mTv = itemView.findViewById(R.id.recycler_tv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), mListString.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}
