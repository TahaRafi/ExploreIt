package info.androidhive.firebase.mRecycler;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.firebase.MainActivity1;
import info.androidhive.firebase.R;


/**
 * Created by Oclemmy on 4/12/2016 for ProgrammingWizards Channel.
 */
public class MyHolder extends RecyclerView.ViewHolder {
    TextView nameTxt;
    ImageView img;
    TextView branchTxt;
    TextView numberTxt;
  //  TextView dealsText;
    public MyHolder(View itemView) {
        super(itemView);
        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        img = (ImageView) itemView.findViewById(R.id.movieImage);
        branchTxt=(TextView)itemView.findViewById(R.id.textView2);
        numberTxt=(TextView)itemView.findViewById(R.id.textView3);
      //  dealsText=(TextView)itemView.findViewById(R.id.dealsTxt);


    }




}