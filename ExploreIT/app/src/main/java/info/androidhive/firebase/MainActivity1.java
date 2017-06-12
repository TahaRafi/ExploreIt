package info.androidhive.firebase;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import info.androidhive.firebase.mFireBase.FireBaseClient;


public class MainActivity1 extends AppCompatActivity {
    final static String DB_URL="https://exploreit-f2750.firebaseio.com/";
    EditText nameEditText,urlEditText,branchEditText,noEditText,dealsTxt;
    Button saveBtn;
    RecyclerView rv;

    FireBaseClient fireBaseClient;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


       add = (Button) findViewById(R.id.button4);



        rv= (RecyclerView) findViewById(R.id.mRecylcerID);
        rv.setLayoutManager(new LinearLayoutManager(this));
        fireBaseClient=new FireBaseClient(this,DB_URL,rv);
        fireBaseClient.refreshData();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayDialog();
            }
        });




        /////////////////////aDD DEALS//////////////////////





    }
    //SHOW INPUT DIALOG
    private void displayDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Create Shop");
        d.setContentView(R.layout.dialog);
        nameEditText= (EditText) d.findViewById(R.id.nameEditText);
        urlEditText= (EditText) d.findViewById(R.id.urlEditText);
        branchEditText= (EditText) d.findViewById(R.id.branchEditText);
        noEditText= (EditText) d.findViewById(R.id.noEditText);
      //  dealsTxt=(EditText) d.findViewById(R.id.dealsTxt);

        saveBtn= (Button) d.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fireBaseClient.saveOnline(nameEditText.getText().toString(),urlEditText.getText().toString(),noEditText.getText().toString(),branchEditText.getText().toString());
                nameEditText.setText("");
                urlEditText.setText("");
                branchEditText.setText("");
                noEditText.setText("");
            //  dealsTxt.setText("");

            }
        });






        //SHOW
        d.show();
    }






}