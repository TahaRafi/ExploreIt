package info.androidhive.firebase.Package.Package1;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import info.androidhive.firebase.R;
import info.androidhive.firebase.TASK;

public class RECYCLERVIEWHOLDERS extends RecyclerView.ViewHolder{
    private static final String TAG = RECYCLERVIEWHOLDERS.class.getSimpleName();
    public ImageView markIcon;
    public TextView categoryTitle;
    public ImageView deleteIcon;
    private List<TASK> taskObject;
    public RECYCLERVIEWHOLDERS(final View itemView, final List<TASK> taskObject) {
        super(itemView);
        this.taskObject = taskObject;
        categoryTitle = (TextView)itemView.findViewById(R.id.task_title);
        markIcon = (ImageView)itemView.findViewById(R.id.task_icon);
        deleteIcon = (ImageView)itemView.findViewById(R.id.task_delete);
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete icon has been clicked", Toast.LENGTH_LONG).show();
                String taskTitle = taskObject.get(getAdapterPosition()).getTask();
                Log.d(TAG, "Task Title " + taskTitle);
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();


                com.google.firebase.database.Query applesQuery = ref.orderByChild("task").equalTo(taskTitle);
                applesQuery.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                        for (com.google.firebase.database.DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }



                });
            }
        });
    }
}