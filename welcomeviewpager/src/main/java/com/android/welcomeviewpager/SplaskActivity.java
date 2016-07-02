package com.android.welcomeviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SplaskActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLayout;
    private List<ImageView> list;
    private MyAdapter adapter;
    private int preposition=0;
    private int[] imgs={R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splask);
        initView();
        setData();
        setListener();
    }

    private void setListener() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mLayout.getChildAt(position).setBackgroundResource(R.drawable.dot_enable);
                mLayout.getChildAt(preposition).setBackgroundResource(R.drawable.dot_normal);
                preposition=position;
                if(position==2){
                    Intent intent=new Intent(SplaskActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setData() {
        list=new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv=new ImageView(this);
            iv.setBackgroundResource(imgs[i]);
            list.add(iv);
            final View view=new View(this);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(30,30);
            params.leftMargin=6;
            view.setBackgroundResource(R.drawable.dot_normal);
            view.setLayoutParams(params);
            view.setTag(i);
            mLayout.addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position= (int) view.getTag();
                    mViewPager.setCurrentItem(position);
                }
            });
        }

        mLayout.getChildAt(0).setBackgroundResource(R.drawable.dot_enable);
        adapter=new MyAdapter(list);
        mViewPager.setAdapter(adapter);
    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.vpSplash);
        mLayout= (LinearLayout) findViewById(R.id.llPoints);
    }
}
