package com.android.welcomeviewpager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView mImageView;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        mImageView = (ImageView) findViewById(R.id.iv);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean isFirst=sp.getBoolean("isFirst",true);
                if(isFirst){
                    Intent intent=new Intent(WelcomeActivity.this,SplaskActivity.class);
                    startActivity(intent);
                    finish();
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("isFirst",false);
                    editor.commit();
                }else{
                    Intent intent = new Intent(WelcomeActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
