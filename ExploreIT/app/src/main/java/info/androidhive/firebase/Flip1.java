package info.androidhive.firebase;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Flip1 extends AppCompatActivity {
    ImageView imgFront;
    ImageView imgBack;
    Button btnFlip;
    boolean isBackVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip1);

        imgFront = (ImageView)findViewById(R.id.imgFront);
        imgBack = (ImageView)findViewById(R.id.imgBack);
        btnFlip = (Button)findViewById(R.id.btnFlip);

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_right_out);

        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);

        btnFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isBackVisible){
                    setRightOut.setTarget(imgFront);
                    setLeftIn.setTarget(imgBack);
                    setRightOut.start();
                    setLeftIn.start();
//
                    setLeftIn.start();
                    isBackVisible = true;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            so();
                        }
                    },  5000);
                    // DoSomething();
                }

            }
        });
    }

    public void so()
    {
        Intent intent = new Intent(Flip1.this, SignupActivity.class);
        startActivity(intent);
    }
}
