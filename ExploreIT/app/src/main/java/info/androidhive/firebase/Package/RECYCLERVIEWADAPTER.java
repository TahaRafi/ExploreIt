package info.androidhive.firebase.Package;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;

import info.androidhive.firebase.Package.Package1.RECYCLERVIEWHOLDERS;
import info.androidhive.firebase.R;
import info.androidhive.firebase.TASK;

public class RECYCLERVIEWADAPTER extends RecyclerView.Adapter<RECYCLERVIEWHOLDERS> {
    private List<TASK> task;
    protected Context context;
    public RECYCLERVIEWADAPTER(Context context, List<TASK> task) {
        this.task = task;
        this.context = context;
    }
    @Override
    public RECYCLERVIEWHOLDERS onCreateViewHolder(ViewGroup parent, int viewType) {
        RECYCLERVIEWHOLDERS viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_list, parent, false);
        viewHolder = new RECYCLERVIEWHOLDERS(layoutView, task);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RECYCLERVIEWHOLDERS holder, int position) {
        holder.categoryTitle.setText(task.get(position).getTask());
    }
    @Override
    public int getItemCount() {
        return this.task.size();
    }
}