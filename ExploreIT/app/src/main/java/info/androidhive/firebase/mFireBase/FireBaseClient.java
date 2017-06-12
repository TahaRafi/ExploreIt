package info.androidhive.firebase.mFireBase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

import info.androidhive.firebase.mData.Movie;
import info.androidhive.firebase.mRecycler.MyAdapter;

/**
 * Created by Oclemmy on 4/12/2016 for ProgrammingWizards Channel.
 */
public class FireBaseClient {
    Context c;
    String DB_URL;
    RecyclerView rv;
    Firebase fire;
    ArrayList<Movie> movies=new ArrayList<>();
    MyAdapter adapter;
    public FireBaseClient(Context c, String DB_URL, RecyclerView rv) {
        this.c = c;
        this.DB_URL = DB_URL;
        this.rv = rv;
        //INITIALIZE
        Firebase.setAndroidContext(c);
        //INSTANTIATE
        fire=new Firebase(DB_URL);
    }
    //SAVE
    public void saveOnline(String name,String url,String no,String branch)
    {
        Movie m=new Movie();
        m.setName(name);
        m.setUrl(url);
        m.setbranch(branch);
        m.setnumber(no);
      //  m.setdeals(deals);


        fire.child("Deals").push().setValue(m);
    }
    //RETRIEVE
    public void refreshData()
    {
        fire.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
    private void getUpdates(DataSnapshot dataSnapshot)
    {
        movies.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren())
        {
            Movie m=new Movie();
            m.setName(ds.getValue(Movie.class).getName());
            m.setUrl(ds.getValue(Movie.class).getUrl());
            m.setnumber(ds.getValue(Movie.class).getnumber());
            m.setbranch(ds.getValue(Movie.class).getbranch());
        //   m.setdeals(ds.getValue(Movie.class).getdeals());




            movies.add(m);
        }
        if(movies.size()>0)
        {
            adapter=new MyAdapter(c,movies);
            rv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"No data",Toast.LENGTH_SHORT).show();
        }
    }
}